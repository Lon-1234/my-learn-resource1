create table user
(
    id   int primary key auto_increment,
    name varchar(20) unique not null,
    age  int default 18 check ( age > 0 && age < 100 )
);

create table item
(
    id      int primary key auto_increment,
    title   text not null unique,
    user_id int  not null,
    constraint fk_user
    foreign key (user_id)
    references user (id)
)