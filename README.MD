## URL Shortener

Kotlin microservice project for URL lings cutting.

## Docker
Run database:

    ```
    $ docker run --name pgsql-test -e POSTGRES_PASSWORD=password -d -p 6000:5432 postgres
    ```
    
* --name -> docker container name
* -e POSTGRES_PASSWORD -> database password
* -d -> run container in background and print container ID
* -p 6000:5432 -> throw a container port with 5432 to 6000 (5432 default PostgreSQL port)