 USE sb_timetable;
CREATE TABLE Projects (
	ProjectId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ProjectName varchar(255),
    isActive boolean,
    EmployeeID int,
    CustomerID int,
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);