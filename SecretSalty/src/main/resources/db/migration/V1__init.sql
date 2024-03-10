CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE "user"
(
    uuid          UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    email         VARCHAR UNIQUE                      NOT NULL,
    display_name  VARCHAR                             NOT NULL
);

CREATE TABLE registered_user
(
    icon      VARCHAR NOT NULL,
    interests VARCHAR
) INHERITS ("user");

CREATE TABLE "group"
(
    uuid           UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    name           VARCHAR                             NOT NULL,
    created        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    invite         VARCHAR                             NOT NULL,
    status         BIGINT                              NOT NULL,
    admin_id       UUID REFERENCES "user" (uuid)       NOT NULL,
    budget         REAL,
    description    VARCHAR,
    selection_date DATE,
    reminder       BOOLEAN,
    unlikely_count BIGINT
);

CREATE TABLE guest_user
(
    group_id        UUID REFERENCES "group" (uuid) NOT NULL,
    personal_invite VARCHAR                        NOT NULL
) INHERITS ("user");

CREATE TABLE participant
(
    group_id      UUID REFERENCES "group" (uuid),
    user_id       UUID REFERENCES "user" (uuid),
    created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    excluded      UUID REFERENCES "user" (uuid),
    avoid         UUID REFERENCES "user" (uuid),
    interests     VARCHAR,
    bengerl_id    UUID REFERENCES "user" (uuid)
);