select * from tab;
select * from seq;

select * from member;
select * from seller;
select * from product;
select * from pphoto;
select * from room;
select * from rphoto;
select * from reservation;
select * from review;

select count(*) from seller;
select * from (select rownum rnum, seller.* from (select * from seller order by sel_app desc) seller) where rnum >= 4 and rnum <= 20;


update reservation set res_s = 1;
update reservation set res_s = 0 where res_no = 93;

delete from reservation where res_no = 87;
delete from review where rev_no = 48;

insert into member values('exids9','1111','최용욱','880530','yongs','naver.com','010','8805','0054','08710','서울 관악구 당곡6가길 3','아주아파트','man',sysdate,1,1,null);
insert into seller values('babas3','1111','최용욱','chyw','naver.com','010','1111','2222','094432','인천시 어쩌구 저쩌동','그냥아파트',sysdate,null,'102586','212155',0,null);
insert into review values(4,'rtrt','어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구-어쩌구저쩌구',sysdate,7,81,42);
delete from product;
delete from pphoto;
delete from room;
delete from rphoto;
delete from reservation;
delete from review;
delete from member;
delete from seller;
delete from seller where sel_id = 'wawa';


ALTER TABLE reservation ADD rm_no NUMBER;
ALTER TABLE reservation ADD pro_no NUMBER;
alter table member drop column mem_addr;
alter table member drop column mem_gen;
alter table member drop column mem_joind;
alter table member drop column mem_g;
alter table member drop column mem_s;
alter table member drop column mem_pic;

alter table member add mem_addr1 VARCHAR2(50);
alter table member add mem_addr2 VARCHAR2(50);
alter table member add mem_gen VARCHAR2(10);
alter table member add mem_joind TIMESTAMP;
alter table member add mem_g NUMBER;
alter table member add mem_s NUMBER;
alter table member add mem_pic VARCHAR2(50); 


alter table seller drop column sel_addr;
alter table seller drop column sel_app;
alter table seller drop column sel_joind;
alter table seller drop column sel_n1;
alter table seller drop column sel_n2;
alter table seller drop column sel_s;
alter table seller drop column sel_pic;


alter table seller add sel_addr1 VARCHAR2(50);
alter table seller add sel_addr2 VARCHAR2(50);
alter table seller add sel_app TIMESTAMP;
alter table seller add sel_joind TIMESTAMP;
alter table seller add sel_n1 VARCHAR2(10);
alter table seller add sel_n2 VARCHAR2(10);
alter table seller add sel_s NUMBER;
alter table seller add sel_pic VARCHAR2(50);

select * from reservation where mem_id = 'rtrt' order by res_no desc;

insert into seller values('para','1111','최용욱','chyw','naver.com','010','1111','2222',
'094432','인천시 어쩌구 저쩌동','그냥아파트',sysdate,sysdate,'102586','212155',1,'ho');

insert into seller values('pama','1111','최용욱','chyw','naver.com','010','1111','2222',
'094432','인천시 어쩌구 저쩌동','그냥아파트',sysdate,sysdate,'102586','212155',1,'ho');



select * from PRODUCT where pro_no = (select max(pro_no) from PRODUCT where sel_id = 'pama');



select * from room where rm_no = (select max(rm_no) from (select * from room where pro_no = 97) where rm_price = (select min(rm_price) from room where pro_no = 97));


select nvl(avg(rev_star),0) from review where pro_no = 108;
select count(rev_no) from review where pro_no = 108;


select * from reservation where res_no NOT IN (select reservation.res_no from reservation,review where reservation.res_no = review.res_no) and mem_id = 'sasa' and pro_no= 81 and res_s < 2;


select * from review where rev_no = (select max(rev_no) from review where mem_id = 'sasa' and pro_no = 81);

select * from reservation where res_ckin between TO_CHAR(SYSDATE, 'YYYY-MM-DD') and TO_CHAR(SYSDATE, 'YYYY-MM-DD') and mem_id = 'sasa' and res_s = 1;


select sysdate from dual;


//
select * from reservation where res_ckin <= TO_CHAR(sysdate+0.99999, 'YYYY-MM-DD') and mem_id = 'sasa' and res_s = 1;
select * from reservation where res_ckin <= TO_CHAR(sysdate+0.99999, 'YYYY-MM-DD') and pro_no = 89 and res_s = 1;

update reservation set res_s = 0 where res_no IN (select a.res_no from reservation a where a.res_ckin <= TO_CHAR(sysdate, 'YYYY-MM-DD') and a.mem_id = 'sasa' and a.res_s = 1);
update reservation set res_s = 0 where res_no IN (select a.res_no from reservation a where a.res_ckin <= TO_CHAR(sysdate+0.99999, 'YYYY-MM-DD') and a.pro_no = 89 and a.res_s = 1);


select sysdate from dual;
select res_ckin+0.99999 from reservation where res_no=70;

//



