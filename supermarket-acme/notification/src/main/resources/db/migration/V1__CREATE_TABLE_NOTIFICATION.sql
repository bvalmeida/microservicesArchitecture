CREATE TABLE tb_notification(
    id serial PRIMARY KEY,
    notification VARCHAR(300) NOT NULL,
    create_at TIMESTAMP
);