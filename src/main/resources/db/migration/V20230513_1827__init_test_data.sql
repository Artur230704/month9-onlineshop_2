INSERT INTO customers (username, email, password, role, enabled)
VALUES ('Artur','artur230704@gmail.com','$2a$10$RO5xvriIQFUvtB3S2zUToukB5EZgJqNAomCCwZjVm.OzThGOTdcRu','customer',true),
       ('Vasya','vasya@gmail.com','$2a$10$.PQmIwuGL.gra24p0l0eh..eno5iQUVGA7iWRve1J.fpoD0kemqNu','customer',true),
       ('Petya','petya@gmail.com','$2a$10$.ktoPXEyU6xgUKE2UeOnKu3e3Yj5Zorbpc3gVu624eiNig0XCGtmu','customer',true);

INSERT INTO orders (customer_id, address, bill, date)
VALUES (1,'bishkek',72790,'2023-07-23 09:30:15.123456'),
       (2,'bishkek',54590,'2023-05-07 15:31:15.123456'),
       (3,'bishkek',78190,'2023-01-22 11:29:20.123456'),
       (1,'bishkek',90990,'2023-07-23 11:31:15.123456'),
       (2,'bishkek',90990,'2023-02-21 18:31:15.123456'),
       (3,'bishkek',89990,'2023-07-23 11:31:15.123456');

INSERT INTO reviews (customer_id, text, product_id, date)
VALUES (1,'cool monitor',1,'2023-10-17 15:31:15.123456'),
       (2,'good monitor',2,'2023-10-17 15:31:15.123456'),
       (3,'nice monitor',3,'2023-10-17 15:31:15.123456');


INSERT INTO shopping_carts (customer_id)
VALUES (1),
       (2),
       (3);

INSERT INTO shopping_cart_items(shopping_cart_id, product_id)
VALUES (1,1),
       (1,3),
       (2,2),
       (3,3),
       (1,7),
       (2,8),
       (2,11);

INSERT INTO order_product (order_id, product_id, quantity)
VALUES (1,1,1),
       (2,2,1),
       (3,3,1),
       (4,4,1),
       (5,7,1),
       (6,15,1);
