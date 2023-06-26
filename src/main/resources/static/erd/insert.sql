insert into customer(id, c_name, c_phone, c_address) values(CUSTOMER_SEQ.nextval, '테스터1', '010-0000-0001', '테스트1');
insert into customer(id, c_name, c_phone, c_address) values(CUSTOMER_SEQ.nextval, '테스터2', '010-0000-0002', '테스트2');
insert into customer(id, c_name, c_phone, c_address) values(CUSTOMER_SEQ.nextval, '테스터3', '010-0000-0003', '테스트3');


--------order---------
insert into orders(id, order_date, order_state) values (ORDER_SEQ.nextval, sysdate-1, 'y');
insert into orders(id, order_date, order_state) values (ORDER_SEQ.nextval, sysdate-2, 'y');
insert into orders(id, order_date, order_state) values (ORDER_SEQ.nextval, sysdate-3, 'y');

