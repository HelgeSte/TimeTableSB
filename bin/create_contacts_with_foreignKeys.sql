 USE sb_timetable;
CREATE TABLE Contacts (
	ContactID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    FirstName varchar(50),
    LastName varchar(50),
    Email varchar(255),
    Phone varchar(50),
    CompanyID int,
    FOREIGN KEY (CompanyID) REFERENCES Companies(CompanyID)
);