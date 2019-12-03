--SET MODE PostgreSQL;
CREATE DATABASE org;
\c org;

CREATE TABLE IF NOT EXISTS departments(
 id SERIAL PRIMARY KEY,
 name VARCHAR,
 description VARCHAR,
 employee_count int
 );

CREATE TABLE IF NOT EXISTS users(
 id SERIAL PRIMARY KEY,
name VARCHAR,
designation VARCHAR,
role vARCHAR,
department_id int
);

CREATE TABLE IF NOT EXISTS news(
 id SERIAL PRIMARY KEY,
title VARCHAR,
content VARCHAR,
author VARCHAR,
department_id int
);

CREATE DATABASE org_test WITH TEMPLATE org;