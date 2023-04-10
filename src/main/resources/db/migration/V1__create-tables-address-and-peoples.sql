CREATE TABLE peoples (
	id INT AUTO_INCREMENT NOT NULL,
    people_name VARCHAR(60) NOT NULL,
    birth_date DATE NOT NULL,
    main_address_id INT,
    PRIMARY KEY (id)
);

CREATE TABLE adresses(
	id INT AUTO_INCREMENT NOT NULL,
    public_place VARCHAR(80) NOT NULL,
    zip_code VARCHAR(9) NOT NULL,
    residence_number INT NOT NULL,
    city VARCHAR(60) NOT NULL,
    peopleId INT NOT NULL,
    
    PRIMARY KEY(id),
    FOREIGN KEY(peopleId) REFERENCES peoples(id)
);