package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {
    public static void main(String[] args){
        System.out.println("Welcome to JDBC");
        DatabaseConnectionManager connectionManager = new DatabaseConnectionManager("localhost",
                "shop", "postgres", "123");

        System.out.println("Connect to database was successfully...");
    }
}



