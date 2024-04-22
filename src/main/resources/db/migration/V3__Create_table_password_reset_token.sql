 CREATE TABLE IF NOT EXISTS contacts.passwordrecovery (
	id BIGINT auto_increment NOT NULL,
	token varchar(100) NOT NULL,
	users varchar(100) NOT NULL,
	expirationDate varchar(100) NOT NULL,
	CONSTRAINT PasswordRecovery_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;