 USE sb_timetable;
CREATE TABLE Projects (
	project_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    project_name varchar(255),
    active boolean,
    employee_id int,
    company_id int,
    FOREIGN KEY (employee_id) REFERENCES Employees(employee_id),
    FOREIGN KEY (company_id) REFERENCES Companies(company_id)
);