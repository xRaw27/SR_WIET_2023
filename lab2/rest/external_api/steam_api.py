from fastapi import HTTPException
from config import settings
from external_api.utils import async_request, validate_json
from external_api.schemas import steam_profile_schema, wishlist_schema


async def get_profile(steam_id: str, profiles: dict) -> None:
    response = await async_request(
        f"{settings.STEAM_API_BASE}/ISteamUser/ResolveVanityURL/v1?key={settings.STEAM_API_KEY}&vanityurl={steam_id}"
    )
    response_json = response.json().get("response", {})

    steam_id64 = None
    if response_json.get("success", 0) == 1:
        steam_id64 = response_json.get("steamid")

    response2 = await async_request(
        f"{settings.STEAM_API_BASE}/ISteamUser/GetPlayerSummaries/v0002/?key={settings.STEAM_API_KEY}&"
        f"steamids={steam_id64 if steam_id64 else steam_id}"
    )

    validate_json(response2.json(), steam_profile_schema, response2.url)

    response_players = response2.json()["response"]["players"]
    if len(response_players) == 0:
        raise HTTPException(
            status_code=422,
            detail={
                "detail": [
                    {
                        "loc": ["query", "steam_ids"],
                        "msg": f"{steam_id} is not a valid SteamID or SteamID64"
                    }
                ]
            }
        )
    profiles[response_players[0]["steamid"]] = response_players[0]


async def get_wishlist(steam_id: str, wishlists: dict) -> None:
    response = await async_request(
        f"{settings.STEAM_API_2_BASE}/wishlist/profiles/{steam_id}/wishlistdata"
    )
    response_json = response.json()
    validate_json(response_json, wishlist_schema, response.url)

    wishlist = []
    for game_id, game_info in response_json.items():
        wishlist.append({
            "game_id": game_id,
            "game_name": game_info["name"],
            "game_image": game_info["capsule"]
        })
    wishlists[steam_id] = wishlist
