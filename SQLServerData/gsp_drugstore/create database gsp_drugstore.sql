create database gsp_drugstore
on
(
	name = 'gsp_drug_store',
	filename = 'D:\SQLServerData\gsp_drugstore\gsp_drugstore.mdf',
	size = 100MB,
	maxsize = 16GB,
	filegrowth = 10MB
)
log on
(
	name = 'gsp_drugstore_log',
	filename = 'D:\SQLServerData\gsp_drugstore\gsp_drugstore.ldf',
	size = 50MB,
	maxsize = 8GB,
	filegrowth = 10MB
)
