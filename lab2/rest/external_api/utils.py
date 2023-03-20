from fastapi import HTTPException
import httpx
from jsonschema import validate
from jsonschema.exceptions import ValidationError


async def async_request(url: str, method="GET", data=None, custom_msg="") -> httpx.Response:
    transport = httpx.AsyncHTTPTransport(retries=5)
    async with httpx.AsyncClient(transport=transport) as client:
        try:
            response = await client.request(method, url, json=data)
            response.raise_for_status()
        except httpx.RequestError as exc:
            print(f"An error occurred while requesting {exc.request.url!r}.")
            raise HTTPException(
                status_code=500,
                detail=f"An error occurred while requesting {exc.request.url!r}. {custom_msg}"
            )
        except httpx.HTTPStatusError as exc:
            print(f"Error response {exc.response.status_code} while requesting {exc.request.url!r}.")
            raise HTTPException(
                status_code=500,
                detail=f"Error response {exc.response.status_code} while requesting {exc.request.url!r}. {custom_msg}"
            )
    return response


def validate_json(instance, schema, url):
    try:
        validate(instance=instance, schema=schema)
    except ValidationError as ex:
        print(f"Error validating json response from {url}:\n{ex}")
        raise HTTPException(
            status_code=500,
            detail=f"Error while validating json response from {url}"
        )