SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments(
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 employee_count int
 );

CREATE TABLE IF NOT EXISTS users(
id int PRIMARY KEY auto_increment,
name VARCHAR,
position VARCHAR,
role vARCHAR,
department_id int
);

CREATE TABLE IF NOT EXISTS news(
id int PRIMARY KEY auto_increment,
title VARCHAR,
content VARCHAR,
author VARCHAR,
department_id int
);