 USE sb_timetable;
 /* This script is used as reference for creating the Activity class */
CREATE TABLE Activity (
	activity_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    comment varchar(255),
    active boolean,
    project_manager_id int,
    project_idcompanies int,
    FOREIGN KEY (project_manager_id) REFERENCES Employees(employee_id),
    FOREIGN KEY (project_id) REFERENCES Projects(project_id)
);