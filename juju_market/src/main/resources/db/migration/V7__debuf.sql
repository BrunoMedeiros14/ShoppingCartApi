INSERT INTO tb_category (category_name) VALUES
('Limpeza'),
('Cozinha'),
('Higiene');

INSERT INTO tb_product (measurement_unit, product_name, unit_price, category_id) VALUES
('un', 'Vassoura', 102.39, 1),
('un', 'Toalha', 44.24, 3);

INSERT INTO tb_cart (payment_status) VALUES
('AWAITING'),
('AWAITING');