package com.example.asm4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionHelper {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java_asm";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";


    public static Connection connection;
    public  static Connection getConnection() {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection( DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                }

            }catch (SQLException e) {
                e.printStackTrace();

            }catch (ClassNotFoundException e){
                e.printStackTrace();

            }
            return connection;
    }
}
