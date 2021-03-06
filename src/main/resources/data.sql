DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS grouped_orders;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_group;

CREATE TABLE product_group (id int, product_group_name varchar(255));
CREATE TABLE product (id int, product_name varchar(255), product_price int, product_group_id int);
CREATE TABLE grouped_orders (group_id int, grouped_order_sum int, delivery_addres varchar(255), delivery_date DATE,client_name varchar(255), client_password varchar(255),
phone_number varchar(255), is_delivered varchar(255) NOT NULL DEFAULT 'N', order_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);
CREATE TABLE orders (grouped_orders_group_id int, product_id int, amount int, sum int, id int);

INSERT INTO product_group VALUES (1, 'Продукты питания');
INSERT INTO product_group VALUES (2, 'Строительные инструменты');
INSERT INTO product_group VALUES (3, 'Бытовая химия');
INSERT INTO product_group VALUES (4, 'Одежда');

INSERT INTO product VALUES (1, 'Хлеб', 32, 1);
INSERT INTO product VALUES (2, 'Сыр', 800, 1);
INSERT INTO product VALUES (3, 'Молоко', 55, 1);
INSERT INTO product VALUES (4, 'Свинина', 312, 1);
INSERT INTO product VALUES (5, 'Молоток', 452, 2);
INSERT INTO product VALUES (6, 'Плоскогубцы', 245, 2);
INSERT INTO product VALUES (7, 'Пила', 987, 2);
INSERT INTO product VALUES (8, 'Штраборез', 8654, 2);
INSERT INTO product VALUES (9, 'Fairy', 111, 3);
INSERT INTO product VALUES (10, 'Ariel', 545, 3);
INSERT INTO product VALUES (11, 'Мыло', 26, 3);
INSERT INTO product VALUES (12, 'Зубная паста', 65, 3);
INSERT INTO product VALUES (13, 'Брюки', 2500, 4);
INSERT INTO product VALUES (14, 'Платье', 1500, 4);
INSERT INTO product VALUES (15, 'Туфли', 2000, 4);
INSERT INTO product VALUES (16, 'Ремень', 500, 4);