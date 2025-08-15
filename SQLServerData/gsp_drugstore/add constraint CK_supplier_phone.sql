alter table supplier
add constraint CK_supplier_phone check(supplier_phone like '[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
add constraint CK_supplier_ID check(supplier_id like 'S[0-9][0-9][0-9][0-9][0-9][0-9][0-9]')