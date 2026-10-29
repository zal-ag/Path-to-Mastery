USE student_management;

-- 查询所有学生的学号、姓名、班级名称、班主任，保留未分班学生，按学号排序
SELECT s.id,s.name AS student_name,c.name AS class_name,c.teacher
FROM student AS s
LEFT JOIN school_class AS c
ON s.class_id = c.id
ORDER BY s.id ASC;

-- 统计各班总人数，保留空班级，按班级编号排序
SELECT c.name,COUNT(s.id) AS student_count
FROM school_class AS c
LEFT JOIN student AS s
ON c.id = s.class_id
GROUP BY c.id,c.name
ORDER BY c.id ASC;

-- 统计各班成年学生人数，保留空班级，按班级编号排序
SELECT c.name,COUNT(age) AS adult_count
FROM school_class AS c
LEFT JOIN student AS s
ON c.id = s.class_id AND s.age >= 18
GROUP BY c.id,c.name
ORDER BY c.id ASC;

SELECT id, name, age, address
FROM student
WHERE id = 'tx001' OR id = 'tx002' OR id = 'tx_missing';

INSERT INTO student (id, name, age, address)
VALUES ('tx001', '事务甲', 20, '北京');

INSERT INTO student (id, name, age, address)
VALUES ('tx002', '事务乙', 21, '上海');

SELECT id, name, age
FROM student
WHERE id = 'tx001' OR id = 'tx002'
ORDER BY id;