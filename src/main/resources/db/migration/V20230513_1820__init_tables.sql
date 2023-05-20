CREATE TABLE customers (
    id BIGSERIAL PRIMARY KEY ,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES customers(id),
    address VARCHAR(255),
    bill DOUBLE PRECISION NOT NULL,
    date TIMESTAMP NOT NULL
);

CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image TEXT NOT NULL,
    description TEXT,
    category_id BIGINT REFERENCES categories(id),
    quantity INTEGER NOT NULL,
    price DOUBLE PRECISION NOT NULL
);

CREATE TABLE reviews (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES customers(id),
    text TEXT NOT NULL,
    product_id BIGINT REFERENCES products(id),
    date TIMESTAMP NOT NULL
);

CREATE TABLE shopping_carts (
    id bigserial PRIMARY KEY NOT NULL,
    customer_id bigint REFERENCES customers(id)
);

CREATE TABLE shopping_cart_items (
    id bigserial PRIMARY KEY NOT NULL,
    shopping_cart_id bigint REFERENCES shopping_carts(id),
    product_id bigint REFERENCES products(id),
    quantity integer
);

CREATE TABLE order_product (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT REFERENCES orders(id),
    product_id BIGINT REFERENCES products(id),
    quantity INTEGER
);