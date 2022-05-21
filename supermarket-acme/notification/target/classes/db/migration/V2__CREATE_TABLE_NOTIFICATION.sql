CREATE TABLE tb_notification(
    id serial PRIMARY KEY,
    notification VARCHAR(300) NOT NULL,
    create_at TIMESTAMP,
    sender VARCHAR(100),
    customer_mail VARCHAR(200),
    id_customer INTEGER NOT NULL
);