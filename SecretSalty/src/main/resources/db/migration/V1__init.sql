CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE app_user
(
    uuid            UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    created         TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    email           VARCHAR UNIQUE                      NOT NULL,
    display_name    VARCHAR                             NOT NULL,
    icon            VARCHAR                             NOT NULL,
    interests       VARCHAR,
    is_guest        BOOLEAN   DEFAULT FALSE             NOT NULL,
    group_uuid      UUID,
    personal_invite VARCHAR
);

CREATE TABLE app_group
(
    uuid           UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    name           VARCHAR                             NOT NULL,
    created        TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    invite         VARCHAR                             NOT NULL,
    status         BIGINT                              NOT NULL,
    admin_uuid     UUID REFERENCES "app_user" (uuid)   NOT NULL,
    budget         bigint,
    description    VARCHAR,
    selection_date DATE,
    reminder       BOOLEAN,
    unlikely_count BIGINT
);

ALTER TABLE "app_user"
    ADD CONSTRAINT fk_guest_group_id FOREIGN KEY (group_uuid) REFERENCES app_group (uuid);

CREATE TABLE app_participant
(
    group_uuid    UUID REFERENCES "app_group" (uuid),
    user_uuid     UUID REFERENCES "app_user" (uuid),
    created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    excluded      UUID REFERENCES "app_user" (uuid),
    avoid         UUID REFERENCES "app_user" (uuid),
    interests     VARCHAR,
    bengerl_uuid  UUID REFERENCES "app_user" (uuid)
);