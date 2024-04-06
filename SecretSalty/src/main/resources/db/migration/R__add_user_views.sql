-- Registered user view
CREATE OR REPLACE VIEW registered_user AS
SELECT uuid,
       created,
       last_modified,
       email,
       display_name,
       icon,
       interests
FROM app_user
WHERE is_guest IS FALSE;

-- Guest view
CREATE OR REPLACE VIEW guest AS
SELECT uuid,
       created,
       last_modified,
       email,
       display_name,
       group_uuid,
       personal_invite
FROM app_user
WHERE is_guest IS TRUE;