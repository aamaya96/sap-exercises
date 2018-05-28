CREATE TABLE country (
	id		INT AUTO_INCREMENT PRIMARY KEY,
	name		VARCHAR(50) NOT NULL
);

CREATE TABLE api_user (
	user_name	        VARCHAR(20) PRIMARY KEY,
	first_name		VARCHAR(25),
	last_name		VARCHAR(25),
	country_id		INT,
	FOREIGN KEY (country_id) REFERENCES COUNTRY(id) ON DELETE CASCADE 
);
