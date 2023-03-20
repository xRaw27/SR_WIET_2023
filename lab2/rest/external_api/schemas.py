steam_profile_schema = {
    "type": "object",
    "properties": {
        "response": {
            "type": "object",
            "properties": {
                "players": {
                    "type": "array",
                    "items": {
                        "type": "object",
                        "properties": {
                            "steamid": {"type": "string"},
                            "personaname": {"type": "string"},
                            "profileurl": {"type": "string"},
                            "avatar": {"type": "string"},
                        },
                        "required": ["steamid", "personaname", "profileurl", "avatar"],
                    },
                },
            },
            "required": ["players"],
        },
    },
    "required": ["response"],
}

wishlist_schema = {
    "type": "object",
    "patternProperties": {
        "^[0-9]+$": {
            "type": "object",
            "properties": {
                "name": {"type": "string"},
                "capsule": {"type": "string"},
            },
            "required": ["name"],
        }
    },
}

regions_schema = {
    "type": "object",
    "properties": {
        "data": {
            "type": "object",
            "patternProperties": {
                "^[a-zA-Z0-9]+$": {
                    "type": "object",
                    "properties": {
                        "countries": {
                            "type": "array",
                            "items": {"type": "string"},
                        },
                        "currency": {
                            "type": "object",
                            "properties": {
                                "code": {"type": "string"},
                            },
                            "required": ["code"],
                        },
                    },
                    "required": ["countries", "currency"],
                }
            },
        },
    },
    "required": ["data"],
}

plains_schema = {
    "type": "object",
    "properties": {
        "data": {
            "type": "object",
            "patternProperties": {
                "^app_[0-9]+$": {"type": "string"}
            },
        },
    },
    "required": ["data"],
}

prices_schema = {
    "type": "object",
    "properties": {
        ".meta": {
            "type": "object",
            "properties": {
                "currency": {"type": "string"},
            },
            "required": ["currency"],
        },
        "data": {
            "type": "object",
            "patternProperties": {
                "^[a-z]+$": {
                    "type": "object",
                    "properties": {
                        "list": {
                            "type": "array",
                            "items": {
                                "type": "object",
                                "properties": {
                                    "price_new": {"type": "number"},
                                    "price_old": {"type": "number"},
                                    "price_cut": {"type": "number"},
                                    "url": {"type": "string"},
                                    "shop": {
                                        "type": "object",
                                        "properties": {
                                            "id": {"type": "string"},
                                            "name": {"type": "string"},
                                        },
                                        "required": ["id", "name"],
                                    },
                                },
                                "required": ["price_new", "price_old", "price_cut", "url", "shop"],
                            },
                        },
                    },
                    "required": ["list"],
                }
            },
        },
    },
    "required": [".meta", "data"],
}
