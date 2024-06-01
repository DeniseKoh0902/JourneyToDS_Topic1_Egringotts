package Transfer;

// This class represents the data for a transfer transaction
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Transaction {

    //userID of the user
    private String fromAccount;
    //userID of the receiver
    private String toAccount;
    private double amount;
    private double balance;
    private String currency;
    private String category;
    private String dateOfTrans;
    private String fromUsername; // username of the sender
    private String toUsername;   // username of the receiver
    private String fromImagePath; // image path of the sender
    private String toImagePath;   // image path of the receiver

    /**
     * Default constructor.
     */
    public Transaction() {
    }

    /**
     * Constructor with parameters.
     *
     * @param fromAccount UserID of the sender
     * @param toAccount   UserID of the receiver
     * @param amount      Amount to be transferred
     * @param currency    Currency type of the amount
     * @param category    Category of the transaction
     */
    public Transaction(String fromAccount, String toAccount, double amount, String currency, String category) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.currency = currency;
        this.category = category;
        this.fromUsername = getUsernameByID(fromAccount); // Fetch and set the sender's username
        this.toUsername = getUsernameByID(toAccount); // Fetch and set the receiver's username
        this.fromImagePath = getImagePathByID(fromAccount); // Fetch and set the sender's image path
        this.toImagePath = getImagePathByID(toAccount); // Fetch and set the receiver's image path

    }

    //Getters
    public double getBalance() {
        return balance;
    }

    public String getCategory() {
        return category;
    }

    public String getDateOfTrans() {
        return dateOfTrans;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public String getToUsername() {
        return toUsername;
    }

    public String getFromImagePath() {
        return fromImagePath;
    }

    public String getToImagePath() {
        return toImagePath;
    }

    //Setters
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDateOfTrans(String dateOfTrans) {
        this.dateOfTrans = dateOfTrans;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
        this.fromUsername = getUsernameByID(fromAccount);
        this.fromImagePath = getImagePathByID(fromAccount); // Update the sender's image path when setting the userID

    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
        this.toUsername = getUsernameByID(toAccount);
        this.toImagePath = getImagePathByID(toAccount); // Update the receiver's image path when setting the userID

    }

    /**
     * Gets the UserID based on the username.
     *
     * @param username The username to search for
     * @return The UserID corresponding to the given username, or null if not found
     */
    private String getAccountID(String username) {
        String userID = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Initialize the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");

            String query = "SELECT UserID FROM Account WHERE Username = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, username);

            // Execute the query and fetch the result
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userID = resultSet.getString("UserID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userID; // Return the UserID if found, otherwise null
    }

    /**
     * Gets the username based on the UserID.
     *
     * @param userID The UserID to search for
     * @return The username corresponding to the given UserID, or null if not found
     */
    private String getUsernameByID(String userID) {
        String username = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Initialize the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");

            String query = "SELECT Username FROM Account WHERE UserID = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, userID);

            // Execute the query and fetch the result
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                username = resultSet.getString("Username");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return username; // Return the Username if found, otherwise null
    }

    /**
     * Gets the image path based on the UserID.
     *
     * @param userID The UserID to search for
     * @return The image path corresponding to the given UserID, or null if not found
     */
    private String getImagePathByID(String userID) {
        String imagePath = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Initialize the database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");

            String query = "SELECT Imagepath FROM Account WHERE UserID = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, userID);

            // Execute the query and fetch the result
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                imagePath = resultSet.getString("Imagepath");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return imagePath; // Return the Image Path if found, otherwise null
    }

    // Method to set the JLabel's image based on the image path
    public String setProfilePic(JLabel label, String userID) {
        if (label == null) {
            throw new IllegalArgumentException("JLabel cannot be null.");
        }

        String imagePath = getImagePathByID(userID);
        if (imagePath != null && !imagePath.isEmpty()) {
            label.setIcon(new ImageIcon(imagePath));
        } else {
            label.setIcon(null); // Optionally, set a default or null icon if no image path is found
        }
        return imagePath;
    }

}
