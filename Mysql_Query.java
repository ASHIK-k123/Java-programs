/*12b. Read all the existing records from the table coffee which is from the database test
and query coffee name starting with ‘D’ in the table.*/

package com.mysql;

import java.sql.*;
import java.util.Properties;

public class Mysql_Query {

    public static void main(String[] args) {

        Connection dbConnection = null;

        try {
            // Load driver (important)
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/test";

            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "ak@12345"); // change if needed

            dbConnection = DriverManager.getConnection(url, info);

            System.out.println("Successfully connected to MySQL database test");

            // SQL query: coffee names starting with 'D'
            String query = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";

            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\n--- Coffee Names Starting with 'D' ---");

            while (rs.next()) {

                int id = rs.getInt("id");
                String coffee_name = rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.println(id + " " + coffee_name + " " + price);
            }

            rs.close();
            st.close();
            dbConnection.close();

        } catch (Exception e) {
            System.out.println("Got an exception!");
            e.printStackTrace();
        }
    }
}
