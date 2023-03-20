from fastapi import HTTPException
import httpx


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
