# CMS

## Technologies

- Java 21
- Docker
- Quarkus
- Twitter Bootstrap

## Local development

### Prerequisites

You need to have the following software installed locally:

- [Git](https://git-scm.com/) and [Git LFS](https://git-lfs.github.com/)
- [OpenJDK 21](https://adoptium.net/temurin/releases)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Docker](https://docs.docker.com/docker-for-mac/install/)

#### Docker

Please make sure to enable [Rosetta emulation](https://docs.docker.com/desktop/settings/mac) if you are using an Apple Silicon Mac

### IntelliJ IDEA Setup

We use various plugins for code quality in our project.

#### Annotation Processing

Enable Annotation Processing for [Immutables](https://immutables.github.io/apt.html)

### Local setup

#### Running the application

For the first time run:

```shell script
./mvnw install -DskipTests
```

Next, run the application locally with the quarkus dev plugin, the database and Keycloak server will be automatically started for you:

```shell script
./mvnw quarkus:dev
```

Run the entire test suite and all checks with the following command:

```shell script
./mvnw verify
```

#### Local configuration of the application

For configuring the application locally we use an environment file. You can duplicate the provided template
file [.env-sample](cms-webapp/.env-sample)  as `.env` for your desired settings.

#### Persisting data in the database
To persist the database provisioned using devservices you can enable the `Reusable Containers` feature in `~/.testcontainers.properties` by adding `testcontainers.reuse.enable=true`.

Note: Also make sure that flyway is not doing a database clean up at start time, by setting `_DEV_QUARKUS_FLYWAY_CLEAN_AT_START` to false.

