ALTER TABLE tb_category ADD CONSTRAINT uc_tb_category_category_name UNIQUE (category_name);
ALTER TABLE tb_cart ADD CONSTRAINT uc_tb_cart_payment UNIQUE (payment_id);

ALTER TABLE tb_product ADD CONSTRAINT FK_TB_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES tb_category (id);
ALTER TABLE tb_cart ADD CONSTRAINT FK_TB_CART_ON_PAYMENT FOREIGN KEY (payment_id) REFERENCES tb_payment (id);
ALTER TABLE tb_product_cart ADD CONSTRAINT FK_TB_PRODUCT_CART_ON_CART FOREIGN KEY (cart_id) REFERENCES tb_cart (id);
ALTER TABLE tb_product_cart ADD CONSTRAINT FK_TB_PRODUCT_CART_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES tb_product (id);
