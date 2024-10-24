package org.example;


import java.sql.DriverManager;


public class Connection1 {
    private final static String URL="jdbc:mysql://localhost:3306/FoodOrderSystem";
    private final static String USERNAME="root";
    private final static String PASSWORD="password";

    public java.sql.Connection conn1(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return  DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
