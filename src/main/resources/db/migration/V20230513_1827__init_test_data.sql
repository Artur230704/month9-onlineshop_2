INSERT INTO users (username, email, password, role, enabled)
VALUES ('Artur','artur230704@gmail.com','$2a$10$RO5xvriIQFUvtB3S2zUToukB5EZgJqNAomCCwZjVm.OzThGOTdcRu','user',true),
       ('Vasya','vasya@gmail.com','$2a$10$.PQmIwuGL.gra24p0l0eh..eno5iQUVGA7iWRve1J.fpoD0kemqNu','user',true),
       ('Petya','petya@gmail.com','$2a$10$.ktoPXEyU6xgUKE2UeOnKu3e3Yj5Zorbpc3gVu624eiNig0XCGtmu','user',true);

INSERT INTO orders (user_id, address, bill, date)
VALUES (1,'bishkek',22770,'2023-07-23 09:30:15.123456'),
       (2,'bishkek',22800.03,'2023-05-07 15:31:15.123456'),
       (3,'bishkek',23562,'2023-01-22 11:29:20.123456'),
       (1,'bishkek',6255,'2023-07-23 11:31:15.123456'),
       (2,'bishkek',1233,'2023-02-21 18:31:15.123456'),
       (3,'bishkek',3915,'2023-07-23 11:31:15.123456');

INSERT INTO reviews (user_id, text, product_id, date)
VALUES (1,'cool monitor',1,'2023-10-17 15:31:15.123456'),
       (2,'good monitor',2,'2023-10-17 15:31:15.123456'),
       (3,'nice monitor',3,'2023-10-17 15:31:15.123456');


INSERT INTO shopping_carts (user_id)
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

INSERT INTO order_product (order_id, product_id)
VALUES (1,1),
       (2,2),
       (3,3),
       (1,4),
       (2,7),
       (3,17);
