WHERE 条件查询
大于
SELECT * FROM user
WHERE age > 18;
AND
SELECT * FROM user
WHERE age > 18 AND age < 30;
OR
SELECT * FROM user
WHERE age = 18 OR age = 20;
LIKE 模糊查询
SELECT * FROM user
WHERE name LIKE '%o%';

含义：

名字包含 o

ORDER BY
SELECT * FROM user
ORDER BY age DESC;

DESC：

降序

ASC：

升序
LIMIT 分页
SELECT * FROM user
LIMIT 0,10;

含义：

从第 0 条开始
查询 10 条

COUNT
SELECT COUNT(*) FROM user;

统计数量。

AVG
SELECT AVG(age) FROM user;

平均值。

MAX
SELECT MAX(age) FROM user;

最大值。

GROUP BY 分组
SELECT age, COUNT(*)
FROM user
GROUP BY age;