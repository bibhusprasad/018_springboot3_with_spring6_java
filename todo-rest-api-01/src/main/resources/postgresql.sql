insert into todo (id, username, description, target_date, completed)
values(10001,'bibhu', 'Get AWS Certified', current_timestamp, false);

insert into todo (id, username, description, target_date, completed)
values(10002,'bibhu', 'Get Azure Certified', current_timestamp, false);

insert into todo (id, username, description, target_date, completed)
values(10003,'bibhu', 'Get GCP Certified', current_timestamp, false);

insert into todo (id, username, description, target_date, completed)
values(10004,'bibhu', 'Learn DevOps', current_timestamp, false);


ALTER TABLE todo
    ALTER COLUMN completed DROP DEFAULT,
ALTER COLUMN completed TYPE BOOLEAN USING completed::BOOLEAN,
    ALTER COLUMN completed SET DEFAULT FALSE;