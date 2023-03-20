from config import settings
from external_api.utils import async_request
import json


async def get_countries() -> dict:
    response = await async_request(f"{settings.ITAD_API_BASE}/v01/web/regions/")
    response_json = response.json()
    return response_json.get("data")


async def get_plains(wishlists: dict) -> dict:
    response = await async_request(
        f"{settings.ITAD_API_BASE}/v01/game/plain/id/?key={settings.ITAD_API_KEY}&shop=steam",
        method="POST",
        data=[f"app/{game['game_id']}" for wishlist in wishlists.values() for game in wishlist]
    )
    response_json = response.json()
    return {k.strip("app/"): v for k, v in response_json.get("data").items() if v}


async def get_prices(wishlists: dict, plains: dict, region: str, country: str) -> tuple:
    response = await async_request(
        f"{settings.ITAD_API_BASE}/v01/game/prices/?key={settings.ITAD_API_KEY}&region={region}&country={country}&"
        f"plains={','.join([plain for plain in plains.values()])}",
        method="GET",
    )
    response_json = response.json()
    data = response_json.get("data")
    for plain, game in list(data.items()):
        steam = None
        for deal in game.get("list", []):
            deal["price_new"] = format(deal.get("price_new", 0), ".2f")
            deal["price_old"] = format(deal.get("price_old", 0), ".2f")
            if deal.get("shop", {}).get("id") == "steam":
                steam = deal

        if steam:
            data[plain]["not_available_on_steam"] = False
            data[plain]["steam_regular_price"] = steam.get("price_old", 0)
            data[plain]["steam_new_price"] = steam.get("price_new", 0)
            data[plain]["steam_cut"] = steam.get("price_cut", 0)
            if game["list"][0].get("shop", {}).get("id") != "steam":
                data[plain]["best_deal_diff"] = round(
                    (1 - float(game["list"][0].get("price_new", 0)) / float(steam.get("price_old", 1))) * 100
                )
            else:
                data[plain]["best_deal_diff"] = steam.get("price_cut", 0)
        else:
            data[plain]["not_available_on_steam"] = True
            data[plain]["best_deal_diff"] = -1

    for app_id, wishlist in wishlists.items():
        for game in wishlist:
            game["best_deal_diff"] = data[plains[game["game_id"]]]["best_deal_diff"] if game["game_id"] in plains else 0

        wishlist.sort(key=lambda x: x["best_deal_diff"], reverse=True)

    return data, response_json.get(".meta", {}).get("currency")
