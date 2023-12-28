create table drug
(
	drug_id varchar(8) primary key,
	drug_name varchar(16) not null,
	drug_maker varchar(8) not null,
	drug_expiration varchar(4) not null,
	constraint U_drug_name_drug_maker unique(drug_name, drug_maker)
)