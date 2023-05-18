INSERT INTO categories (name)
VALUES ('Acer'),
       ('Lenovo'),
       ('Asus'),
       ('HP'),
       ('HUAWEI');

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('Acer Nitro 5','files/acer_nitro_5.jpg','Corei5 11400H 16GB / SSD 512GB / GeForce GTX 1650 4GB',1,10,72790),
       ('Acer Extensa 15','files/acer_Extensa_15.jpg','Corei5 1035G1 8GB / SSD 512GB / Integrated',1,10,54590),
       ('Acer Swift 3','files/acer_swift_3.jpg','Corei5 1240P 8GB / SSD 512GB / Integrated',1,10,78190);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('Lenovo IdeaPad Gaming 3','files/lenovo_IdeaPad_Gaming_3.jpg','Ryzen 5 6600H 8GB / SSD 512GB / GeForce RTX 3050 4GB / DOS / 82SC006DRK',2,10,90990),
       ('Lenovo Legion 5 Pro','files/lenovo_Legion_5_Pro.jpg','16ARH7H Ryzen 7 6800H 16GB / SSD 512GB / GeForce RTX 3070 8GB / DOS / 82RG00GURK',2,10,150990),
       ('Lenovo Yoga Slim 7 ProX','files/lenovo_Yoga_Slim_7_ProX.jpg','Corei7 12700H 16GB / SSD 1 TB / GeForce RTX 3050 4GB / Win11 / 82TK00AXRU',2,10,141890);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('Asus ROG Strix G513','files/asus_1.jpg','Ryzen 7 4800H 16GB / SSD 512GB / GeForce RTX 3050 4GB / DOS / 90NR0502-M00050',3,10,90990),
       ('Asus VivoBook 16X','files/asus_2.jpg','Ryzen 5 5600H 8GB / SSD 512GB / Integrated / DOS / 90NB0Y81-M009B0',3,10,54590),
       ('Asus TUF Gaming F15','files/asus_3.jpg','Corei5 11400H 16 GB / SSD 512 GB / GeForce RTX 3050 4GB / DOS / 90NR0724-M00LS0',3,10,81890);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('HP Victus 16-e1047ci','files/hp_1.jpg','Ryzen 5 6600H 16GB / SSD 1TB / GeForce RTX 3050 Ti 4GB / DOS / 725W5EA',4,10,103690),
       ('HP Pavilion','files/hp_2.jpg','Corei5 1235U 16GB / SSD 512GB / Integrated / Win11 / 6G811EA',4,10,81890),
       ('HP 15s-eq2039ur','files/hp_3.jpg','Ryzen 5 5500U 8GB / SSD 512GB / Integrated / DOS / 4A724EA',4,10,49090);

INSERT INTO products (name, image, description, category_id, quantity, price)
VALUES ('HUAWEI MateBook D15','files/huawei_1.jpg','Corei3 1135G7 8GB / SSD 256GB / Integrated / Win11 / BohrD-WDI9A',5,10,47290),
       ('HUAWEI MateBook D14','files/huawei_2.jpg','Corei5 1135G7 8GB / SSD 512GB / Integrated / Win11 / NobelD-WDH9D',5,10,61690),
       ('HUAWEI MateBook D16','files/huawei_3.jpg','Corei5 12500H 16GB / SSD 512GB / Integrated / Win11 / RolleF-W5651',5,10,89990);