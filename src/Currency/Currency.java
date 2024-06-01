/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Currency;

//class to store details for a currency
public class Currency {
    private int currencyID;
    private String currencyName;
    private double rateToGalleon;
    private double processingFeeRate;

    public Currency(int currencyID, String currencyName, double rateToGalleon, double processingFeeRate) {
        this.currencyID = currencyID;
        this.currencyName = currencyName;
        this.rateToGalleon = rateToGalleon;
        this.processingFeeRate = processingFeeRate;
    }

    // Getter & Setter 
    public int getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(int currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getRateToGalleon() {
        return rateToGalleon;
    }

    public void setRateToGalleon(double rateToGalleon) {
        this.rateToGalleon = rateToGalleon;
    }

    public double getProcessingFeeRate() {
        return processingFeeRate;
    }

    public void setProcessingFeeRate(double processingFeeRate) {
        this.processingFeeRate = processingFeeRate;
    }
}
