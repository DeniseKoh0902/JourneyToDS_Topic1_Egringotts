/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with various personal details and methods to manage the account.
 * 
 * @param <T> The type parameter for the account (e.g., user type).
 */
public class Account<T> implements Comparable<Account<T>> {

    protected String userID;// Unique identifier for the user
    private String username;// Username of the account holder
    private String telephone;// Telephone number of the account holder
    private String password;// Password for account security
    private String PIN;// PIN for additional security
    private String email;// Email address of the account holder
    private String address;// Physical address of the account holder
    private String DOB;// Date of birth of the account holder
    private List<Card> creditCards;// List of credit cards associated with the account
    private Card card;// Debit card associated with the account
    private UserAvatar userAvatar;// Avatar of the user
    private UserTypes user;// Type of user 

    /**
     * Default constructor. Initializes the userID with the same userID passed.
     */
    public Account() {
        this.userID = userID;
    }

    /**
     * Constructor to initialize account with personal information.
     * 
     * @param userID Unique identifier for the user
     * @param username Username of the account holder
     * @param telephone Telephone number of the account holder
     * @param password Password for account security
     * @param PIN PIN for additional security
     * @param email Email address of the account holder
     * @param address Physical address of the account holder
     * @param DOB Date of birth of the account holder
     * @param userAvatar Avatar of the user
     * @param card Debit card associated with the account
     */
    public Account(String userID, String username, String telephone, String password, String PIN, String email, String address, String DOB, UserAvatar userAvatar, Card card) {
        this.userID = userID;
        this.username = username;
        this.telephone = telephone;
        this.password = password;
        this.PIN = PIN;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.userAvatar = userAvatar;
        this.card = card;
    }

    //getters and setters
    public String getAddress() {
        return address;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public String getPIN() {
        return PIN;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Compares this account to another account based on userID.
     * 
     * @param other The other account to compare to.
     * @return A negative integer, zero, or a positive integer as this account's userID
     *         is less than, equal to, or greater than the specified account's userID.
     */
    @Override
    public int compareTo(Account<T> other) {
        return this.userID.compareTo(other.userID);
    }

    public Card getDebitCard() {
        return card;
    }

    public UserTypes getUser() {
        return user;
    }

    public void setUser(UserTypes user) {
        this.user = user;
    }

    public UserAvatar getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(UserAvatar userAvatar) {
        this.userAvatar = userAvatar;
    }

    /**
     * Adds a credit card to the account's list of credit cards.
     * 
     * @param creditCard The credit card to add.
     */
    public void addCreditCard(Card creditCard) {
        if (creditCards == null) {
            creditCards = new ArrayList<>();
        }
        creditCards.add(creditCard);
    }

    public List<Card> getCreditCards() {
        return creditCards;
    }
}
