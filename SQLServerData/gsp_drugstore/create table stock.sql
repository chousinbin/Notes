create table stock
(
	drugstore_id smallint,
	drug_id smallint,
	stock_batch varchar(8) not null unique,
	production_date date not null,
	stock_purchase_price decimal(9,2) not null check(stock_purchase_price > 0),
	stock_sale_price decimal(9,2) not null check(stock_sale_price > 0),
	stock_quantity smallint not null,
	stock_date date not null,
	constraint PK_drugstore_id_drug_id primary key(drugstore_id, drug_id),
	constraint FK_drugstore_id foreign key(drugstore_id) references drugstore(drugstore_id),
	constraint FK_drug_id foreign key(drug_id) references drug(drug_id)
)