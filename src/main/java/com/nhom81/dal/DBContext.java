package com.nhom81.dal;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    protected Connection conn;

    public DBContext() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Trading2024;trustServerCertificate=true;";
            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
