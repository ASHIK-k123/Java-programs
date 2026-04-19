/*
11.a Read all existing records from table coffee (database: test)
and insert a new coffee product into it using Java (JDBC).
*/

package com.mysql;

import java.sql.*;

public class Mysql_Select_Insert {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        try {
            // Step 1: Load Driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "ak@12345");

            System.out.println("Connected to database successfully!");

            // Step 3: Execute SELECT query
            String selectQuery = "SELECT * FROM coffee";
            st = con.createStatement();
            rs = st.executeQuery(selectQuery);

            System.out.println("\nExisting Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.println(id + " | " + name + " | " + price);
            }

            // Step 4: Insert new record using PreparedStatement
            String insertQuery = "INSERT INTO coffee (coffee_name, price) VALUES (?, ?)";

            pst = con.prepareStatement(insertQuery);

            pst.setString(1, "Tajmahal");
            pst.setInt(2, 950);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("\nNew coffee product inserted successfully!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {

            // Step 5: Close resources
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources");
            }
        }
    }
}
