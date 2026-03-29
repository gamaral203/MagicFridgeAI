CREATE TABLE food_item (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255),
    quantidade INT,
    validade TIMESTAMP
);