/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Currency;

import java.text.DecimalFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExchangeTransaction {

    // Fields for storing currency exchange transaction details
    private String loggedInUserID;
    private String sourceCurrency;
    private String targetCurrency;
    private double initialAmount;
    private double convertedAmount;
    private double processingFee;
    private double totalAmountPaid;

    // Constructor
    protected ExchangeTransaction(String sourceCurrency, String targetCurrency, double initialAmount, double convertedAmount, double processingFee) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.initialAmount = formatAmount(initialAmount);
        this.convertedAmount = formatAmount(convertedAmount);
        this.processingFee = formatAmount(processingFee);
        this.totalAmountPaid = formatAmount(this.initialAmount + this.processingFee);
    }

    // Method to format the amount to 2 decimal places
    private double formatAmount(double amount) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return Double.parseDouble(df.format(amount));
    }

    //Getters
    protected String getSourceCurrency() {
        return sourceCurrency;
    }

    protected String getTargetCurrency() {
        return targetCurrency;
    }

    protected double getInitialAmount() {
        return initialAmount;
    }

    protected double getConvertedAmount() {
        return convertedAmount;
    }

    protected double getProcessingFee() {
        return processingFee;
    }

    protected double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    // class to represent the result of updating user balance
    class UpdateBalanceResult {

        private double updatedSourceBalance;
        private double updatedTargetBalance;

        public UpdateBalanceResult(double updatedSourceBalance, double updatedTargetBalance) {
            this.updatedSourceBalance = updatedSourceBalance;
            this.updatedTargetBalance = updatedTargetBalance;
        }

        public double getUpdatedSourceBalance() {
            return updatedSourceBalance;
        }

        public double getUpdatedTargetBalance() {
            return updatedTargetBalance;
        }
    }

    // Method to update the user balance in database and add processing fee to admin's balance
    protected UpdateBalanceResult updateBalances(Connection con, String userID) throws SQLException {
        double updatedSourceBal = 0.0;
        double updatedTargetBal = 0.0;
        double updatedAdminSourceBal = 0.0;

        String userQuery = "UPDATE UserBalance SET " + sourceCurrency + " = ?, " + targetCurrency + " = ? WHERE UserID = ?";
        String adminID = "915d4c3cb8"; // Admin user ID
        String adminQuery = "UPDATE UserBalance SET " + sourceCurrency + " = ? WHERE UserID = ?";

        try {
            // Update user balance
            try (PreparedStatement userStatement = con.prepareStatement(userQuery)) {
                // Get current balance of both currencies
                double currentSourceBal = getCurrentBalance(con, userID, sourceCurrency);
                double currentTargetBal = getCurrentBalance(con, userID, targetCurrency);

                // Calculate updated balances
                updatedSourceBal = currentSourceBal - totalAmountPaid;
                updatedTargetBal = currentTargetBal + convertedAmount;

                userStatement.setDouble(1, updatedSourceBal);
                userStatement.setDouble(2, updatedTargetBal);
                userStatement.setString(3, userID);
                userStatement.executeUpdate();
            }

            // Update admin balance by adding the processing fee
            try (PreparedStatement adminStatement = con.prepareStatement(adminQuery)) {
                // Get current balance of source currency for admin
                double currentAdminSourceBal = getCurrentBalance(con, adminID, sourceCurrency);

                // Calculate updated balance for admin
                updatedAdminSourceBal = currentAdminSourceBal + processingFee;

                adminStatement.setDouble(1, updatedAdminSourceBal);
                adminStatement.setString(2, adminID);
                adminStatement.executeUpdate();
            }

            con.commit(); // Commit transaction

        } catch (SQLException e) {
            con.rollback(); // Rollback transaction if there's an error
            throw e;
        }

        if (userID.equals(adminID)) {
            return new UpdateBalanceResult(updatedAdminSourceBal, updatedTargetBal);
        } else {
            return new UpdateBalanceResult(updatedSourceBal, updatedTargetBal);
        }
    }

    // Method to get the current balance of a specific currency
    private double getCurrentBalance(Connection con, String userID, String currency) throws SQLException {
        this.loggedInUserID = userID;
        String query = "SELECT " + currency + " FROM UserBalance WHERE UserID = ?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, loggedInUserID);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble(currency);
                }
            }
        }

        return 0.0; // Return 0 if balance not found
    }

}
