insert into course(id,name,created_date,last_updated_date)
values(10001,'JPA in 50 steps',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date) 
values(10002,'angular 7',sysdate(),sysdate());
insert into course(id,name,created_date,last_updated_date) 
values(10003,'Springboot in 100 steps',sysdate(),sysdate());

insert into passport(id,number)
values(40001,'Ab123');
insert into passport(id,number)
values(40002,'Ab256');
insert into passport(id,number)
values(40003,'Ab238');

insert into student(id,name,passport_id)
values(20001,'Renato',40001);
insert into student(id,name,passport_id)
values(20002,'Luzia',40002);
insert into student(id,name,passport_id)
values(20003,'Manoel',40003);


insert into review(id,rating,description,course_id)
values(50001,'5','Five Stars Course',10001L);
insert into review(id,rating,description,course_id,)
values(50002,'3','Three Stars Course',10001L);
insert into review(id,rating,description,course_id)
values(50003,'1','One Star Course',10003L);


