create table purchase
(
	supplier_id smallint,
	drug_id smallint,
	purchase_quantity smallint not null,
	purchase_price decimal(9,2) not null check(purchase_price > 0),
	purchase_sum_price decimal(9,2) not null check(purchase_sum_price > 0),
	purchase_date date not null,
	constraint PK_supplier_id_drug_id primary key (supplier_id, drug_id),
	constraint FK_purchase_supplier_id foreign key(supplier_id) references supplier(supplier_id),
	constraint FK_purchase_drug_id foreign key(drug_id) references drug(drug_id)
)
