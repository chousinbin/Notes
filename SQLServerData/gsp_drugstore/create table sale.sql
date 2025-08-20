create table sale
(
	customer_id smallint,
	drug_id smallint,
	sale_quantity smallint not null,
	sale_price decimal(9,2) not null check(sale_price > 0),
	sale_sum_price decimal(9,2) not null check(sale_sum_price > 0),
	sale_datetime datetime not null,
	constraint PK_customer_id_drug_id primary key (customer_id, drug_id),
	constraint FK_sale_customer_id foreign key(customer_id) references customer(customer_id),
	constraint FK_sale_drug_id foreign key(drug_id) references drug(drug_id)
)
