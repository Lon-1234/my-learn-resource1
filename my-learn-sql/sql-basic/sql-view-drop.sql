use test;

create view user_it as
    select user.id,user.name,item.title
 from user join item on user.id = item.user_id;

show tables;

desc user_it;
show create table user_it;

#修改视图
CREATE OR REPLACE VIEW user_it AS
SELECT
    user.id AS user_id,
    item.id AS item_id,
    user.name AS user_name,
    item.title AS item_title
FROM user
         LEFT JOIN item
                   ON user.id = item.user_id
WHERE user.age > 18;

drop view if exists user_it;
