 USE sb_timetable;
CREATE TABLE Contacts (
	contact_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(50),
    last_name varchar(50),
    Email varchar(255),
    Phone varchar(50),
    company_id int,
    FOREIGN KEY (company_id) REFERENCES Companies(company_id)
);