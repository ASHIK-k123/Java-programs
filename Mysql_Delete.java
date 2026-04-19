/*12a. Read all the existing records from the table coffee which is from the database test
and delete an existing coffee product from the table with its id.*/

package com.mysql;

import java.sql.*;
import java.util.Properties;

public class Mysql_Delete {

    public static void main(String[] args) {

        Connection dbConnection = null;

        try {
            String url = "jdbc:mysql://localhost/test";

            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "ak@12345"); // put your password if any

            dbConnection = DriverManager.getConnection(url, info);

            if (dbConnection != null) {
                System.out.println("Successfully connected to MySQL database test");
            }

            // =========================
            // 1. READ RECORDS
            // =========================
            String query = "SELECT * FROM coffee";

            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\n--- Coffee Table Records ---");

            while (rs.next()) {
                int id = rs.getInt("id");
                String coffee_name = rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.println(id + " , " + coffee_name + " , " + price);
            }

            rs.close();
            st.close();

            // =========================
            // 2. DELETE RECORD
            // =========================
            int deleteId = 107; // change ID as needed

            String deleteQuery = "DELETE FROM coffee WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(deleteQuery);
            ps.setInt(1, deleteId);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("\nRecord deleted successfully (ID = " + deleteId + ")");
            } else {
                System.out.println("\nNo record found with ID = " + deleteId);
            }

            ps.close();
            dbConnection.close();

        } catch (Exception e) {
            System.out.println("Got an exception!");
            e.printStackTrace();
        }
    }
}
