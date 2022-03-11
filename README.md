# Jooq tutorial

Following Jooq [tutorial](https://www.jooq.org/doc/3.16/manual/getting-started/tutorials/jooq-in-7-steps/jooq-in-7-steps-step1/)

## Setting up Postgres DB

Use the [Postgres Docker container](https://hub.docker.com/_/postgres)

```
docker run -it -p 5430:5432 -e POSTGRES_PASSWORD=test -e POSTGRES_USER=postgres -e POSTGRES_DB=postgres postgres
```

Connect with psql (password `test`):

```
psql -U postgres -h localhost -p 5430 -d postgres
```

This [part](https://www.jooq.org/doc/3.16/manual/getting-started/tutorials/jooq-in-7-steps/jooq-in-7-steps-step2/) of the tutorial covers what set up is needed via psql.
