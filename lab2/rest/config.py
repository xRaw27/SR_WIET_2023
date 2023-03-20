from pydantic import BaseSettings


class Settings(BaseSettings):
    APP_NAME: str = "Steam wishlist prices API"
    STEAM_API_BASE: str = "https://api.steampowered.com"
    STEAM_API_2_BASE: str = "https://store.steampowered.com"
    ITAD_API_BASE: str = "https://api.isthereanydeal.com"
    ITAD_API_KEY: str
    STEAM_API_KEY: str
    IS_DEV: bool

    class Config:
        env_file = ".env"


settings = Settings()
