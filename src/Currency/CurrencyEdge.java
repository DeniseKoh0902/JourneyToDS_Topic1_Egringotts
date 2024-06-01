/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Currency;

public class CurrencyEdge {

    private CurrencyNode sourceCurrency;
    private CurrencyNode targetCurrency;
    private double exchangeRate;
    private double processingFeeRate;

    //Constructor
    public CurrencyEdge(CurrencyNode sourceCurrency, CurrencyNode targetCurrency, double exchangeRate, double processingFeeRate) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.exchangeRate = exchangeRate;
        this.processingFeeRate = processingFeeRate;
    }

    //Getters
    public CurrencyNode getSourceCurrency() {
        return sourceCurrency;
    }

    public CurrencyNode getTargetCurrency() {
        return targetCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double getProcessingFeeRate() {
        return processingFeeRate;
    }
}
