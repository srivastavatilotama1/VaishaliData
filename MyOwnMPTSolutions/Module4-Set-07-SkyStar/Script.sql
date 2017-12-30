DROP TABLE SKYCustomers;
CREATE TABLE SKYCustomers (
custNum varchar2(15) primary key,
basePack varchar2(20),
optionalPack varchar2(20)
);

INSERT INTO SKYCustomers VALUES ('C001','Dhamal Hindi',null);
INSERT INTO SKYCustomers VALUES ('C002','South Magic',null);
INSERT INTO SKYCustomers VALUES ('C003','Dhamal Hindi','Kids');
INSERT INTO SKYCustomers VALUES ('C004','Dhamal Hindi','Music');
INSERT INTO SKYCustomers VALUES ('C005','Western Best','Music');
INSERT INTO SKYCustomers VALUES ('C006','Dhamal Hindi',null);
INSERT INTO SKYCustomers VALUES ('C007','Dhamal Hindi','Kids');

commit;