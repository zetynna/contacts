 CREATE TABLE IF NOT EXISTS contacts.contacts (
	id BIGINT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	cpf BIGINT NOT NULL,
	phone varchar(100),
	postcode varchar(100) NOT NULL,
	address varchar(100) NOT NULL,
	number INT NOT NULL,
	complement varchar(100) NULL,
	latitude VARCHAR(100) NULL,
	longitude varchar(100) NULL,
	CONSTRAINT Contacts_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS contacts.users (
	id BIGINT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	passcode varchar(100) NOT NULL,
	CONSTRAINT Users_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;