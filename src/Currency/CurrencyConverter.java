/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Currency;

import java.util.List;

public class CurrencyConverter {

    private CurrencyGraphConstructor graph;

    // Constructor for initializing CurrencyConverter with a currency graph
    public CurrencyConverter(CurrencyGraphConstructor graph) {
        this.graph = graph;
    }

    public List<String> getCurrencies() {
        return graph.getCurrencyNames();
    }

    public ExchangeTransaction convertCurrency(String sourceCurrency, String targetCurrency, double initialAmount) {
        // Check if the source and target currencies exist in the graph
        if (!graph.getCurrencyNames().contains(sourceCurrency) || !graph.getCurrencyNames().contains(targetCurrency)) {
            System.out.println("Invalid source or target currency.");
            return new ExchangeTransaction(null, null, 0, 0, 0);
        }

        // Check if source and target currencies are the same
        if (sourceCurrency.equals(targetCurrency)) {
            System.out.println("Source and target currencies are the same.");
            return new ExchangeTransaction(null, null, 0, 0, 0);
        }

        double sourceAmount = initialAmount;
        double convertedAmount = 0;

        // Get all the edges in the currency graph
        List<CurrencyEdge> edges = graph.getEdges();

        //For case 1 and 2 targetCurrency will be Galleon
        // Case 1: Convert from Galleon(source) to target
        if (sourceCurrency.equals("Galleon")) {
            for (CurrencyEdge edge : edges) {
                System.out.println(edge);
                if (edge.getSourceCurrency().getCurrencyName().equals(targetCurrency)) {
                    double exchangeRate = edge.getExchangeRate();
                    convertedAmount = sourceAmount * exchangeRate;
                    double processingFee = sourceAmount * edge.getProcessingFeeRate();

                    return new ExchangeTransaction(sourceCurrency, targetCurrency, sourceAmount, convertedAmount, processingFee);
                }
            }
        } else // Case 2: Convert from source to Galleon(target)
        if (targetCurrency.equals("Galleon")) {
            for (CurrencyEdge edge : edges) {
                if (edge.getSourceCurrency().getCurrencyName().equals(sourceCurrency)) {
                    double exchangeRate = edge.getExchangeRate();
                    convertedAmount = sourceAmount / exchangeRate;
                    double processingFee = sourceAmount * edge.getProcessingFeeRate();
                    return new ExchangeTransaction(sourceCurrency, targetCurrency, sourceAmount, convertedAmount, processingFee);
                }
            }
        } else {
            // Case 3: Convert from source to target via Galleon
            double rateToGalleon = 0;
            double rateToTarget = 0;
            double processingFeeRate1 = 0;
            double processingFeeRate2 = 0;

            // Loop through the edges to find the exchange rates and processing fees
            for (CurrencyEdge edge : edges) {
                // Check if the current edge's source currency matches the given source currency
                if (edge.getSourceCurrency().getCurrencyName().equals(sourceCurrency)) {
                    rateToGalleon = edge.getExchangeRate();
                    processingFeeRate1 = edge.getProcessingFeeRate();
                    // print path from Galleon to source currency (debug use)
                    System.out.println("Galleon -> " + edge.getSourceCurrency().getCurrencyName()
                            + " : Exchange Rate = " + edge.getExchangeRate()
                            + ", Processing Fee Rate = " + processingFeeRate1);
                } 
                
                // Check if the current edge's target currency matches the given target currency
                else if (edge.getSourceCurrency().getCurrencyName().equals(targetCurrency)) {
                    rateToTarget = edge.getExchangeRate();
                    processingFeeRate2 = edge.getProcessingFeeRate();
                    // print path from Galleon to target currency (debug use)
                    System.out.println("Galleon -> " + edge.getSourceCurrency().getCurrencyName()
                            + " : Exchange Rate = " + edge.getExchangeRate()
                            + ", Processing Fee Rate = " + processingFeeRate2);
                }
            }
            
            // Calculate converted amount and processing fee if both rates are found
            if (rateToGalleon != 0 && rateToTarget != 0) {
                convertedAmount = (sourceAmount / rateToGalleon) * rateToTarget;
                double processingFee = (sourceAmount * processingFeeRate1) + (sourceAmount * processingFeeRate2);

                return new ExchangeTransaction(sourceCurrency, targetCurrency, sourceAmount, convertedAmount, processingFee);
            }
        }

        // If no suitable conversion edge found
        System.out.println("No suitable conversion path found.");
        return new ExchangeTransaction(null, null, 0, 0, 0);
    }

}
