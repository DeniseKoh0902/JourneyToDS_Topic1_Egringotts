/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Currency;

import java.util.HashMap;
import java.util.Map;

public class UserBal {
    
    private Map<String, Double> currencyBalances;  //store all of the currency balances of user in a map
    private String userID;

    //Constuctor
    public UserBal(String userID){
        this.userID = userID;
        currencyBalances = new HashMap<>();
    }

    public String getUserID() {
        return userID;
    }
   
    //Setter for the balance for a specific currency
    public void setBalance(String currency, double balance) {
        currencyBalances.put(currency, balance);
    }
    
    public double getBalance(String currency) {
        return currencyBalances.getOrDefault(currency, 0.0);
    }
    
    public Map<String, Double> getAllBalances() {
        return currencyBalances;
    }
}
