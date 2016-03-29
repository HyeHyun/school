SELECT * FROM TEST;

DROP TABLE Member CASCADE CONSTRAINT;

CREATE TABLE Member(
	id VARCHAR2(30) NOT NULL, 
	name VARCHAR2(30) NOT NULL,
	password VARCHAR2(30) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER
);

INSERT INTO Member(id, name, password, addr, birth)
VALUES ('hong', '홍길동', '1', '서울', 800101);

INSERT INTO Member(id, name, password, addr, birth)
VALUES ('kim', '김유신', '1', '경기', 900203);

INSERT INTO Member(id, name, password, addr, birth)
VALUES ('kim2', '김유신', '1', 'LA', 850104);

INSERT INTO Member(id, name, password, addr, birth)
VALUES ('lee', '이순신', '1', '부산', 000909);

INSERT INTO Member(id, name, password, addr, birth)
VALUES ('song', '송중기', '1', '대전', 041001);

INSERT INTO Member
VALUES ('yoon', '윤하나', '1', '인천', 060505);

INSERT INTO Member
VALUES ('you', '유아인', '1', '강남', 860505);

SELECT * FROM Member;

SELECT * FROM Member
WHERE id = 'kim';

UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'hong';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'jun';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'computer' WHERE id = 'kim';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'kim2';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'lee';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'info' WHERE id = 'song';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'security' WHERE id = 'test';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'security' WHERE id = 'yoon';
UPDATE Member SET subject = 'java/jsp/sql/spring', major = 'security' WHERE id = 'you';


-- DDL 테이블 수정
-- 1. 컬럼 추가
ALTER TABLE Member ADD subject VARCHAR2(100); -- java/sql/spring
ALTER TABLE Member ADD major VARCHAR2(20); -- java/sql/spring
-- 2. 컬럼 수정 (이름)
ALTER TABLE Member RENAME COLUMN password TO pass;
-- 3. 컬럼 수정 (타입)
ALTER TABLE Member MODIFY birth(DATE);
