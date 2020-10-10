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
	CONSTRAINT chk_gender CHECK (gender in ('MALE','FEMALE','NONE'))
);

insert into member (
	username, email, password, gender, birth, phone, enrolldate
)values (
	'doli0413','doli0413@daum.net','doli0612@','MALE',sysdate, '010-2401-9435',sysdate
);

create table delivery (
	delivery_id				number(19,0) not null,
	delivery_username 		varchar2(255) not null,	--sm: username
	zipcode 				varchar2(255),
	name_of_delivery 		varchar2(255),
	address1 				varchar2(255),
	address2 				varchar2(255),
	is_main_address 		number(1) default 1, --sm: char(1) DEFAULT 'T'
	primary key (delivery_id)
);

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
	complain_username VARCHAR(255) NOT NULL,	--sm: username
	subject VARCHAR(255) NULL,
	compalin_content VARCHAR(255) NULL,			--sm: context
	complain_regDate DATE DEFAULT sysdate,		--sm: regDate
	answer VARCHAR(1000) NULL,
	ansDate DATE NULL
);
    
CREATE INDEX complain_INDEX ON complain(complain_username); 

create table product (
	prod_id					number(19,0) not null,
	prod_number 			varchar2(255), 	--sm: ProdNumber
	prod_name 				varchar2(255),	--sm: name
	prod_thumb_nail 		varchar2(255),	--sm: thumbnail
	member_id		 		number(19,0), 	--sm: seller
	prod_reg_date 			date, 			--sm: regDate
	stock 					number(5) default 0,
	price 					number(10) default 0,
	options 				varchar2(255),
	category				varchar2(255),
	primary key (prod_id) 					--sm: primary key(ProdNumber)
);

--create index product_index on product(member_id);

create table review (
	review_id				number(19,0) not null,
	review_prod_number 	number(19,0),		--sm: ProdNumber
	review_username 		number(19,0),	--sm: reviewer
	review_thumb_nail 		varchar2(255), 	--sm: thumbNail
	score number(1) 		default 0,
	review_reg_date 		date,			--sm: regDate
	review_content 			varchar2(255),
	primary key (review_id)
);

--create index review_index on review(product_prod_number);

create table purchase (
	purchase_id				number(19,0) not null,
	order_number 			varchar2(255),	--sm: orderNumber
	purchase_username 		number(19,0),	--sm: username
	--product_prod_number 	number(19,0),	--sm: ProdNumber -> order_number로 연결되니 필요없음
	purchase_date 			date,			--sm: purchaseDate
	arrive 					number(1) default 0,--sm: char(1) DEFAULT 'F'
	primary key (purchase_id)
);
create index purchase_index on purchase(purchase_username);

create table shipping_information (
	shipping_id				number(19,0) not null,
	shipping_number 		varchar2(255),	--sm: shppingNumber
	--username number(19,0),				--sm: username -> order_number로 연결되니 필요 없음
	shipping_order_number 	number(19,0),	--sm: orderNumber
	courier 				varchar2(255),
	parcel_number 			date,
	delivery_state 			varchar2(255) default 'shipping',
	primary key (shipping_id)
);

create index shipping_index_purchase on shipping_information(shipping_order_number);

create table m_purchase_prod (
	mpp_id					number(19,0) not null,
	mpp_product_id 			number(19,0) not null,
	mpp_purchases_id 		number(19,0) not null,
	quantity				number(19,0) not null,
	primary key (mpp_id)
);