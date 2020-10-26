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
	delivery_username 		VARCHAR2(255) not null,	
	zipcode 				varchar2(255),
	name_of_delivery 		varchar2(255),
	address1 				varchar2(255),
	address2 				varchar2(255),
	is_main_address 		number(1) default 1, --sm: char(1) DEFAULT 'T',
	constraint delivery_id_pk primary key (delivery_id),
	constraint delivery_username_fk foreign key(delivery_username) references member(username) -- fk 제약조건
);
alter table delivery add constraint delivery_username_fk foreign key(delivery_username) references member(username);
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
	ansDate DATE NULL,
	constraint complain_username_fk foreign key(complain_username) references member(username)
);

alter table complain add constraint complain_username_fk foreign key(complain_username) references member(username);
CREATE INDEX complain_INDEX ON complain(complain_username); 

create table product (
	prod_id					number(19,0) not null,   -- 상품 고유키
	prod_name 				varchar2(255),	             -- 상품 명
	prod_thumb_nail 		varchar2(255),  	         -- 썸네일 파일명
	member_username    VARCHAR2(255), 	         -- 판매자 이름
	prod_reg_date 			date, 			                 -- 상품게시일
	stock 					    number(5) default 0,      -- 상품 재고량
	price 					    number(10) default 0,     -- 상품 가격
	options 				    varchar2(255),               -- 상품 상세
	category				    varchar2(255),               -- 상품 카테고리
	primary key (prod_id), 					             -- PK 제약조건
    constraint product_username_fk FOREIGN key(member_username) references member(username)
);

alter table product add constraint product_username_fk FOREIGN key(member_username) references member(username);
create index product_index on product(member_username);


create table review (
	review_id				        number(19,0) not null, -- PK
	review_prod_id	 		    number(19,0),		
	review_username 		    varchar2(255),             -- FK
	review_thumb_nail 		varchar2(255), 	
	score number(1) 		    default 0,
	review_reg_date 		    date,			
	review_content 			varchar2(255),
	primary key (review_id),
    constraint review_username_fk foreign key(review_username) references member(username)
);

create index ind_review_username on review(review_username);
alter table review modify review_username varchar2(255); -- 유저이름 컬럼 자료형 불일치
alter table review add constraint review_username_fk foreign key(review_username) references member(username);


create table purchase (
	purchase_id				    number(19,0) not null,  --PK
	purchase_username 		varchar2(255),	            --FK
	purchase_date 			    date,			
	arrive 					    number(1) default 0,
	is_purchased			    number(1) default 0,
	primary key (purchase_id),
    constraint purchase_username_fk foreign key(purchase_username) references member(username)
);
alter table purchase add constraint purchase_username_fk foreign key(purchase_username) references member(username);
create index purchase_index on purchase(purchase_username);

-- 더미데이터
insert into purchase (purchase_id,purchase_username,purchase_date) values (
    (select nvl(max(purchase_id), 0)  +1  from purchase), 'jchan',sysdate
);

create table shipping_information (
	shipping_id				    number(19,0) not null,
	shipping_purchase_id 	number(19,0),	        --FK
	courier 				        varchar2(255),
	parcel_number 			    date,
	delivery_state 			    varchar2(255) default 'shipping',
	primary key (shipping_id),
    constraint shipping_purcharse_id_fk foreign key(shipping_purchase_id) references purchase(purchase_id)
);

alter table shipping_information add constraint shipping_purcharse_id_fk foreign key(shipping_purchase_id) references purchase(purchase_id);
create index ind_shipping_purcharse_id on shipping_information(shipping_purchase_id);


--Product 와 Purchase 간의 중간 테이블
create table m_purchase_prod (
	mpp_product_id 			number(19,0) not null,
	mpp_purchases_id 		number(19,0) not null,
	quantity				number(19,0) not null,
	primary key (mpp_product_id,mpp_purchases_id),
    constraint mpp_prod_id foreign key(mpp_product_id) references product(prod_id),
    constraint mpp_purchase_id foreign key(mpp_purchases_id) references PURCHASE(PURCHASE_ID)
);
alter table m_purchase_prod add constraint mpp_prod_id foreign key(mpp_product_id)
    references product(prod_id);
alter table m_purchase_prod add constraint mpp_purchase_id foreign key(mpp_purchases_id)
    references PURCHASE(PURCHASE_ID);  
	
insert into M_PURCHASE_PROD values (
8,3,11 -- product_id(구매할 상품마다 변경), purchase_id(새로운 열마다 변경), 수량
);

-- 해당쿼리는 상품명, 판매자명, 상품게시일 , 상품재고량, 상품가격, 등록날짜, 선택한 수량을 뿌림 
select m.username,p.prod_name,p.member_username, p.prod_reg_date, p.stock, p.price, c.purchase_date, mpp.quantity from member m
    left outer join purchase c
    on m.username = c.purchase_username
    left outer join m_purchase_prod mpp
    on c.purchase_id = mpp.mpp_purchases_id
    left outer join product p
    on mpp.mpp_product_id = p.prod_id
        where username = 'jchan' and is_purchased = 0;