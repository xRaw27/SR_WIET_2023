from fastapi import FastAPI, Body, status
from fastapi.responses import JSONResponse
from pydantic import BaseModel
from collections import defaultdict

app = FastAPI()


class VoteBase(BaseModel):
    answer: str


class Vote(VoteBase):
    id: int


class VoteCreate(VoteBase):
    pass


class PollBase(BaseModel):
    question: str


class Poll(PollBase):
    id: int
    votes: dict[int, Vote] = {}


class PollCreate(PollBase):
    pass


CURRENT_POLL_ID = 0
CURRENT_VOTE_IDS = defaultdict(int)
polls: dict[int, Poll] = {}


def get_poll_id():
    global CURRENT_POLL_ID
    poll_id = CURRENT_POLL_ID
    CURRENT_POLL_ID += 1
    return poll_id


def get_vote_id(poll_id: int):
    global CURRENT_VOTE_IDS
    vote_id = CURRENT_VOTE_IDS[poll_id]
    CURRENT_VOTE_IDS[poll_id] += 1
    return vote_id


@app.get("/poll/")
async def get_polls():
    print(polls)
    return polls


@app.get("/poll/{id}/")
async def get_poll(poll_id: int):
    poll_dict = polls.get(poll_id)
    if poll_dict:
        return poll_dict
    else:
        return JSONResponse(status_code=status.HTTP_404_NOT_FOUND, content={"error": "Poll not found"})


@app.post("/poll/")
async def create_poll(poll_create: PollCreate):
    poll = Poll(**poll_create.dict(), id=get_poll_id())
    polls.update({poll.id: poll})
    return poll


@app.get("/poll/{poll_id}/vote/")
async def get_votes(poll_id: int):
    poll = polls.get(poll_id)
    if not poll:
        return JSONResponse(status_code=status.HTTP_404_NOT_FOUND, content={"error": "Poll not found"})
    return poll.votes


@app.post("/poll/{poll_id}/vote/")
async def create_vote(poll_id: int, vote_create: VoteCreate):
    poll = polls.get(poll_id)
    if not poll:
        return JSONResponse(status_code=status.HTTP_404_NOT_FOUND, content={"error": "Poll not found"})
    vote = Vote(**vote_create.dict(), id=get_vote_id(poll_id))
    poll.votes.update({vote.id: vote})
    return vote
