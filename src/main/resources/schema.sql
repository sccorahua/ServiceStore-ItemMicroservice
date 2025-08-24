CREATE TABLE IF NOT EXISTS item (
    item_id CHAR(4) NOT NULL PRIMARY KEY,
    item_name VARCHAR(200) NOT NULL,
    stock INT NOT NULL,
    item_description VARCHAR(500) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);