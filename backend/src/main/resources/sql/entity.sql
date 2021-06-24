drop if exists table user;
create table user(
userId int auto_increment primary key,
username varchar(255),
password varchar(255),
age int,
gender varchar(255)
);

drop if exists table history
create table history(
historyId int auto_increment primary key,
date Date,
userId int,
username varchar(255),
messageType varchar(255),
message varchar(255)
)
