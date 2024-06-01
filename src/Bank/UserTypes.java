/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

import java.sql.*;

public class UserTypes<T extends Comparable<T>> {
    private String userID;// ID of the user
    private T galleonMoneyDouble;// Amount of galleon money, generic type T
    private String userType;// Type of user based on galleon money
    private String currentUserType = "";// Current user type, initially empty
    private Account user;// User account information

    /**
     * Constructor to initialize UserTypes with user ID, galleon money, and user account.
     * @param userID The ID of the user.
     * @param galleonMoneyDouble The amount of galleon money.
     * @param user The user account details.
     */
    public UserTypes(String userID, T galleonMoneyDouble, Account user) {
        this.userID = userID;// Assign user ID
        this.galleonMoneyDouble = galleonMoneyDouble;// Assign galleon money amount
        this.user = user;// Assign user account
        this.userType = determineUserTypes(user);// Determine and assign user type
    }

    /**
     * Determines the user type based on the user's galleon amount.
     * @param userID The ID of the user.
     * @return The type of user.
     */
    public String determineUserTypeFromAmount(String userID) {
        String userType = "";
        double userAmount = getUserAmountFromDatabase(userID); // Retrieve user amount from the database

        // Determine user type based on specific conditions
        if (userID.equals("915d4c3cb8")) {
            userType = "Goblin";
        } else if (userAmount <= 500) {
            userType = "Silver Patronus";
        } else if (userAmount <= 2000) {
            userType = "Golden Patronus";
        } else {
            userType = "Platinum Patronus";
        }

        return userType;// Return the determined user type
    }

    /**
     * Retrieves the user's galleon amount from the database.
     * @param userID The ID of the user.
     * @return The amount of galleons the user has.
     */
    private double getUserAmountFromDatabase(String userID) {
        double amount = 0.0;// Initialize amount to 0
        Connection connection = null;// Database connection
        PreparedStatement statement = null; // SQL statement
        ResultSet resultSet = null;// Result set for query results

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");

            // SQL query to get galleon amount
            String query = "SELECT Galleon FROM userbalance WHERE userID = ?";
            statement = connection.prepareStatement(query);// Prepare SQL statement
            statement.setString(1, userID); // Set userID parameter

            resultSet = statement.executeQuery();

            if (resultSet.next()) { // If a result is found
                amount = resultSet.getDouble("Galleon");// Get galleon amount from result
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();// Print stack trace for exceptions
            // Handle the exception as needed
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        }

        return amount;// Return the retrieved amount
    }

    /**
     * Determines the user type based on the user's account details.
     * @param user The user account.
     * @return The determined user type.
     */
    public String determineUserTypes(Account user) {
        // Assuming userID is accessible in this method
        String newUserType = determineUserTypeFromAmount(userID);

        // Check if user has been upgraded to a higher tier
        if (!newUserType.equals(currentUserType)) {
            if (!currentUserType.isEmpty() && isUpgrade(currentUserType, newUserType) && !newUserType.equals("Silver Patronus")) {
               // Send upgrade email if user has been upgraded to a higher tier
                EmailVerification.sendEmail(user.getEmail(), "Your status in Egringotts", "Congratulations! You have been upgraded to " + newUserType + ". \nStay tuned for further information.");
            }
        }

        // Update the current user type
        currentUserType = newUserType;

        return newUserType;
    }

    /**
     * Checks if the user has been upgraded to a higher user type.
     * @param currentUserType The current user type.
     * @param newUserType The new user type.
     * @return True if the new user type is higher than the current user type, false otherwise.
     */
    private boolean isUpgrade(String currentUserType, String newUserType) {
        int currentLevel = getUserTypeLevel(currentUserType);// Get current user type level
        int newLevel = getUserTypeLevel(newUserType);// Get new user type level

        return newLevel > currentLevel;// Return true if new level is higher
    }

    /**
     * Gets the level of a user type.
     * @param userType The user type.
     * @return The level of the user type.
     */
    private int getUserTypeLevel(String userType) {
        switch (userType) {
            case "Silver Patronus":
                return 1;
            case "Golden Patronus":
                return 2;
            case "Platinum Patronus":
                return 3;
            case "Goblin":
                return 4;
            default:
                return 0;// Return 0 if user type is not recognized
        }
    }

    /**
     * Gets the user type.
     * @return The user type.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Gets the amount of galleon money.
     * @return The amount of galleon money.
     */
    public T getGalleonMoneyDouble() {
        return galleonMoneyDouble;
    }
}

