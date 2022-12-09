package com.stegemoen.timetable.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface iTimeTableDB<T> {
    T getElement(int t_id);
    List<T> getElementsFromDB() throws SQLException, IOException;
    boolean deleteElement(int t_id);
}
