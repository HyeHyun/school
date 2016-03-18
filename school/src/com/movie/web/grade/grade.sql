CREATE TABLE Grade(
	hak	NUMBER PRIMARY KEY,
	id VARCHAR2(30) NOT NULL, 
	java NUMBER NOT NULL,
	sql NUMBER NOT NULL,
	jsp NUMBER NOT NULL,
	spring NUMBER NOT NULL
);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (1601, 'hong', 80, 50, 90, 60);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (1602, 'kim', 60, 70, 50, 60);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (1603, 'lee', 55, 80, 70, 70);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (1604, 'song', 30, 60, 80, 50);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (1605, 'yoon', 70, 70, 100, 80);

SELECT * FROM Grade;