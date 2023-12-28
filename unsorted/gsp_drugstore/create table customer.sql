create table customer
(
	customer_id varchar(8) primary key,
	customer_name varchar(8) not null,
	customer_phone varchar(16) not null,
	customer_sex varchar(2) not null,
	customer_reward decimal(9,2) default 0,
	constraint U_customer_name_customer_phone unique(customer_name, customer_phone)
)