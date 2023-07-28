DROP TABLE IF EXISTS user;

CREATE TABLE user (
    chat_id VARCHAR(30),
    tg_tag VARCHAR(30),
    active BOOLEAN
);