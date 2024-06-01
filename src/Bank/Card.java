/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Represents a bank card with details like card number, CVV, creation and expiry dates, user ID, and transfer limit.
 */
public class Card {

    private String cardNum;// Card number
    private int cVV;// CVV code
    private Date dateCreated = new Date();// Date the card was created
    private Date expiryDate;// Card expiry date
    private String userId;// User ID associated with the card
    private int transferlimit;// Transfer limit for the card

    /**
     * Default constructor that generates a random card number, CVV, and sets an expiry date 5 years from the creation date.
     */
    public Card() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int cardNum1 = 1000 + random.nextInt(9000);// Generate a random 4-digit number in the range [1000, 9999]
        int cardNum2 = random.nextInt(10000); // Generate number in the range [0, 9999]
        int cardNum3 = random.nextInt(10000);
        int cardNum4 = random.nextInt(10000);
        this.cVV = random.nextInt(1000);// Generate a random 3-digit CVV number

        // Format the numbers with leading zeros
        String formattedCardNum2 = String.format("%04d", cardNum2);
        String formattedCardNum3 = String.format("%04d", cardNum3);
        String formattedCardNum4 = String.format("%04d", cardNum4);

        // Append the formatted numbers to StringBuilder
        sb.append(cardNum1).append("  ").append(formattedCardNum2).append("  ").append(formattedCardNum3).append("  ").append(formattedCardNum4);
        this.cardNum = sb.toString();

        // Set the expiry date to 5 years from the date of creation
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCreated);
        calendar.add(Calendar.YEAR, 5);
        this.expiryDate = calendar.getTime();
    }

    /**
     * Constructor for creating a card with specified details.
     * 
     * @param userId        The user ID associated with the card
     * @param cardNum       The card number
     * @param cVV           The CVV code
     * @param expiryDate    The expiry date in "MM/yyyy" format
     * @param transferlimit The transfer limit for the card
     */
    public Card(String userId, String cardNum, int cVV, String expiryDate, int transferlimit) {
        this.cardNum = cardNum;
        this.cVV = cVV;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        try {
            this.expiryDate = dateFormat.parse(expiryDate);// Parse the expiry date from the given string
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception according to your requirements
        }
        this.userId = userId;
        this.transferlimit = transferlimit;
    }

    /**
     * Constructor for creating a credit card with specified details.
     * 
     * @param userId     The user ID associated with the card
     * @param cardNum    The card number
     * @param cVV        The CVV code
     * @param expiryDate The expiry date in "MM/yyyy" format
     * @param balance    The balance of the credit card
     */
    public Card(String userId, String cardNum, int cVV, String expiryDate, double balance) {
        this.cardNum = cardNum;
        this.cVV = cVV;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        try {
            this.expiryDate = dateFormat.parse(expiryDate);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception according to your requirements
        }
        this.userId = userId;
        this.transferlimit = transferlimit;
    }

    // Getter and setter methods
    public int getTransferlimit() {
        return transferlimit;
    }

    public void setTransferlimit(int transferlimit) {
        this.transferlimit = transferlimit;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCVV(int cVV) {
        this.cVV = cVV;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCVV() {
        return cVV;
    }

    public String getExpiryDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        return sdf.format(expiryDate);// Format the expiry date to "MM/yyyy"
    }

    public static void main(String[] args) {
        Card card = new Card();// Create a new card instance
        // Print the generated card details
        System.out.println("Generated Card Number: " + card.getCardNum());
        System.out.println("Generated CVV: " + card.getCVV());
        System.out.println("Expiry Date: " + card.getExpiryDate());
    }

}
