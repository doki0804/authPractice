insert into customer(id, c_name, c_phone, c_address) values(CUSTOMER_ID_SEQ.nextval, '테스터1', '010-0000-0001', '테스트1');
insert into customer(id, c_name, c_phone, c_address) values(CUSTOMER_ID_SEQ.nextval, '테스터2', '010-0000-0002', '테스트2');
insert into customer(id, c_name, c_phone, c_address) values(CUSTOMER_ID_SEQ.nextval, '테스터3', '010-0000-0003', '테스트3');

------product--------
insert into PRODUCT(ID, P_AMOUNT, P_CREATED_DATE, P_EXPIRATION_DATE, P_LOC, P_LOT_NUM, P_MANUFACTURER, P_NAME, P_PRICE, P_UNIT, RECEIPT_DATE)
values (PRODUCT_ID_SEQ.nextval, 10, sysdate, '2024-06-26', 'A-1-1', '1124089', 'NORIAND', '테스트상품1', 12000, '12/box', sysdate-30);
insert into PRODUCT(ID, P_AMOUNT, P_CREATED_DATE, P_EXPIRATION_DATE, P_LOC, P_LOT_NUM, P_MANUFACTURER, P_NAME, P_PRICE, P_UNIT, RECEIPT_DATE)
values (PRODUCT_ID_SEQ.nextval, 10, sysdate, '2024-06-26', 'A-1-1', '1124089', 'NORIAND', '테스트상품2', 8000, '20/box', sysdate-30);
insert into PRODUCT(ID, P_AMOUNT, P_CREATED_DATE, P_EXPIRATION_DATE, P_LOC, P_LOT_NUM, P_MANUFACTURER, P_NAME, P_PRICE, P_UNIT, RECEIPT_DATE)
values (PRODUCT_ID_SEQ.nextval, 10, sysdate, '2024-06-26', 'A-1-1', '1124089', 'NORIAND', '테스트상품3', 32000, '8/box', sysdate-30);
insert into PRODUCT(ID, P_AMOUNT, P_CREATED_DATE, P_EXPIRATION_DATE, P_LOC, P_LOT_NUM, P_MANUFACTURER, P_NAME, P_PRICE, P_UNIT, RECEIPT_DATE)
values (PRODUCT_ID_SEQ.nextval, 10, sysdate, '2024-06-26', 'A-1-1', '1124089', 'NORIAND', '테스트상품4', 24000, '8/box', sysdate-30);
insert into PRODUCT(ID, P_AMOUNT, P_CREATED_DATE, P_EXPIRATION_DATE, P_LOC, P_LOT_NUM, P_MANUFACTURER, P_NAME, P_PRICE, P_UNIT, RECEIPT_DATE)
values (PRODUCT_ID_SEQ.nextval, 10, sysdate, '2024-06-26', 'A-1-1', '1124089', 'NORIAND', '테스트상품5', 24000, '12/box', sysdate-30);

--------order---------
insert into orders(ID, ORDER_DATE, ORDER_NUMBER, ORDER_STATE, RECIPIENT, SHIPPING_LOC, SHIPPING_ZIP_CODE)
VALUES (ORDERS_ID_SEQ.nextval, sysdate, 1, 'F', '테스트구매자1', '서울시 강남구', '123-432');
insert into orders(ID, ORDER_DATE, ORDER_NUMBER, ORDER_STATE, RECIPIENT, SHIPPING_LOC, SHIPPING_ZIP_CODE)
VALUES (ORDERS_ID_SEQ.nextval, sysdate, 2, 'F', '테스트구매자2', '서울시 강남구', '123-432');

insert into ORDER_ITEM(ID, OI_QTY, OI_STATUS, ORDER_UNIT, SHIPPING_DATE, CUSTOMER_ID, ORDERS_ID, PRODUCT_ID)
VALUES (ORDER_ITEM_ID_SEQ.nextval, 2, 'F','ea',null, 1, 1, 1);
insert into ORDER_ITEM(ID, OI_QTY, OI_STATUS, ORDER_UNIT, SHIPPING_DATE, CUSTOMER_ID, ORDERS_ID, PRODUCT_ID)
VALUES (ORDER_ITEM_ID_SEQ.nextval, 1, 'F','box',null, 2, 2, 2);
insert into ORDER_ITEM(ID, OI_QTY, OI_STATUS, ORDER_UNIT, SHIPPING_DATE, CUSTOMER_ID, ORDERS_ID, PRODUCT_ID)
VALUES (ORDER_ITEM_ID_SEQ.nextval, 4, 'F','ea',null, 2, 2, 3);
