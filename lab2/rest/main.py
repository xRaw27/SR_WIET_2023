from fastapi import FastAPI
from typing import Union
from pydantic import BaseModel
from fastapi.responses import JSONResponse
from fastapi import Body, FastAPI, status

app = FastAPI()


class Vote(BaseModel):
    id: Union[str, None] = None
    answer: str


class Poll(BaseModel):
    id: Union[str, None] = None
    question: str
    votes: list[Vote] = []


CURRENT_ID = 0
polls: {int: Poll} = {}


def get_id():
    global CURRENT_ID
    _id = CURRENT_ID
    CURRENT_ID += 1
    return _id


@app.get("/poll/")
async def get_polls():
    return polls


@app.get("/poll/{id}")
async def get_poll(id: int):
    poll_dict = polls.get(id)
    if poll_dict:
        return JSONResponse(status_code=status.HTTP_200_OK, content=poll_dict)
    else:
        return JSONResponse(status_code=status.HTTP_404_NOT_FOUND, content={"error": "Poll not found"})


@app.post("/poll/")
async def create_poll(poll: Poll):
    poll_dict = poll.dict()
    poll_dict["id"] = get_id()
    polls.update({poll_dict["id"]: poll_dict})
    return JSONResponse(status_code=status.HTTP_201_CREATED, content=poll_dict)


@app.get("/poll/{id}/vote")
async def get_polls(id: int):
    poll_dict = polls.get(id)
    if poll_dict:
        return JSONResponse(status_code=status.HTTP_200_OK, content=poll_dict["votes"])
    else:
        return JSONResponse(status_code=status.HTTP_404_NOT_FOUND, content={"error": "Poll not found"})


@app.post("/poll/{id}/vote/")
async def get_polls(id: int, vote: Vote):
    poll_dict = polls.get(id)
    id = len(poll_dict["votes"])
    poll_dict["votes"].append({"id": id, "answer": vote})
    return poll_dict["votes"][id]
