truncate table diabetesnotes;
truncate table foodnotes;
truncate table hibernate_sequence;
truncate table products;
truncate table users;

ALTER TABLE diabetesnotes AUTO_INCREMENT = 1;
ALTER TABLE foodnotes AUTO_INCREMENT = 1;
ALTER TABLE hibernate_sequence AUTO_INCREMENT = 1;
ALTER TABLE products AUTO_INCREMENT = 1;
ALTER TABLE users AUTO_INCREMENT = 1;

DROP TABLE diabetesnotes;
DROP TABLE foodnotes;
DROP TABLE hibernate_sequence;
DROP TABLE products;
DROP TABLE users;