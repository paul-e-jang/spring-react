drop table m_purchase_prod;
drop table shipping_information;
drop table purchase;
drop table review;
drop table product;
drop table complain;
drop table admin;
drop table delivery;
drop table member;

create TABLE member (
	username VARCHAR2(255) NOT NULL,
	email_address VARCHAR2(200) not NULL unique,
	password VARCHAR2(200) not NULL,
	gender char(6) default 'NONE', 
	birth Date,
	phone VARCHAR2(200) ,
	enrollDate DATE DEFAULT sysdate,
	is_seller number(1) default 0,
	levels number(1) default 0,
	delFlag number(1) DEFAULT 0,
	role char(10) default 'ROLE_USER',
	deleteDate DATE,
	PRIMARY KEY (username),
	CONSTRAINT chk_gender CHECK (gender in ('MALE','FEMALE','NONE'))
);

create table delivery (
	delivery_id				number(19,0) not null,
	delivery_username 		VARCHAR2(255) not null,	--sm: username
	zipcode 				varchar2(255),
	name_of_delivery 		varchar2(255),
	address1 				varchar2(255),
	address2 				varchar2(255),
	is_main_address 		number(1) default 1, --sm: char(1) DEFAULT 'T'
	primary key (delivery_id)
);
--username fk 예정으로 인한 인덱스
CREATE INDEX delivery_INDEX ON delivery(delivery_username); 

CREATE TABLE admin (
	id CHAR(5) DEFAULT 'ADMIN',
	password VARCHAR(300) NOT NULL,
	name VARCHAR(200) NOT NULL,
	levels number(1) default 5,
	role CHAR(10) DEFAULT 'ROLE_ADMIN',
	PRIMARY KEY (id)
);

CREATE TABLE complain (
	complain_id number primary key,		--sm: complain_num
	complain_username VARCHAR2(255) NOT NULL,	--sm: username
	subject VARCHAR2(255) NULL,
	compalin_content VARCHAR2(255) NULL,			--sm: context
	complain_regDate DATE DEFAULT sysdate,		--sm: regDate
	answer VARCHAR2(1000) NULL,
	ansDate DATE NULL
);
    
CREATE INDEX complain_INDEX ON complain(complain_username); 

create table product (
	prod_id					number(19,0) not null,
	prod_name 				varchar2(255),	--sm: name
	prod_thumb_nail 		varchar2(255),	--sm: thumbnail
	member_username		 	VARCHAR2(255), 	--sm: seller
	prod_reg_date 			date, 			--sm: regDate
	stock 					number(5) default 0,
	price 					number(10) default 0,
	options 				varchar2(255),
	category				varchar2(255),
	primary key (prod_id) 					--sm: primary key(ProdNumber)
);
--username fk 로 인한 인덱스
--create index product_index on product(member_username);


create table review (
	review_id				number(19,0) not null,
	review_prod_id	 		number(19,0),		--sm: ProdNumber
	review_username 		number(19,0),	--sm: reviewer
	review_thumb_nail 		varchar2(255), 	--sm: thumbNail
	score number(1) 		default 0,
	review_reg_date 		date,			--sm: regDate
	review_content 			varchar2(255),
	primary key (review_id)
);

create table purchase (
	purchase_id				number(19,0) not null,
	purchase_username 		varchar2(255),	--sm: username
	purchase_date 			date,			--sm: purchaseDate
	arrive 					number(1) default 0,--sm: char(1) DEFAULT 'F'
	is_purchased			number(1) default 0,
	primary key (purchase_id)
);
--username fk로 인한 인덱스
create index purchase_index on purchase(purchase_username);

-- 더미데이터
insert into purchase (purchase_id,purchase_username,purchase_date) values (
    (select nvl(max(purchase_id), 0)  +1  from purchase), 'jchan',sysdate
);

create table shipping_information (
	shipping_id				number(19,0) not null,
	shipping_purchase_id 	number(19,0),	--sm: orderNumber
	courier 				varchar2(255),
	parcel_number 			date,
	delivery_state 			varchar2(255) default 'shipping',
	primary key (shipping_id)
);

--Product 와 Purchase 간의 중간 테이블
create table m_purchase_prod (
	mpp_product_id 			number(19,0) not null,
	mpp_purchases_id 		number(19,0) not null,
	quantity				number(19,0) not null,
	primary key (mpp_product_id,mpp_purchases_id)
);
	
insert into M_PURCHASE_PROD values (
8,3,11 -- product_id(구매할 상품마다 변경), purchase_id(새로운 열마다 변경), 수량
);