use gsp_drugstore
create table drugstore
(
	drugstore_id varchar(8) primary key,
	drugstore_name varchar(16) not null unique,
	drugstore_address varchar(32) not null
)