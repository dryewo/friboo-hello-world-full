-- name: get-all-greetings
SELECT g_id,
       g_template
  FROM fh_data.greeting
 ORDER BY g_id ASC;

-- name: get-greeting
SELECT g_id,
       g_template
  FROM fh_data.greeting
 WHERE g_id = :id;

-- name: create-or-update-greeting!
WITH greeting_update AS (
     UPDATE fh_data.greeting
        SET g_template = :template
      WHERE g_id = :id
  RETURNING g_id
)
INSERT INTO fh_data.greeting (
            g_id,
            g_template
            )
     SELECT :id,
            :template
      WHERE NOT EXISTS(SELECT 1 FROM greeting_update);

-- name: delete-greeting!
DELETE FROM fh_data.greeting WHERE g_id = :id;
