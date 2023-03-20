from config import settings
from external_api.utils import async_request, validate_json
from external_api.schemas import regions_schema, plains_schema, prices_schema


async def get_countries() -> dict:
    response = await async_request(f"{settings.ITAD_API_BASE}/v01/web/regions/")
    response_json = response.json()
    validate_json(response_json, regions_schema, response.url)
    return response_json.get("data")


async def get_plains(wishlists: dict) -> dict:
    response = await async_request(
        f"{settings.ITAD_API_BASE}/v01/game/plain/id/?key={settings.ITAD_API_KEY}&shop=steam",
        method="POST",
        data=[f"app/{game['game_id']}" for wishlist in wishlists.values() for game in wishlist]
    )
    response_json = response.json()
    validate_json(response_json, plains_schema, response.url)
    return {k.strip("app/"): v for k, v in response_json["data"].items() if v}


async def get_prices(wishlists: dict, plains: dict, region: str, country: str) -> tuple:
    response = await async_request(
        f"{settings.ITAD_API_BASE}/v01/game/prices/?key={settings.ITAD_API_KEY}&region={region}&country={country}&"
        f"plains={','.join([plain for plain in plains.values()])}",
        method="GET",
    )
    response_json = response.json()
    validate_json(response_json, prices_schema, response.url)

    data = response_json["data"]
    for plain, game in list(data.items()):
        steam = None
        for deal in game["list"]:
            deal["price_new"] = format(deal["price_new"], ".2f")
            deal["price_old"] = format(deal["price_old"], ".2f")
            if deal["shop"]["id"] == "steam":
                steam = deal

        if steam:
            data[plain]["not_available_on_steam"] = False
            data[plain]["steam_regular_price"] = steam["price_old"]
            data[plain]["steam_new_price"] = steam["price_new"]
            data[plain]["steam_cut"] = steam["price_cut"]
            if game["list"][0]["shop"]["id"] != "steam":
                data[plain]["best_deal_diff"] = round(
                    (1 - float(game["list"][0]["price_new"]) / float(steam["price_old"])) * 100
                )
            else:
                data[plain]["best_deal_diff"] = steam["price_cut"]
        else:
            data[plain]["not_available_on_steam"] = True
            data[plain]["best_deal_diff"] = -1

    for app_id, wishlist in wishlists.items():
        for game in wishlist:
            game["best_deal_diff"] = data[plains[game["game_id"]]]["best_deal_diff"] if game["game_id"] in plains else 0

        wishlist.sort(key=lambda x: x["best_deal_diff"], reverse=True)

    return data, response_json[".meta"]["currency"]
