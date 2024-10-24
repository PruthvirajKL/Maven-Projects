package org.example;


import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection1 conn=new Connection1();
        Connection con= conn.conn1();
        Orders o=new Orders();
        Scanner sc=new Scanner(System.in);
        String choices = "";
        do {
            System.out.println("Enter a choice to perform the below function ");
            System.out.println("1.Insert the Query\n2.Update the Query\n3.Delete the Query\n4.To see the table\n5.Exit");
            int c = sc.nextInt();
            sc.nextLine();
            switch (c) {
                case 1:
                    System.out.println("enter the details to add-customer_name,phone_number," +
                            "item_name,quantity,price,status");
                    String insertCustomer_name = sc.nextLine();
                    String insertPhoneNumber = sc.nextLine();
                    String insertItemName = sc.nextLine();
                    int insertQuantity = sc.nextInt();
                    double insertPrice = sc.nextDouble();
                    sc.nextLine();
                    String insertStatus = sc.nextLine();

                    o.setCustomer_name(insertCustomer_name);
                    o.setPhone_number(insertPhoneNumber);
                    o.setItem_name(insertItemName);
                    o.setQuantity(insertQuantity);
                    o.setPrice(insertPrice);
                    o.setStatus(insertStatus);

                    Queries.insertquery(con, o);
                    System.out.print("Do You Want to continue...\npress Y/y => YES or N/n => NO  ");
                    choices =sc.next();
                    break;
                case 2:
                    System.out.println("enter Quantity,status and Order_id");
                    int updateQuantity = sc.nextInt();
                    sc.nextLine();
                    String updateStatus = sc.nextLine();
                    int a = sc.nextInt();
                    o.setQuantity(updateQuantity);
                    o.setStatus(updateStatus);
                    Queries.updatequery(con, o, a);
                    System.out.print("Do You Want to continue...\npress Y/y => YES or N/n => NO  ");
                    choices =sc.next();
                    break;
                case 3:
                    System.out.println("enter the order id");
                    int b = sc.nextInt();
                    Queries.deletequery(con, b);
                    System.out.print("Do You Want to continue...\npress Y/y => YES or N/n => NO  ");
                    choices =sc.next();
                    break;
                case 4:
                    Queries.viewtable(con);
                    System.out.print("Do You Want to continue...\npress Y/y => YES or N/n => NO  ");
                    choices =sc.next();
                    break;
                case 5:
                    System.out.println("Exiting.....");
                    return;
                default:
                    System.out.println("enter correct choice.....");
            }
        }while (choices.equalsIgnoreCase("Y"));
    }
}