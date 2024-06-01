package Transfer;

import Bank.Account;
import Currency.ExchangePage;
import Currency.UserBal;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class EnterPIN represents the frame for entering a PIN to authorize transactions.
 */
public class EnterPIN extends javax.swing.JFrame {

    private Account user;
    private Transaction transaction;
    private double amount, fromBal, toBal;
    private String currency;
    private String loggedInUserID, toUserID;

    /**
     * Creates new form EnterPIN
     */
    public EnterPIN() {
        setTitle("Enter PIN");
        initComponents();
    }

    /**
     * Constructor with user account and exchange transaction details.
     * 
     * @param user The account of the logged-in user.
     * @param transaction The transaction details.
     * @param fromBal The balance from which the amount will be deducted.
     */
    public EnterPIN(Account user, Transaction transaction, double fromBal) {
        setTitle("Enter PIN");
        this.user = user;
        this.transaction = transaction;
        this.loggedInUserID = user.getUserID();
        this.toUserID = transaction.getToAccount();
        this.fromBal = fromBal;
        this.toBal = getUserBalances(toUserID).getBalance(transaction.getCurrency());
        initComponents();
    }

    PreparedStatement st1;
    PreparedStatement st2;
    PreparedStatement st3;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_backspace = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_nothing = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_confirmPIN = new javax.swing.JButton();
        txtfield_PIN = new javax.swing.JTextField();
        lbl_transfer = new javax.swing.JLabel();
        lbl_instruction = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        bakcground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        btn_backspace.setBackground(new java.awt.Color(224, 224, 184));
        btn_backspace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backspaceButton.png"))); // NOI18N
        btn_backspace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_backspace.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backspaceButton.png"))); // NOI18N
        btn_backspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backspaceActionPerformed(evt);
            }
        });
        getContentPane().add(btn_backspace);
        btn_backspace.setBounds(320, 370, 73, 70);

        btn_0.setBackground(new java.awt.Color(224, 224, 184));
        btn_0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_0.setText("0");
        btn_0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_0);
        btn_0.setBounds(250, 370, 73, 70);

        btn_6.setBackground(new java.awt.Color(224, 224, 184));
        btn_6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_6.setText("6");
        btn_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_6);
        btn_6.setBounds(320, 230, 73, 70);

        btn_nothing.setBackground(new java.awt.Color(224, 224, 184));
        getContentPane().add(btn_nothing);
        btn_nothing.setBounds(180, 370, 73, 70);

        btn_7.setBackground(new java.awt.Color(224, 224, 184));
        btn_7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_7.setText("7");
        btn_7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_7);
        btn_7.setBounds(180, 300, 73, 70);

        btn8.setBackground(new java.awt.Color(224, 224, 184));
        btn8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn8.setText("8");
        btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        getContentPane().add(btn8);
        btn8.setBounds(250, 300, 73, 70);

        btn_9.setBackground(new java.awt.Color(224, 224, 184));
        btn_9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_9.setText("9");
        btn_9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_9);
        btn_9.setBounds(320, 300, 73, 70);

        btn_4.setBackground(new java.awt.Color(224, 224, 184));
        btn_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_4.setText("4");
        btn_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_4);
        btn_4.setBounds(180, 230, 73, 70);

        btn_3.setBackground(new java.awt.Color(224, 224, 184));
        btn_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_3.setText("3");
        btn_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_3);
        btn_3.setBounds(320, 160, 73, 70);

        btn_5.setBackground(new java.awt.Color(224, 224, 184));
        btn_5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_5.setText("5");
        btn_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_5);
        btn_5.setBounds(250, 230, 73, 70);

        btn_1.setBackground(new java.awt.Color(224, 224, 184));
        btn_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_1.setText("1");
        btn_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_1);
        btn_1.setBounds(180, 160, 73, 70);

        btn_2.setBackground(new java.awt.Color(224, 224, 184));
        btn_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_2.setText("2");
        btn_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_2);
        btn_2.setBounds(250, 160, 73, 70);

        btn_confirmPIN.setBackground(new java.awt.Color(249, 249, 221));
        btn_confirmPIN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_confirmPIN.setText("Confirm");
        btn_confirmPIN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confirmPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmPINActionPerformed(evt);
            }
        });
        getContentPane().add(btn_confirmPIN);
        btn_confirmPIN.setBounds(190, 480, 190, 40);

        txtfield_PIN.setEditable(false);
        txtfield_PIN.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        txtfield_PIN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfield_PIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_PINActionPerformed(evt);
            }
        });
        getContentPane().add(txtfield_PIN);
        txtfield_PIN.setBounds(180, 110, 210, 30);

        lbl_transfer.setFont(new java.awt.Font("Calibri", 1, 45)); // NOI18N
        lbl_transfer.setForeground(new java.awt.Color(255, 255, 255));
        lbl_transfer.setText("Enter PIN");
        getContentPane().add(lbl_transfer);
        lbl_transfer.setBounds(40, 30, 210, 60);

        lbl_instruction.setForeground(new java.awt.Color(255, 255, 255));
        lbl_instruction.setText("Enter PIN linked to your Egringotts account");
        getContentPane().add(lbl_instruction);
        lbl_instruction.setBounds(180, 140, 350, 15);

        btn_cancel.setBackground(new java.awt.Color(252, 252, 236));
        btn_cancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_cancel.setText("Cancel");
        btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel);
        btn_cancel.setBounds(470, 490, 90, 30);

        bakcground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pin.jpg"))); // NOI18N
        getContentPane().add(bakcground);
        bakcground.setBounds(0, 0, 600, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_confirmPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmPINActionPerformed

        // Retrieve PIN entered by the user
        String pin = txtfield_PIN.getText();

        Connection con = null;
        Statement statement = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");
            statement = con.createStatement();
            // Disable auto-commit to manage transactions manually
            con.setAutoCommit(false);

            // Check if the entered PIN is correct
            PreparedStatement pst = con.prepareStatement("SELECT PIN FROM Account WHERE UserID = ?");
            pst.setString(1, loggedInUserID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // Retrieve the correct PIN from the result set
                String correctPin = rs.getString("PIN");
                if (!pin.equals(correctPin)) {
                    // Show error message if the PIN is incorrect
                    JOptionPane.showMessageDialog(new JFrame(), "Wrong PIN!", "Error", JOptionPane.ERROR_MESSAGE);
                    txtfield_PIN.setText("");
                    return; // Exit the method if PIN is incorrect
                }
            }

            // Proceed with the transaction if PIN is correct
            this.toUserID = transaction.getToAccount();
            this.amount = transaction.getAmount();
            this.currency = transaction.getCurrency();

            // Update user balances in the database
            updateUserBalance(con, loggedInUserID, toUserID, amount, currency);
             // Set the transaction timestamp
            String transactionID = generateTransactionID();
            String TimeStamp = setTransactionDate();
            transaction.setDateOfTrans(TimeStamp);
            
            // save data into database 
            // (save into table transfertransaction)
             // Prepare and execute an insert statement to save the transaction in the transfertransaction table
            st3 = con.prepareStatement("INSERT INTO transfertransaction(TransactionID, fromAccount, toAccount, Amount, Currency, TransferTypes, Timestamp) VALUES (?, ?, ?, ?, ?, ?, ?)");
            st3.setString(1, transactionID);
            st3.setString(2, transaction.getFromAccount());
            st3.setString(3, transaction.getToAccount());
            st3.setDouble(4, amount);
            st3.setString(5, currency);
            st3.setString(6, transaction.getCategory());
            st3.setString(7, TimeStamp);
            st3.executeUpdate();
            st3.close();
            con.commit();
            System.out.println("Balance updated successful.");
            JOptionPane.showMessageDialog(null, "Magical transaction completed!");

            // Generate and display the transaction receipt
            TransactionReceipt receipt = new TransactionReceipt(user, transactionID, transaction);
            receipt.setVisible(true);
            receipt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispose();

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Error!" + e.getMessage());
            try {
                if (con != null) {
                    con.rollback(); // Rollback the transaction in case of an error
                }
            } catch (SQLException ex) {
                System.out.println("Error rolling back transaction: " + ex.getMessage());
            }
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_confirmPINActionPerformed

    
    //method to generate a new transaction ID
    private static String generateTransactionID() {
        String url = "jdbc:mysql://127.0.0.1:3306/Egringotts";
        String user = "root";
        String password = "password";
        String lastTransactionID = null;
        String prefix = "TRX";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // fetch the last transaction ID from both tables
            String query1 = "SELECT TransactionID FROM exchangeTransaction ORDER BY TransactionID DESC LIMIT 1";
            String query2 = "SELECT TransactionID FROM transfertransaction ORDER BY TransactionID DESC LIMIT 1";

            try (PreparedStatement statement1 = connection.prepareStatement(query1);
                 PreparedStatement statement2 = connection.prepareStatement(query2);
                 ResultSet resultSet1 = statement1.executeQuery();
                 ResultSet resultSet2 = statement2.executeQuery()) {

                String lastID1 = null;
                String lastID2 = null;

                if (resultSet1.next()) {
                    lastID1 = resultSet1.getString("TransactionID");
                }
                if (resultSet2.next()) {
                    lastID2 = resultSet2.getString("TransactionID");
                }

                if (lastID1 != null && lastID2 != null) {
                    // Determine the most recent transaction ID between the two tables
                    lastTransactionID = lastID1.compareTo(lastID2) > 0 ? lastID1 : lastID2;
                } else if (lastID1 != null) {
                    lastTransactionID = lastID1;
                } else if (lastID2 != null) {
                    lastTransactionID = lastID2;
                }
            }

            // generate the next ID from the previous one
            if (lastTransactionID != null) {
                int numericPart = Integer.parseInt(lastTransactionID.substring(3)) + 1;
                return prefix + String.format("%012d", numericPart);
            } else {
                // start from 1 if no last id is found
                return prefix + "000000000001";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to get user balances
    private UserBal getUserBalances(String userID) {
        ExchangePage currency = new ExchangePage(user);
        return currency.getUserBalances(userID);
    }

    // Method to update the user balance in database
    protected void updateUserBalance(Connection con, String fromID, String toID, double amount, String currency) throws SQLException {
        double updatedFromBal = 0.0;
        double updatedToBal = 0.0;
        String query = "UPDATE UserBalance SET " + currency + " = ? WHERE UserID = ?";

        try {
            //sender
            //Update the sender's balance
            double currentFromBal = fromBal;
            updatedFromBal = currentFromBal - amount;
            st1 = con.prepareStatement(query);
            st1.setDouble(1, updatedFromBal);
            st1.setString(2, fromID);
            st1.executeUpdate();
            
            //receiver
            //Update the receiver's balance
            double currentToBal = toBal;
            updatedToBal = currentToBal + amount;
            st2 = con.prepareStatement(query);
            st2.setDouble(1, updatedToBal);
            st2.setString(2, toID);
            st2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            // Close resources
            if (st1 != null) {
                st1.close();
            }
            if (st2 != null) {
                st2.close();
            }
        }
    }

    // Method to set the current date and time as the transaction timestamp
    public static String setTransactionDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private void txtfield_PINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_PINActionPerformed

    }//GEN-LAST:event_txtfield_PINActionPerformed

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        appendDigit("1");
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        appendDigit("2");
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        appendDigit("3");
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        appendDigit("4");
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        appendDigit("5");
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        appendDigit("6");
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        appendDigit("7");
    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        appendDigit("8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        appendDigit("9");
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_0ActionPerformed
        appendDigit("0");
    }//GEN-LAST:event_btn_0ActionPerformed

    private void btn_backspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backspaceActionPerformed
        String currentText = txtfield_PIN.getText();
        if (currentText.length() > 0) {
            // Remove the last character
            txtfield_PIN.setText(currentText.substring(0, currentText.length() - 1));
        }
    }//GEN-LAST:event_btn_backspaceActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        Search search=new Search(user);
        search.setVisible(true);
        search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    // Method triggered when a digit button is clicked
    private void appendDigit(String digit) {
        String currentText = txtfield_PIN.getText();
        if (currentText.length() < 6) {
            txtfield_PIN.setText(currentText + digit);
        } else {
            // Show an alert
            JOptionPane.showMessageDialog(this, "PIN must be ONLY 6 digits long", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(EnterPIN.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterPIN.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterPIN.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterPIN.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterPIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bakcground;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_backspace;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_confirmPIN;
    private javax.swing.JButton btn_nothing;
    private javax.swing.JLabel lbl_instruction;
    private javax.swing.JLabel lbl_transfer;
    private javax.swing.JTextField txtfield_PIN;
    // End of variables declaration//GEN-END:variables
}