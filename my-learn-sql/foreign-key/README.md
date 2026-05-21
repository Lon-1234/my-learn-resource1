# MySQL Constraint Demo

一个用于学习 MySQL 约束控制（Constraint）的练习仓库。

---

# 一、项目内容

本项目包含：

- PRIMARY KEY（主键约束）
- AUTO_INCREMENT（自增约束）
- NOT NULL（非空约束）
- UNIQUE（唯一约束）
- DEFAULT（默认值约束）
- CHECK（检查约束）
- FOREIGN KEY（外键约束）

通过创建表、插入正确数据、插入错误数据的方式学习 MySQL 约束控制。

---

# 二、项目结构

```text
my-learn-sql/foreign-key
│
├── README.md
├── sql_01_create_database_test.sql
├── sql_02_create_table.sql
├── sql_03_insert_success.sql
└── sql_04_insert_error.sql

---

三：删除数据库
drop database if exists test;