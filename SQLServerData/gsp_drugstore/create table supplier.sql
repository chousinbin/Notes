use gsp_drugstore
create table supplier
(
	supplier_id smallint identity(1,1) primary key,
	supplier_name varchar(16) not null,
	supplier_address varchar(32) not null,
	supplier_phone varchar(16) not null,
	constraint CK_supplier_phone check(supplier_phone like 
	'[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or 
	supplier_phone like '[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
)