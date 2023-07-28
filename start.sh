#!/bin/bash

docker-compose stop
docker-compose -f docker-compose-test.yml down
#TODO replace sleep
docker-compose -f docker-compose-test.yml up -d && sleep 10
mvn clean install
docker-compose -f docker-compose-test.yml down

export BOT_NAME=$1
export BOT_TOKEN=$2
export DB_USERNAME=$3
export DB_PASSWORD=$4

docker-compose up --build --detach