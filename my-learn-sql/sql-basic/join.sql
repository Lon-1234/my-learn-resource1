DROP DATABASE IF EXISTS test;

CREATE DATABASE test CHARACTER SET utf8mb4;

USE test;

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE NOT NULL,
    age INT DEFAULT 18 CHECK(age > 0 AND age < 100)
);

CREATE TABLE item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL UNIQUE,
    user_id INT NOT NULL,

    CONSTRAINT fk_user
    FOREIGN KEY(user_id)
    REFERENCES user(id)
);


INSERT INTO user(name, age)
VALUES 
('long', 20),
('admin', 22),
('tom', 18);

INSERT INTO item(title, user_id)
VALUES
('phone', 1),
('wallet', 1),
('book', 2);


SELECT * FROM user;
SELECT * FROM item;

--内连接
select u.id,u.name,i.title
from user as u inner join item as i on u.id = i.user_id;

--左连接
select u.id,u.name,i.title
from user as u right join item as i on u.id = i.user_id;

--右连接
select u.id,u.name,i.title
from user as u left join item as i on u.id = i.user_id;














