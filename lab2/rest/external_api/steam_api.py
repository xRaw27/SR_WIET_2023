from fastapi import HTTPException
from config import settings
from external_api.utils import async_request


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

    response_players = response2.json().get("response", {}).get("players", [])
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
    profiles[response_players[0].get("steamid", steam_id)] = response_players[0]


async def get_wishlist(steam_id: str, wishlists: dict) -> None:
    response = await async_request(
        f"{settings.STEAM_API_2_BASE}/wishlist/profiles/{steam_id}/wishlistdata"
    )
    response_json = response.json()

    wishlist = []
    for game_id, game_info in response_json.items():
        wishlist.append({
            "game_id": game_id,
            "game_name": game_info.get("name"),
            "game_image": game_info.get("capsule")
        })
    wishlists[steam_id] = wishlist
