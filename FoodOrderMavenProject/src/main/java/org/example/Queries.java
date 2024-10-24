package org.example;

import java.sql.*;
import java.sql.Timestamp;

public class Queries {
    public static void insertquery(Connection conn, Orders o) {
    String query=("insert into Orders (customer_name,phone_number,item_name,quantity,price,status)values" +
            "(?,?,?,?,?,?)");
        try {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, o.getCustomer_name());
            ps.setString(2, o.getPhone_number());
            ps.setString(3, o.getItem_name());
            ps.setInt(4,o.getQuantity());
            ps.setDouble(5,o.getPrice());
            ps.setString(6,o.getStatus());
            ps.execute();
            System.out.println("Insertion done");
        } catch (SQLException e) {
            System.out.println("Insertion not done");
        }
    }
    public static void updatequery(Connection conn,Orders o,int a){
        String query=("update orders set Quantity=(?),status=(?) where Order_id=(?)");
        try {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1,o.getQuantity());
            ps.setString(2,o.getStatus());
            ps.setInt(3,a);
            ps.execute();
            System.out.println("Update Done");
        } catch (SQLException e) {
            System.out.println("Update not done");
        }
    }
    public static void deletequery(Connection conn,int b){
        String query=("delete from orders where order_id=(?)");
        try {
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1,b);
            ps.execute();
            System.out.println("Delete Done");
        } catch (SQLException e) {
            System.out.println("Delete not Done");
        }
    }
    public static void viewtable(Connection conn){
        String query=("select * from orders");
        try {
            PreparedStatement ps=conn.prepareStatement(query);
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                int Order_id=resultSet.getInt(1);
                String Customer_name=resultSet.getString(2);
                String phone_number=resultSet.getString(3);
                String item_name=resultSet.getString(4);
                int quantity=resultSet.getInt(5);
                double price=resultSet.getDouble(6);
                double total_amount=resultSet.getDouble(7);
                Timestamp timestamp=resultSet.getTimestamp(8);
                String status=resultSet.getString(9);
                System.out.println("->Order_id:"+Order_id+" Customer_name:"+Customer_name+
                        " phone_number:"+phone_number+" item_name:"+item_name+
                        " quantity:"+quantity+" price:"+price+" total_amount:"+total_amount+
                        " Date_and_Time:"+timestamp+" status:"+status);
            }
            System.out.println("record printed done ");
        } catch (SQLException e) {
            System.out.println("View Table not happen");
        }
    }
}
