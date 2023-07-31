INSERT INTO tb_category (category_name) VALUES
('Limpeza'),
('Cozinha'),
('Higiene');

INSERT INTO tb_product (measurement_unit, product_name, unit_price, category_id) VALUES
('un', 'Vassoura', 12.39, 1),
('un', 'Toalha', 22.24, 3);

INSERT INTO tb_cart (payment_status) VALUES
('AWAITING'),
('AWAITING');

INSERT INTO tb_product_cart (product_id, quantity, acquisition_price, cart_id) values
(1, 3, 22.24, 1),
(2, 4, 22.24, 1),
(2, 5, 22.24, 2);