CREATE TABLE persons (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(50),
                          lastname VARCHAR(100),
                          dni CHAR(9),
                          position VARCHAR(100),
                          phone VARCHAR(20),
                          email VARCHAR(100),
                          privateTransport BOOLEAN,
                          IBAN VARCHAR(24),



);

CREATE TABLE projects (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          number INT,
                          name VARCHAR(100),
                          email VARCHAR(100),

);

CREATE TABLE clients (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    NIF VARCHAR(12),


)