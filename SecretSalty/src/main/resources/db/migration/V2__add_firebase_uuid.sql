ALTER TABLE "app_user"
    ADD COLUMN firebase_uid VARCHAR;
ALTER TABLE "app_user"
    ADD UNIQUE (firebase_uid);

ALTER TABLE "app_group"
    ADD UNIQUE (invite)