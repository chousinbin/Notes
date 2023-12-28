create table supplier
(
	supplier_id varchar(8) primary key,
	supplier_name varchar(8) not null,
	supplier_address varchar(32) not null,
	supplier_phone varchar(16) not null
)