/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bank;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author USER
 */
public class PensievePast extends javax.swing.JFrame {

    private Account user;   // User account details

    /**
     * Creates new form TransactionHistory
     */
    public PensievePast() {
        initComponents();
    }

    public PensievePast(Account user) {
        setTitle("Transaction History Page");
        this.user = user;
        initComponents();
        Wand.setCustomIcon(this);
        Wand.setCustomCursor(this);
        displayTransactionHistory();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_displayDetails = new javax.swing.JPanel();
        to = new javax.swing.JLabel();
        totalamountpaid = new javax.swing.JLabel();
        currency = new javax.swing.JLabel();
        transfertypes = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        timestamp = new javax.swing.JLabel();
        transactionid = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        lbl_totalamountpaid = new javax.swing.JLabel();
        lbl_currency = new javax.swing.JLabel();
        lbl_transfertypes = new javax.swing.JLabel();
        lbl_from = new javax.swing.JLabel();
        lbl_to = new javax.swing.JLabel();
        lbl_timestamp = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        lbl_transactionid = new javax.swing.JLabel();
        details_background = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTransactionHistoryList = new javax.swing.JList<>();
        lbl_transactionHistory = new javax.swing.JLabel();
        btn_expenditure = new javax.swing.JButton();
        btn_filter = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 600));
        getContentPane().setLayout(null);

        panel_displayDetails.setBackground(new java.awt.Color(255, 255, 255));
        panel_displayDetails.setBorder(new javax.swing.border.MatteBorder(null));
        panel_displayDetails.setLayout(null);

        to.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        to.setForeground(new java.awt.Color(255, 255, 255));
        to.setText("To");
        panel_displayDetails.add(to);
        to.setBounds(16, 208, 179, 28);

        totalamountpaid.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        totalamountpaid.setForeground(new java.awt.Color(255, 255, 255));
        totalamountpaid.setText("Total Amount");
        panel_displayDetails.add(totalamountpaid);
        totalamountpaid.setBounds(16, 16, 179, 28);

        currency.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        currency.setForeground(new java.awt.Color(255, 255, 255));
        currency.setText("Currency Used");
        panel_displayDetails.add(currency);
        currency.setBounds(16, 64, 179, 28);

        transfertypes.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        transfertypes.setForeground(new java.awt.Color(255, 255, 255));
        transfertypes.setText("Categorical Types");
        panel_displayDetails.add(transfertypes);
        transfertypes.setBounds(16, 112, 179, 28);

        from.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        from.setForeground(new java.awt.Color(255, 255, 255));
        from.setText("From");
        panel_displayDetails.add(from);
        from.setBounds(16, 160, 179, 28);

        timestamp.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        timestamp.setForeground(new java.awt.Color(255, 255, 255));
        timestamp.setText("Date/ Time");
        panel_displayDetails.add(timestamp);
        timestamp.setBounds(16, 256, 179, 28);

        transactionid.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        transactionid.setForeground(new java.awt.Color(255, 255, 255));
        transactionid.setText("Transaction ID");
        panel_displayDetails.add(transactionid);
        transactionid.setBounds(16, 352, 179, 28);

        status.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText("Status");
        panel_displayDetails.add(status);
        status.setBounds(16, 304, 179, 28);

        lbl_totalamountpaid.setBackground(new java.awt.Color(0, 0, 0));
        lbl_totalamountpaid.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        lbl_totalamountpaid.setForeground(new java.awt.Color(255, 255, 255));
        panel_displayDetails.add(lbl_totalamountpaid);
        lbl_totalamountpaid.setBounds(201, 16, 213, 30);

        lbl_currency.setBackground(new java.awt.Color(0, 0, 0));
        lbl_currency.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        lbl_currency.setForeground(new java.awt.Color(255, 255, 255));
        panel_displayDetails.add(lbl_currency);
        lbl_currency.setBounds(201, 64, 213, 30);

        lbl_transfertypes.setBackground(new java.awt.Color(0, 0, 0));
        lbl_transfertypes.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        lbl_transfertypes.setForeground(new java.awt.Color(255, 255, 255));
        panel_displayDetails.add(lbl_transfertypes);
        lbl_transfertypes.setBounds(201, 112, 213, 30);

        lbl_from.setBackground(new java.awt.Color(0, 0, 0));
        lbl_from.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        lbl_from.setForeground(new java.awt.Color(255, 255, 255));
        panel_displayDetails.add(lbl_from);
        lbl_from.setBounds(201, 160, 213, 30);

        lbl_to.setBackground(new java.awt.Color(0, 0, 0));
        lbl_to.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        lbl_to.setForeground(new java.awt.Color(255, 255, 255));
        panel_displayDetails.add(lbl_to);
        lbl_to.setBounds(201, 208, 213, 30);

        lbl_timestamp.setBackground(new java.awt.Color(0, 0, 0));
        lbl_timestamp.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        lbl_timestamp.setForeground(new java.awt.Color(255, 255, 255));
        panel_displayDetails.add(lbl_timestamp);
        lbl_timestamp.setBounds(201, 256, 213, 30);

        lbl_status.setBackground(new java.awt.Color(0, 0, 0));
        lbl_status.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        lbl_status.setForeground(new java.awt.Color(102, 255, 102));
        panel_displayDetails.add(lbl_status);
        lbl_status.setBounds(201, 304, 213, 30);

        lbl_transactionid.setBackground(new java.awt.Color(0, 0, 0));
        lbl_transactionid.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        lbl_transactionid.setForeground(new java.awt.Color(255, 255, 255));
        panel_displayDetails.add(lbl_transactionid);
        lbl_transactionid.setBounds(201, 350, 213, 30);

        details_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/transactionDetails.jpg"))); // NOI18N
        panel_displayDetails.add(details_background);
        details_background.setBounds(0, 0, 420, 390);

        getContentPane().add(panel_displayDetails);
        panel_displayDetails.setBounds(610, 100, 420, 390);

        displayTransactionHistoryList.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        displayTransactionHistoryList.setForeground(new java.awt.Color(51, 51, 51, 0));
        jScrollPane1.setViewportView(displayTransactionHistoryList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 100, 570, 440);

        lbl_transactionHistory.setFont(new java.awt.Font("Calibri", 1, 45)); // NOI18N
        lbl_transactionHistory.setForeground(new java.awt.Color(255, 255, 255));
        lbl_transactionHistory.setText("Transaction History");
        getContentPane().add(lbl_transactionHistory);
        lbl_transactionHistory.setBounds(40, 30, 440, 60);

        btn_expenditure.setBackground(new java.awt.Color(252, 252, 236));
        btn_expenditure.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_expenditure.setText("Expenditure Categorized");
        btn_expenditure.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_expenditure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_expenditureActionPerformed(evt);
            }
        });
        getContentPane().add(btn_expenditure);
        btn_expenditure.setBounds(800, 40, 220, 40);

        btn_filter.setBackground(new java.awt.Color(252, 252, 236));
        btn_filter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_filter.setText("Filter Transaction");
        btn_filter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filterActionPerformed(evt);
            }
        });
        getContentPane().add(btn_filter);
        btn_filter.setBounds(840, 500, 180, 40);

        btn_back.setBackground(new java.awt.Color(252, 252, 236));
        btn_back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_back.setText("Back");
        btn_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        getContentPane().add(btn_back);
        btn_back.setBounds(750, 500, 80, 40);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/history.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1070, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filterActionPerformed
        FilterTransaction filterchoice = new FilterTransaction(user);
        filterchoice.setVisible(true);
        filterchoice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btn_filterActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        UserHomePage userHomePage = new UserHomePage(user);
        userHomePage.setUser();
        userHomePage.setUserTypes();
        userHomePage.setVisible(true);
        userHomePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_expenditureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_expenditureActionPerformed
        ExpenditureCategorized expenditure = new ExpenditureCategorized(user);
        expenditure.setVisible(true);
        expenditure.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btn_expenditureActionPerformed

    // Method to display the transaction history of the user
    public void displayTransactionHistory() {

        DefaultListModel<String> listModel = new DefaultListModel<>();
        try {
            // Establish connection to the MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");
            // Prepare a SQL statement to fetch transaction data
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT TransactionID, Amount AS TotalAmountPaid, NULL as AmountConverted, Timestamp, fromAccount, toAccount, TransferTypes "
                    + "FROM transfertransaction WHERE fromAccount = ? OR toAccount = ? "
                    + "UNION "
                    + "SELECT TransactionID, TotalAmountPaid, AmountConverted, Timestamp, NULL as fromAccount, NULL as toAccount, NULL as TransferTypes "
                    + "FROM exchangetransaction WHERE UserID = ? "
                    + "ORDER BY STR_TO_DATE(Timestamp, '%M %e, %Y %H:%i:%s') DESC"
            );

            // Set the parameters for the SQL query using the user's ID
            statement.setString(1, user.getUserID());
            statement.setString(2, user.getUserID());
            statement.setString(3, user.getUserID());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Retrieve the transaction details from the result set
                String transactionID = resultSet.getString("TransactionID");
                String timestamp = resultSet.getString("Timestamp");
                double totalAmountPaid = resultSet.getDouble("TotalAmountPaid");
                String fromAccount = resultSet.getString("fromAccount");
                String toAccount = resultSet.getString("toAccount");
                String AmountConverted = resultSet.getString("AmountConverted");
                String transferTypes = resultSet.getString("TransferTypes");

                // Determine the type of transaction
                String transferType;
                if (fromAccount != null && toAccount != null) {
                    switch (transferTypes) {
                        case "Food":
                            transferType = "Food";
                            break;
                        case "Entertainment":
                            transferType = "Entertainment";
                            break;
                        case "Grocery":
                            transferType = "Grocery";
                            break;
                        default:
                            transferType = "Exchange";
                            break;
                    }
                } else {
                    transferType = "Exchange";
                }

                // Determine the color based on the transaction amount
                Color totalAmountColor;
                Color convertedAmountColor;
                if (fromAccount != null && fromAccount.equals(user.getUserID())) {
                    totalAmountPaid = -totalAmountPaid;
                    totalAmountColor = new Color(246, 120, 128); // Red for negative amount, which is cash out
                } else if (toAccount != null && toAccount.equals(user.getUserID())) {
                    totalAmountColor = new Color(103, 153, 217); // Blue for positive amount, which is cash in
                } else {
                    totalAmountPaid = -totalAmountPaid;
                    totalAmountColor = new Color(246, 120, 128);
                }

                // Format the total amount paid
                String formattedTotalAmountPaid;
                if (totalAmountPaid >= 0) {
                    formattedTotalAmountPaid = "+" + String.format("%.2f", totalAmountPaid);
                } else {
                    formattedTotalAmountPaid = String.format("%.2f", totalAmountPaid);
                }

                // Add the total amount paid to the list model
                listModel.addElement(transactionID + " ······ " + timestamp + " ······ " + transferType + " ······ " + formattedTotalAmountPaid);

                // Add the converted amount to the list model only if it's not null
                if (AmountConverted != null) {
                    double amountConvertedDouble = Double.parseDouble(AmountConverted);
                    String formattedAmountConverted;
                    if (amountConvertedDouble >= 0) {
                        formattedAmountConverted = "+" + String.format("%.2f", amountConvertedDouble);
                    } else {
                        formattedAmountConverted = String.format("%.2f", amountConvertedDouble);
                    }
                    convertedAmountColor = new Color(103, 153, 217); // Blue for converted amount
                    listModel.addElement(transactionID + " ······ " + timestamp + " ······ " + transferType + " ······ " + formattedAmountConverted);
                }
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle any exceptions
        }

        // Set the model for the transaction history list and apply a custom renderer
        displayTransactionHistoryList.setModel(listModel);
        displayTransactionHistoryList.setCellRenderer(new MyListCellRenderer());

        // Add a list selection listener to handle selection events
        displayTransactionHistoryList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Only proceed if the value is not adjusting
                if (!event.getValueIsAdjusting()) {
                    // Get the index of the selected item in the list
                    int selectedIndex = displayTransactionHistoryList.getSelectedIndex();
                    // If an item is selected, proceed to process it
                    if (selectedIndex != -1) {
                        String selectedTransactionInfo = listModel.getElementAt(selectedIndex);
                        String transactionID = selectedTransactionInfo.split(" ······ ")[0];

                        try {
                            // Establish a new connection to the MySQL database
                            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");
                            PreparedStatement statement;
                            ResultSet resultSet;

                            // Determine if the transaction is an exchange transaction or a transfer transaction
                            if (transactionID.startsWith("EX")) {
                                // Prepare a SQL statement to fetch details of the exchange transaction
                                statement = connection.prepareStatement(
                                        "SELECT TransactionID, UserID, SourceCurrency, TargetCurrency, AmountConverted, TotalAmountPaid, Timestamp "
                                        + "FROM exchangetransaction WHERE TransactionID = ?"
                                );
                                statement.setString(1, transactionID);
                                resultSet = statement.executeQuery();

                                // Split the selected transaction information to get the amount info
                                String[] transactionParts = selectedTransactionInfo.split(" ······ ");
                                String amountInfo = transactionParts[3];

                                // Remove the leading '+' or '-' sign from the amount info
                                if (amountInfo.startsWith("-") || amountInfo.startsWith("+")) {
                                    amountInfo = amountInfo.substring(1);
                                }

                                // Process the result set for exchange transaction
                                if (resultSet.next()) {
                                    // Retrieve the transaction details from the result set
                                    String transactionid = resultSet.getString("TransactionID");
                                    String userID = resultSet.getString("UserID");
                                    String sourceCurrency = resultSet.getString("SourceCurrency");
                                    String targetCurrency = resultSet.getString("TargetCurrency");
                                    String amountConverted = resultSet.getString("AmountConverted");
                                    String totalAmountPaid = resultSet.getString("TotalAmountPaid");
                                    String timestamp = resultSet.getString("Timestamp");

                                    // Query the ACCOUNT table to fetch usernames
                                    PreparedStatement fromAccountStatement = connection.prepareStatement("SELECT Username FROM ACCOUNT WHERE UserID = ?");
                                    fromAccountStatement.setString(1, userID);
                                    ResultSet fromAccountResultSet = fromAccountStatement.executeQuery();
                                    String fromUsername = fromAccountResultSet.next() ? fromAccountResultSet.getString("Username") : "Unknown";

                                    PreparedStatement toAccountStatement = connection.prepareStatement("SELECT Username FROM ACCOUNT WHERE UserID = ?");
                                    toAccountStatement.setString(1, userID);
                                    ResultSet toAccountResultSet = toAccountStatement.executeQuery();
                                    String toUsername = toAccountResultSet.next() ? toAccountResultSet.getString("Username") : "Unknown";

                                    // Update the labels based on the transaction details
                                    if (totalAmountPaid.equals(amountInfo)) {
                                        lbl_totalamountpaid.setText("-" + amountInfo);
                                        lbl_currency.setText(sourceCurrency);
                                        lbl_transfertypes.setText("Exchange Currency");
                                        lbl_from.setText(fromUsername);
                                        lbl_to.setText(toUsername);
                                        lbl_timestamp.setText(timestamp);
                                        lbl_status.setText("Successful");
                                        lbl_transactionid.setText(transactionid);

                                    } else if (amountConverted.equals(amountInfo)) {
                                        lbl_totalamountpaid.setText("+" + amountInfo);
                                        lbl_currency.setText(targetCurrency);
                                        lbl_transfertypes.setText("Exchange Currency");
                                        lbl_from.setText(fromUsername);
                                        lbl_to.setText(toUsername);
                                        lbl_timestamp.setText(timestamp);
                                        lbl_status.setText("Successful");
                                        lbl_transactionid.setText(transactionid);

                                    } else {
                                        System.out.println("Error");
                                    }

                                }

                            } else {
                                // Prepare a SQL statement to fetch details of the transfer transaction
                                statement = connection.prepareStatement("SELECT TransactionID, FromAccount, ToAccount, Amount, Currency, TransferTypes, Timestamp FROM transfertransaction WHERE TransactionID = ?");
                                statement.setString(1, transactionID);
                                resultSet = statement.executeQuery();

                                // Split the selected transaction information to get the amount info
                                String[] transactionParts = selectedTransactionInfo.split(" ······ ");
                                String amountInfo = transactionParts[3];

                                // If the result set contains data, process the transfer transaction details
                                if (resultSet.next()) {
                                    String transactionid = resultSet.getString("TransactionID");
                                    String fromAccountID = resultSet.getString("FromAccount");
                                    String toAccountID = resultSet.getString("ToAccount");
                                    String amount = resultSet.getString("Amount");
                                    String currency = resultSet.getString("Currency");
                                    String transferTypes = resultSet.getString("TransferTypes");
                                    String timestamp = resultSet.getString("Timestamp");

                                    // Query the ACCOUNT table to fetch usernames
                                    PreparedStatement fromAccountStatement = connection.prepareStatement("SELECT Username FROM ACCOUNT WHERE UserID = ?");
                                    fromAccountStatement.setString(1, fromAccountID);
                                    ResultSet fromAccountResultSet = fromAccountStatement.executeQuery();
                                    String fromUsername = fromAccountResultSet.next() ? fromAccountResultSet.getString("Username") : "Unknown";

                                    PreparedStatement toAccountStatement = connection.prepareStatement("SELECT Username FROM ACCOUNT WHERE UserID = ?");
                                    toAccountStatement.setString(1, toAccountID);
                                    ResultSet toAccountResultSet = toAccountStatement.executeQuery();
                                    String toUsername = toAccountResultSet.next() ? toAccountResultSet.getString("Username") : "Unknown";

                                    // Update the labels based on the transaction details
                                    if (amountInfo.contains("-")) {
                                        lbl_totalamountpaid.setText("-" + amount);
                                        lbl_currency.setText(currency);
                                        lbl_transfertypes.setText(transferTypes);
                                        lbl_from.setText(fromUsername);
                                        lbl_to.setText(toUsername);
                                        lbl_timestamp.setText(timestamp);
                                        lbl_status.setText("Successful");
                                        lbl_transactionid.setText(transactionid);
                                    } else {
                                        lbl_totalamountpaid.setText("+" + amount);
                                        lbl_currency.setText(currency);
                                        lbl_transfertypes.setText(transferTypes);
                                        lbl_from.setText(fromUsername);
                                        lbl_to.setText(toUsername);
                                        lbl_timestamp.setText(timestamp);
                                        lbl_status.setText("Successful");
                                        lbl_transactionid.setText(transactionid);
                                    }

                                }

                            }

                            resultSet.close();
                            statement.close();
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            // Handle any exceptions
                        }
                    }
                }
            }
        });
    }

    // Custom ListCellRenderer to change the text color based on transaction type
    public class MyListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            // Call the superclass method to get the default rendering
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Set the text color based on the transaction type
            if (value instanceof String) {
                String[] parts = ((String) value).split(" ······ ");
                if (parts.length >= 4) {
                    String totalAmountString = parts[3].replaceAll("<[^>]*>", ""); // Remove HTML tags
                    if (totalAmountString != null) {
                        double totalAmount = Double.parseDouble(totalAmountString);
                        Color textColor = totalAmount < 0 ? new Color(246, 120, 128) : new Color(103, 153, 217); // Red for negative, blue for positive
                        setForeground(textColor);
                    }
                }

            }

            return this;
        }
    }

    /**
     * Retrieve all elements from a JList and return them as a list of strings.
     *
     * @param jList The JList containing the elements.
     * @return A list containing all elements from the JList.
     */
    public List<String> getAllElementsFromJList(JList<String> jList) {
        // Get the list model
        DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
        int size = model.getSize();

        // Create a list to store the elements
        List<String> elements = new ArrayList<>();

        // Iterate through the model and add each element to the list
        for (int i = 0; i < size; i++) {
            String element = model.getElementAt(i);
            elements.add(element);
        }
        return elements;
    }

    /**
     * Store all elements of a JList into a file.
     *
     * @param jList The JList containing the elements to be stored.
     * @param filePath The path of the file where the elements will be stored.
     */
    public void storeElementsToFile(JList<String> jList, String filePath) {
        // Get the list model
        DefaultListModel<String> model = (DefaultListModel<String>) jList.getModel();
        int size = model.getSize();

        // Use try-with-resources to handle file writing
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Iterate through the model and write each element to the file
            for (int i = 0; i < size; i++) {
                String element = model.getElementAt(i);
                writer.write(element);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve all elements from a file and return them as a list of strings.
     *
     * @param filePath The path of the file containing the elements.
     * @return A list containing all elements from the file.
     */
    public List<String> getAllElementsFromFile(String filePath) {
        // Create a list to store the elements
        List<String> elements = new ArrayList<>();

        // Use try-with-resources to handle file reading
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line from the file and add it to the list
            while ((line = reader.readLine()) != null) {
                elements.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elements;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PensievePast.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PensievePast.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PensievePast.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PensievePast.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PensievePast().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_expenditure;
    private javax.swing.JButton btn_filter;
    private javax.swing.JLabel currency;
    private javax.swing.JLabel details_background;
    private javax.swing.JList<String> displayTransactionHistoryList;
    private javax.swing.JLabel from;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_currency;
    private javax.swing.JLabel lbl_from;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_timestamp;
    private javax.swing.JLabel lbl_to;
    private javax.swing.JLabel lbl_totalamountpaid;
    private javax.swing.JLabel lbl_transactionHistory;
    private javax.swing.JLabel lbl_transactionid;
    private javax.swing.JLabel lbl_transfertypes;
    private javax.swing.JPanel panel_displayDetails;
    private javax.swing.JLabel status;
    private javax.swing.JLabel timestamp;
    private javax.swing.JLabel to;
    private javax.swing.JLabel totalamountpaid;
    private javax.swing.JLabel transactionid;
    private javax.swing.JLabel transfertypes;
    // End of variables declaration//GEN-END:variables
}
