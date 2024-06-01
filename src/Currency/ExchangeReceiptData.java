/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Currency;

//This class represents the data for an exchange transaction receipt
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ExchangeReceiptData {
    private String transactionID;
    private String userID;
    private String sourceCurrency;
    private String targetCurrency;
    private double initialAmount;
    private double processingFee;
    private double totalAmountPaid;
    private double convertedAmount;
    private double updatedSourceCurrencyBalance;
    private double updatedTargetCurrencyBalance;
    private String timestamp;

    // Constructor
    protected ExchangeReceiptData(String transactionID, String userID, ExchangeTransaction exchange, double updatedSourceCurrencyBalance, double updatedTargetCurrencyBalance) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.sourceCurrency = exchange.getSourceCurrency();
        this.targetCurrency = exchange.getTargetCurrency();
        this.initialAmount = exchange.getInitialAmount();
        this.processingFee = exchange.getProcessingFee();
        this.totalAmountPaid = exchange.getTotalAmountPaid();
        this.convertedAmount = exchange.getConvertedAmount();
        setTransactionDate();
        this.updatedSourceCurrencyBalance = updatedSourceCurrencyBalance;
        this.updatedTargetCurrencyBalance = updatedTargetCurrencyBalance;
    }

    // Getters
    protected String getTransactionID() {
        return transactionID;
    }

    protected String getUserID() {
        return userID;
    }

    protected String getSourceCurrency() {
        return sourceCurrency;
    }

    protected String getTargetCurrency() {
        return targetCurrency;
    }

    protected double getInitialAmount() {
        return initialAmount;
    }

    protected double getProcessingFee() {
        return processingFee;
    }

    protected double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    protected double getConvertedAmount() {
        return convertedAmount;
    }

    protected String getTimestamp() {
        return timestamp;
    }

    protected double getUpdatedSourceCurrencyBalance() {
        return updatedSourceCurrencyBalance;
    }

    protected double getUpdatedTargetCurrencyBalance() {
        return updatedTargetCurrencyBalance;
    }
    
    //set the transaction date using the current timestamp
    public void setTransactionDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        timestamp = dtf.format(now);
    }

}
