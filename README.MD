[![Build Status](https://travis-ci.org/0k6r/Shorter.svg?branch=master)](https://travis-ci.org/0k6r/Shorter)
[![codecov](https://codecov.io/gh/0k6r/Shorter/branch/master/graph/badge.svg)](https://codecov.io/gh/0k6r/Shorter)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/0k6r/Shorter/master/LICENSE)

## URL Shortener

Kotlin microservice project for URL lings cutting.

## Docker
Create database from docker container:

    ```
    $ docker run --name pgsql-test -e POSTGRES_PASSWORD=password -d -p 6000:5432 postgres
    ```
    
* --name -> docker container name
* -e POSTGRES_PASSWORD -> database password
* -d -> run container in background and print container ID
* -p 6000:5432 -> throw a container port with 5432 to 6000 (5432 default PostgreSQL port)