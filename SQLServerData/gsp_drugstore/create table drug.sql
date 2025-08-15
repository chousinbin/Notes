create table drug
(
	drug_id smallint identity(1,1) primary key,
	drug_name varchar(16) not null,
	drug_maker varchar(8) not null,
	drug_expiration varchar(4) not null,
	constraint uk_drug_name_drug_maker unique(drug_name, drug_maker),
)