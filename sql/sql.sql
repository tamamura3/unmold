set names utf8;
set foreign_key_checks = 0;

DROP DATABASE IF EXISTS overflowing;
CREATE DATABASE IF NOT EXISTS overflowing;
USE overflowing;

CREATE TABLE T_USER (
id bigserial NOT NULL PRIMARY KEY,
name VARCHAR[15],
mail VARCHAR[200],
password VARCHAR[300],
is_deleted smallint DEFAULT 0
);

CREATE TABLE T_CHALLENGE(
id bigserial NOT NULL PRIMARY KEY,
challenge_name VARCHAR[100],
description VARCHAR[1000]);


CREATE TABLE review(
id bigserial PRIMARY KEY,
user_id VARCHAR[5],
challenge_id VARCHAR[5],
review_text VARCHAR[3000]);

CREATE TABLE register(
id bigserial PRIMARY KEY,
name VARCHAR[15],
mail VARCHAR[200],
password VARCHAR[300],
token VARCHAR[100],
date TIMESTAMP NOT NULL,
flag smallint DEFAULT 0
);

CREATE TABLE achievement(
id bigserial PRIMARY KEY,
user_id VARCHAR[5],
challenge_id VARCHAR[5]
);

CREATE TABLE reset_pass(
id bigserial PRIMARY KEY,
user_id VARCHAR[5],
mail VARCHAR[100],
token VARCHAR[100],
date TIMESTAMP NOT NULL,
flag smallint DEFAULT 0
);
