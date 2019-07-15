# employee-postgres
`employee-postgres` is an employee resource CRUD service which utilize Postgres database as a datasource.
# Running in local with build-in compose
Running application using docker compose : `docker-compose up`

Accessing Postgres Database PSQL : `docker exec -it postgres-employee psql -U local employee`

# Running in standalone in local

Spin up Postgres database locally : `docker-compose -f ./local/docker-compose.yml up`

Start application.
* Using IDE 
* Using gradle : `./gradlew bootRun`
