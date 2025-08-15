create table customer
(
	customer_id smallint identity(1, 1) primary key,
	customer_name varchar(16) not null,
	customer_phone char(11) not null,
	customer_sex varchar(2) not null,
	customer_reward decimal(9,2) default 0,
	constraint uk_customer_name_customer_phone unique(customer_name, customer_phone),
	constraint ck_customer_rewward check(customer_reward >= 0),
	constraint ck_customer_phone check(customer_phone like 
	'1[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
)