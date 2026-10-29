-- 启用数据库
USE student_management;

-- 查询钱七
SELECT id,name,class_id
FROM student
WHERE id = '1005';

-- 查询班级3
SELECT id,name
FROM school_class
WHERE id = 3;

-- 开始事务
START TRANSACTION;

-- 修改钱七的班级
UPDATE student
SET class_id = 3
WHERE id = '1005';

-- 查看修改结果
SELECT s.id,
s.name AS student_name,
c.name AS class_name,
teacher
FROM student AS s
LEFT JOIN school_class AS c
ON s.class_id = c.id
WHERE s.id = '1005';

-- 修改正确，提交
COMMIT;

-- 提交后检查
SELECT id,name,class_id
FROM student
WHERE id = '1005';

-- 再次查询各班总人数
SELECT c.name AS class_name,
COUNT(s.id) AS student_count
FROM school_class AS c
LEFT JOIN student AS s
ON c.id = s.class_id
GROUP BY c.id,c.name
ORDER BY c.id;

-- 再次查询各班成年人数
SELECT c.name AS class_name,
COUNT(age) AS adult_count
FROM school_class AS c
LEFT JOIN student AS s
ON c.id = s.class_id AND age >= 18
GROUP BY c.id,c.name
ORDER BY c.id;