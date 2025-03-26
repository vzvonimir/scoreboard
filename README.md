# Live Football World Cup Scoreboard

This is a simple Java library that simulates a live World Cup football scoreboard.

## Features

- Start a new match
- Update match scores
- Finish (remove) a match
- Get a summary of matches in progress, ordered by:
  1. Total score (descending)
  2. Most recently started (if scores are equal)

## Project Notes

- Each match has a unique `UUID` used to identify and update/remove matches
- Matches are stored in-memory using a `List<Match>`
- The order in which matches are added to the list is used to represent **start time**
- `getSummary()` sorts matches based on:
  1. Total score (descending)
  2. Most recently started (if total scores are equal)

## Tech Stack

- Java 17
- Maven
- JUnit 5

## How to Run Tests 

Run the following command from the project root:  mvn test


