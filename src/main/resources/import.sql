insert into employee(`no`, `name`, create_at) values ('00001', '첫번째사원', now());
insert into employee(`no`, `name`, create_at) values ('00002', '두번째사원', now());
insert into employee(`no`, `name`, create_at) values ('00003', '세번째사원', now());
insert into employee(`no`, `name`, create_at) values ('00004', '네번째사원', now());
insert into employee(`no`, `name`, create_at) values ('00005', '다섯번째사원', now());


insert into lecture_hall(`name`, create_at) values ('가가가 강연장', now());
insert into lecture_hall(`name`, create_at) values ('나나나 강연장', now());


insert into lecture(`lecture_hall_id`,`name`,lecturer, max_applicant, `time`, contents,  create_at) values((SELECT lh.id FROM lecture_hall lh limit 1), '기본 테스트1 강연', '테스트 강연자1', 50, now(), '테스트1 강연 입니다!!', now());
insert into lecture(`lecture_hall_id`,`name`,lecturer, max_applicant, `time`, contents,  create_at) values((SELECT lh.id FROM lecture_hall lh limit 1), '기본 테스트2 강연', '테스트 강연자2', 30, now(), '테스트2 강연 입니다!!', now());
insert into lecture(`lecture_hall_id`,`name`,lecturer, max_applicant, `time`, contents,  create_at) values((SELECT lh.id FROM lecture_hall lh limit 1,1), '기본 테스트3 강연', '테스트 강연자3', 3, now(), '테스트3 강연 입니다!!', now());


insert into registration(`lecture_id`, `employee_id`, `duplicate_check`, `create_at`) values ((select l.id from lecture l order by l.id asc limit 1), (select e.id from employee e order by e.id asc limit 1), concat((select l.id from lecture l order by l.id asc limit 1),'_',(select e.id from employee e order by e.id asc limit 1)), now());
insert into registration(`lecture_id`, `employee_id`, `duplicate_check`, `create_at`) values ((select l.id from lecture l order by l.id asc limit 1), (select e.id from employee e order by e.id asc limit 1,1), concat((select l.id from lecture l order by l.id asc limit 1),'_',(select e.id from employee e order by e.id asc limit 1,1)), now());
insert into registration(`lecture_id`, `employee_id`, `duplicate_check`, `create_at`) values ((select l.id from lecture l order by l.id asc limit 1), (select e.id from employee e order by e.id asc limit 2,1), concat((select l.id from lecture l order by l.id asc limit 1),'_',(select e.id from employee e order by e.id asc limit 2,1)), now());
insert into registration(`lecture_id`, `employee_id`, `duplicate_check`, `create_at`) values ((select l.id from lecture l order by l.id asc limit 1), (select e.id from employee e order by e.id asc limit 3,1), concat((select l.id from lecture l order by l.id asc limit 1),'_',(select e.id from employee e order by e.id asc limit 3,1)), now());

insert into registration(`lecture_id`, `employee_id`, `duplicate_check`, `create_at`) values ((select l.id from lecture l order by l.id asc limit 1,1), (select e.id from employee e order by e.id asc limit 1,1), concat((select l.id from lecture l order by l.id asc limit 1,1),'_',(select e.id from employee e order by e.id asc limit 1,1)), now());
insert into registration(`lecture_id`, `employee_id`, `duplicate_check`, `create_at`) values ((select l.id from lecture l order by l.id asc limit 2,1), (select e.id from employee e order by e.id asc limit 2,1), concat((select l.id from lecture l order by l.id asc limit 2,1),'_',(select e.id from employee e order by e.id asc limit 2,1)), now());
insert into registration(`lecture_id`, `employee_id`, `duplicate_check`, `create_at`) values ((select l.id from lecture l order by l.id asc limit 2,1), (select e.id from employee e order by e.id asc limit 3,1), concat((select l.id from lecture l order by l.id asc limit 2,1),'_',(select e.id from employee e order by e.id asc limit 3,1)), now());