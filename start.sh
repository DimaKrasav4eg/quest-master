#!/bin/bash

mvn clean install

docker-compose stop

export BOT_NAME=$1
export BOT_TOKEN=$2

docker-compose up --build --detach