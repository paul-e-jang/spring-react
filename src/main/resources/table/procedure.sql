create or replace procedure deleteFromCart(
 v_username in member.username%type, 
 v_prodId in product.prod_id%type
 )
  is
 v_row m_purchase_prod%rowtype;
cursor c1 is   select mpp.* from member m
left outer join purchase c
on m.username = c.purchase_username
 left outer join m_purchase_prod mpp
 on c.purchase_id = mpp.mpp_purchases_id
 left outer join product p
 on p.prod_id = mpp.mpp_product_id
 where username = v_username and p.prod_id = v_prodId;
begin   
 for v_row in c1 loop
 exit when(c1%notfound);
delete from m_purchase_prod
where MPP_PRODUCT_ID = v_row.MPP_PRODUCT_ID and MPP_PURCHASES_ID = v_row.MPP_PURCHASES_ID;
delete from purchase where PURCHASE_ID = v_row.MPP_PURCHASES_ID;
end loop;
 end;
/

create or replace procedure updateQtyFromCart(
 v_username in member.username%type, -- 유저이름
 v_quantity in m_purchase_prod.quantity%type, -- 수량
 v_prodId in product.prod_id%type -- 프로덕트 키
 )
 is
 v_row m_purchase_prod%rowtype;
cursor c1 is   select mpp.* from member m
 left outer join purchase c
 on m.username = c.purchase_username
 left outer join m_purchase_prod mpp
 on c.purchase_id = mpp.mpp_purchases_id
 left outer join product p
 on p.prod_id = mpp.mpp_product_id
 where username = v_username and p.prod_id = v_prodId;
 begin   
 for v_row in c1 loop
 exit when(c1%notfound);
 update m_purchase_prod set quantity = v_quantity
 where MPP_PRODUCT_ID = v_row.MPP_PRODUCT_ID and MPP_PURCHASES_ID = v_row.MPP_PURCHASES_ID;
end loop;
 end;
/