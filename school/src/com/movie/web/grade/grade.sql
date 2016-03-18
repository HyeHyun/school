DROP SEQUENCE hak_seq;

CREATE SEQUENCE hak_seq START WITH 2016001 INCREMENT BY 1; -- 시퀀스 생성

DROP TABLE Grade CASCADE; -- CASCADE : 테이블을 지우면서 관련된 것 전부 지움

CREATE TABLE Grade(
	hak	NUMBER PRIMARY KEY,
	id VARCHAR2(30) NOT NULL, 
	java NUMBER NOT NULL,
	sql NUMBER NOT NULL,
	jsp NUMBER NOT NULL,
	spring NUMBER NOT NULL
);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak_seq.NEXTVAL, 'hong', 80, 80, 80, 60);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak_seq.NEXTVAL, 'kim', 50, 70, 50, 60);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak_seq.NEXTVAL, 'kim2', 30, 30, 40, 50);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak_seq.NEXTVAL, 'lee', 55, 50, 60, 35);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak_seq.NEXTVAL, 'song', 30, 20, 10, 20);

INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak_seq.NEXTVAL, 'yoon', 100, 90, 100, 95);

SELECT * FROM Grade;

SELECT * FROM Grade WHERE id = 'song';