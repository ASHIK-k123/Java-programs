/*
11.b Read all existing records from table coffee (database: test)
and update an existing coffee product using its id.
*/

package com.mysql;

import java.sql.*;

public class Mysql_Update {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        try {
            // Step 1: Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "root", "ak@12345");

            System.out.println("Connected to database successfully!");

            // Step 3: Display existing records
            String selectQuery = "SELECT * FROM coffee";
            st = con.createStatement();
            rs = st.executeQuery(selectQuery);

            System.out.println("\nBefore Update:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("coffee_name") + " | " +
                        rs.getInt("price"));
            }

            rs.close();

            // Step 4: Update record using PreparedStatement
            String updateQuery = "UPDATE coffee SET price=? WHERE id=?";

            pst = con.prepareStatement(updateQuery);

            // Set new values
            pst.setInt(1, 950);   // new price
            pst.setInt(2, 102);   // id to update

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("\nRecord updated successfully!");
            } else {
                System.out.println("\nNo record found with given ID!");
            }

            // Step 5: Display updated records
            rs = st.executeQuery("SELECT * FROM coffee");

            System.out.println("\nAfter Update:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("coffee_name") + " | " +
                        rs.getInt("price"));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
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
