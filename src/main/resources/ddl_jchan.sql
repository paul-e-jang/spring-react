drop table product_purchases;
drop table shipping_infomartion;
drop table purchase;
drop table review;
drop table product;
drop table complain;
drop table delivery;
drop table member;
drop table admin;




CREATE TABLE admin (
  id CHAR(5) DEFAULT 'ADMIN',
  password VARCHAR(300) NOT NULL,
  name VARCHAR(200) NOT NULL,
  levels number(1) default 5,
  role CHAR(10) DEFAULT 'ROLE_ADMIN',
  PRIMARY KEY (id));
  


create TABLE member (
  username VARCHAR(255) NOT NULL,
  email VARCHAR(200) not NULL unique,
  password VARCHAR(200) not NULL,
  gender char(6) default 'NONE', 
  birth Date,
  phone VARCHAR(200) ,
  enrollDate DATE DEFAULT sysdate,
  is_seller number(1) default 0,
  levels number(1) default 0,
  delFlag number(1) DEFAULT 0,
  role char(10) default 'ROLE_USER',
  deleteDate DATE,
  PRIMARY KEY (username),
  CONSTRAINT chk_gender CHECK (gender in ('MALE','FEMALE','NONE')));
  
insert into member values();

insert into member (
    username, email, password, gender, birth, phone, enrolldate
)values (
    'doli0413','doli0413@daum.net','doli0612@','MALE',sysdate, '010-2401-9435',sysdate
);


CREATE TABLE complain (
	  complain_num number primary key,
	  username VARCHAR(255) NOT NULL,
	  subject VARCHAR(255) NULL,
	  context VARCHAR(255) NULL,
	  regDate DATE DEFAULT sysdate,
	  answer VARCHAR(1000) NULL,
	  ansDate DATE NULL,
	  CONSTRAINT fk_member_complain
		FOREIGN KEY (username)
    REFERENCES member (username));
    
    CREATE INDEX complain_INDEX ON complain(username); 

create table delivery (
	delivery_id				number(19,0) not null,
	address1 				varchar2(255),
	address2 				varchar2(255),
	is_main_address 		number(1) default 1,
	name_of_delivery 		varchar2(255),
	zipcode 				varchar2(255),
	member_username 		varchar2(255),
	primary key (delivery_id)
);


create table product (
	prod_id					number(19,0) not null,
	prod_number 			varchar2(255),
	name 					varchar2(255),
	options 				varchar2(255),
	price 					number(10) default 0,
	prod_reg_date 				date,
	stock 					number(5) default 0,
	thumb_nail 				varchar2(255),
	member_id		 		number(19,0),
	category				varchar2(255),
	primary key (prod_id)
);

create table review (
	review_id				number(19,0) not null,
	content 				varchar2(255),
	review_reg_date 				date,
	score number(1) 		default 0,
	thumb_nail 				varchar2(255),
	product_prod_number 	number(19,0),
	member_username 		number(19,0),
	primary key (review_id)
);

create table purchase (
	purchase_id				number(19,0) not null,
	arrive 					number(1) default 0,
	order_number 			varchar2(255),
	purchase_date 			date,
	member_username 		number(19,0),
	--product_prod_number 	number(19,0),
	primary key (purchase_id)
);

create table shipping_infomartion (
	shipping_id				number(19,0) not null,
	courier 				varchar2(255),
	delivery_state 			varchar2(255) default 'shipping',
	parcel_number 			date,
	shpping_number 			varchar2(255),
	--member_username number(19,0),
	purchase_order_number 	number(19,0),
	primary key (shipping_id)
);

create table product_purchases (
	prod_purchase_id		number(19,0) not null,
	product_id 				number(19,0) not null,
	purchases_id 			number(19,0) not null,
	quantity				number(19,0) not null,
	primary key (prod_purchase_id)
);

--create table product_reviews (
--	product_id 				number(19,0) not null,
--	reviews_id 				number(19,0) not null
--);
