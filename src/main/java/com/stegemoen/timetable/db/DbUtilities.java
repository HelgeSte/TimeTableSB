package com.stegemoen.timetable.db;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtilities {
    public static Connection getConnection() throws SQLException, IOException {
        var props = new Properties();
        try (Reader in = Files.newBufferedReader(
                Path.of("database.properties"), StandardCharsets.UTF_8)) {
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.driver");
        if(drivers != null) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.user");
        String password = props.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password); // end of get connection
    }
}
