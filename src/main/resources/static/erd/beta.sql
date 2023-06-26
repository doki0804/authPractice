drop table assign cascade constraints;
drop table customer cascade constraints;
drop table order_item cascade constraints;
drop table orders cascade constraints;
drop table product cascade constraints;
drop table users cascade constraints;
drop table users_roles cascade constraints;
drop sequence assign_id_seq;
drop sequence customer_id_seq;
drop sequence order_id_seq;
drop sequence order_item_id_seq;
drop sequence product_id_seq;
drop sequence users_id_seq;

create sequence assign_id_seq start with 1 increment by  1;
create sequence customer_id_seq start with 1 increment by  1;
create sequence order_id_seq start with 1 increment by  1;
create sequence order_item_id_seq start with 1 increment by  1;
create sequence product_id_seq start with 1 increment by  1;
create sequence users_id_seq start with 1 increment by  1;

create table assign (
                        id number(19,0) not null,
                        primary key (id)
)

create table customer (
                          id number(19,0) not null,
                          c_address varchar2(255 char),
                          c_name varchar2(255 char),
                          c_phone varchar2(255 char),
                          primary key (id)
)

create table order_item (
                            id number(19,0) not null,
                            oi_qty number(10,0),
                            oi_status varchar2(255 char),
                            order_unit varchar2(255 char),
                            shipping_date timestamp,
                            customer_id number(19,0),
                            order_id number(19,0),
                            product_id number(19,0),
                            primary key (id)
)

create table orders (
                        id number(19,0) not null,
                        order_date timestamp,
                        order_number number(10,0),
                        order_state varchar2(255 char),
                        recipient varchar2(255 char),
                        shipping_loc varchar2(255 char),
                        shipping_zip_code varchar2(255 char),
                        primary key (id)
)

create table product (
                         id number(19,0) not null,
                         p_amount number(10,0),
                         p_created_date timestamp,
                         p_expiration_date timestamp,
                         p_loc varchar2(255 char),
                         p_lot_num varchar2(255 char),
                         p_manufacturer varchar2(255 char),
                         p_name varchar2(255 char),
                         p_price number(10,0),
                         p_unit varchar2(255 char),
                         receipt_date timestamp,
                         primary key (id)
)

create table users (
                       id number(19,0) not null,
                       create_date timestamp,
                       modified_date timestamp,
                       company_cd varchar2(20 char),
                       password varchar2(255 char) not null,
                       user_id varchar2(30 char) not null,
                       user_name varchar2(255 char),
                       user_phone varchar2(255 char),
                       primary key (id)
)

create table users_roles (
                             users_id number(19,0) not null,
                             roles varchar2(255 char)
)

    
    alter table users 
       add constraint UK_6efs5vmce86ymf5q7lmvn2uuf unique (user_id)
    
    alter table order_item 
       add constraint FK983cvgn2yeo3724p74o49hqge 
       foreign key (customer_id) 
       references customer
    
    alter table order_item 
       add constraint FKea29bb770t1s99pp2ngvhgwnt 
       foreign key (orders_id) 
       references orders
    
    alter table order_item 
       add constraint FK551losx9j75ss5d6bfsqvijna 
       foreign key (product_id) 
       references product
    
    alter table users_roles 
       add constraint FKml90kef4w2jy7oxyqv742tsfc 
       foreign key (users_id) 
       references users