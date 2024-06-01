/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Currency;

import java.sql.*;
import java.util.*;

public class CurrencyGraphConstructor {
    
    private Map<String, CurrencyNode> nodes;
    private List<CurrencyEdge> edges;

    public CurrencyGraphConstructor() {
        this.nodes = new HashMap<>();
        this.edges = new ArrayList<>();
    }

    public void constructCurrencyGraph(Connection connection) {
    // fetch currency data from database to construct currency graph
        try {
            String query = "SELECT CurrencyName, RateToGalleon, ProcessingFeeRate FROM Currency";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // construct nodes(currency name) and edges(exchange rate and processing fee)
            while (resultSet.next()) {
                String currencyName = resultSet.getString("CurrencyName");
                double rateToGalleon = resultSet.getDouble("RateToGalleon");
                double processingFeeRate = resultSet.getDouble("ProcessingFeeRate");

                addNode(currencyName);

                // add edges between the currency and Galleon
                addEdge(currencyName, "Galleon", rateToGalleon, processingFeeRate);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a node (currency) to the graph
    private void addNode(String currencyName) {
        if (!nodes.containsKey(currencyName)) {
            nodes.put(currencyName, new CurrencyNode(currencyName));
        }
    }

    // Method to add an edge (exchange rate and processing fee) between two currencies
    private void addEdge(String sourceCurrency, String targetCurrency, double conversionRate, double processingFeeRate) {
        CurrencyNode source = nodes.get(sourceCurrency);
        CurrencyNode target = nodes.get(targetCurrency);
        if (source != null && target != null) {
            edges.add(new CurrencyEdge(source, target, conversionRate, processingFeeRate));
        }
    }
    
    // Method to get all edges
    public List<CurrencyEdge> getEdges() {
        return new ArrayList<>(edges);
    }
    
    // Method to get all currency names
    public List<String> getCurrencyNames() {
        return new ArrayList<>(nodes.keySet());
    }

    // Uncomment the main method to test the graph construction with a database connection
    /*
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/Egringotts";
        String user = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            CurrencyGraphConstructor graph = new CurrencyGraphConstructor();
            graph.constructCurrencyGraph(connection);

            //for debug use
            System.out.println("Currency Graph:");
        for (CurrencyEdge edge : graph.getEdges()) {
            CurrencyNode source = edge.getSourceCurrency();
            CurrencyNode target = edge.getTargetCurrency();
            double exchangeRate = edge.getExchangeRate();
            double processingFeeRate = edge.getProcessingFeeRate();
            System.out.println(source.getCurrencyName() + " -> " + target.getCurrencyName() +
                    " : Exchange Rate = " + exchangeRate + ", Processing Fee Rate= " + processingFeeRate);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
}
