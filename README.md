# lzc

# 사용한 개발 언어 : java
# 사용한 프레임 워크 : spring boot
# 사용한 RDBMS : h2
  

# 데이터 설계 

Employee 직원 테이블
--
CREATE TABLE employee (
id BIGINT not null auto_increment PRIMARY KEY,
employee_no VARCHAR(50) UNIQUE NOT NULL,
employee_name VARCHAR(100) NOT NULL,
create_at DATETIME NOT NULL,
mod_at DATETIME,
del_at DATETIME
);


Lecture 강연 테이블
--
CREATE TABLE lecture (
id BIGINT not null auto_increment PRIMARY KEY,
lecture_hall_id BIGINT not null,
name VARCHAR(50) NOT NULL,
lecturer VARCHAR(100) NOT NULL,
max_applicant INT(11) not null,
time DATETIME not null,
contents VARCHAR(200) not null,
create_at DATETIME NOT NULL,
mod_at DATETIME,
del_at DATETIME,
FOREIGN KEY (lecture_hall_id) REFERENCES lecture_hall(lecture_hall_id)
);

LectureHall 강연장 테이블
-- 
CREATE TABLE lecture_hall (
id BIGINT not null auto_increment PRIMARY KEY,
name VARCHAR(50) NOT NULL,
create_at DATETIME NOT NULL,
mod_at DATETIME,
del_at DATETIME
);


Registration 강의신청 테이블
-- 
CREATE TABLE registration (
id BIGINT not null auto_increment PRIMARY KEY,
lecture_id BIGINT not null,
employee_id BIGINT not null,
duplicateCheck VARCHAR(50) NOT NULL,
create_at DATETIME NOT NULL,
mod_at DATETIME,
del_at DATETIME
);

alter table registration
add constraint unique_employee_lecture UNIQUE (employee_id, lecture_id);


# 고민했던 부분
동시성 부분에서 고민
- 1인 1좌석 부분은 registration 의 duplicationCheck 컬럼으로 db 사이드에서 해결 한듯 함
- 최대 신청 인원 부분은 추후 redis 로 해결하면 가능하지 않을까 생각함

단위테스트 고민
- 최대한 많은 범위를 커버 하면 좋겠지만 시간이 가능한 범위까지 작성