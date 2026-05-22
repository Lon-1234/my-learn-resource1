
create  database test;
use test;

create table user(
    id int primary key auto_increment comment "用户id唯一自增",
    name varchar(20) unique not null comment "用户名唯一且不能为空",
    age int default 18 check ( age > 0 && age < 100 )comment "用户年龄在0到100之间"
)comment "用户表";

create table item(
    id int primary key auto_increment comment "物品id唯一自增",
    title text not null comment "物品标题不能为空",
    user_id int not null comment "物品所属用户id不能为空"
)comment "物品表";
show databases;
show tables;
desc user;
drop table item;

