create table sale
(
	customer_id varchar(8),
	drug_id varchar(8),

	sale_quantity smallint not null,
	sale_price decimal(9,2) check(sale_price > 0),
	sale_sum_price decimal(9,2) check(sale_sum_price > 0),
	sale_date date not null,

	constraint PK_customer_id_drug_id primary key (customer_id, drug_id),
	constraint FK_sale_customer_id foreign key(customer_id) references customer(customer_id),
	constraint FK_sale_drug_id foreign key(drug_id) references drug(drug_id)
)
