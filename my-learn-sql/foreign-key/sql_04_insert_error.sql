# 非空错误
insert into user (name, age)
values (null, 20);

# unique 插入字段值不唯一错误
insert into user (name, age)
values ('long', 20);
# check 插入字段值不符合要求错误
insert into user (name, age)
values ('long', -1);
# 外键错误
insert into item (title, user_id)
values ('钱包', 999);