DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_group;

CREATE TABLE product_group (id int, product_group_name varchar(255));
CREATE TABLE product (id int, product_name varchar(255), product_price int, product_group_id int);
CREATE TABLE orders (id int, product_id int, amount int, client_name varchar(255), order_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);


INSERT INTO orders (id, product_id, amount, client_name) VALUES (1, 1, 3, 'Tamerlan');


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