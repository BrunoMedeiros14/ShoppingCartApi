CREATE TABLE tb_category (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   category_name VARCHAR(255),
   CONSTRAINT pk_tb_category PRIMARY KEY (id)
);
