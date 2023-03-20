from fastapi import FastAPI, Request, HTTPException
from fastapi.responses import HTMLResponse
from fastapi.templating import Jinja2Templates
from external_api.steam_api import get_wishlist, get_profile
from external_api.is_there_any_deal_api import get_countries, get_plains, get_prices
import asyncio

app = FastAPI()

templates = Jinja2Templates(directory="templates")


@app.get("/", response_class=HTMLResponse)
async def get_home(request: Request):
    countries = await get_countries()
    return templates.TemplateResponse("home.html", {"request": request, "countries": countries})


@app.get("/wishlist_deals/", response_class=HTMLResponse)
async def wishlist_deals(request: Request, steam_ids: str, country: str):
    if "-" not in country:
        raise HTTPException(
            status_code=422,
            detail={"detail": [{"loc": ["query", "country"], "msg": "country code should contain '-'"}]}
        )

    profiles = {}
    await asyncio.gather(*[get_profile(steam_id, profiles) for steam_id in steam_ids.split(",")])

    wishlists = {}
    await asyncio.gather(*[get_wishlist(steam_id, wishlists) for steam_id in profiles.keys()])

    plains = await get_plains(wishlists)
    if not plains:
        raise HTTPException(status_code=500, detail={"detail": "External api returned empty data"})

    prices, currency = await get_prices(wishlists, plains, *country.split('-'),)
    if not prices or not currency:
        raise HTTPException(status_code=500, detail={"detail": "External api returned empty data"})

    return templates.TemplateResponse(
        "result.html",
        {
            "request": request,
            "profiles": profiles,
            "wishlists": wishlists,
            "plains": plains,
            "prices": prices,
            "currency": currency
        }
    )
