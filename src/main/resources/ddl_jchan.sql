drop table product_purchases;
drop table shipping_infomartion;
drop table purchase;
drop table review;
drop table product;
drop table complain;
drop table delivery;
drop table member;
drop table admin;

create table admin (
	admin_id 				number(19,0) not null,
	admin_name 				varchar2(255),
	levels 					varchar2(255),
	name 					varchar2(255),
	password 				varchar2(255),
	role 					char(10) default 'ROLE_ADMIN',
	primary key (admin_id)
);

create table member (
	member_id 				number(19,0) not null,
	birth 					date,
	delDate 				date,
	delFlag 				number(1) default 0,
	email 					varchar2(255),
	enrolldate 				date,
	gender 					number(10,0),
	levels 					number(1) default 0,
	password 				varchar2(255),
	phone 					varchar2(255),
	role 					char(10) default 'ROLE_USER',
	is_seller 				number(1) default 0,
	username 				varchar2(255),
	primary key (member_id)
);

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

create table complain (
	complain_id				number(19,0) not null,
	ans_date 				date,
	answer 					varchar2(255),
	context 				varchar2(255),
	reg_date 				date,
	subject 				varchar2(255),
	member_username 		number(19,0),
	primary key (complain_id)
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
