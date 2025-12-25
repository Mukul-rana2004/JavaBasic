CREATE TABLE IF NOT EXISTS Students (
  rollNo INT PRIMARY KEY,
  name VARCHAR(100),
  marks1 INT,
  marks2 INT,
  marks3 INT
);
INSERT INTO Students (rollNo, name, marks1, marks2, marks3) VALUES (12, 'rishu', 324, 43, 534);
SELECT * FROM Students;
