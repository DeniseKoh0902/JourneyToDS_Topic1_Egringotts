package Transfer;

import Bank.Account;
import Currency.ExchangePage;
import Currency.UserBal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * ChooseAmount class allows the user to select an amount to transfer, choose a
 * currency, and specify the type of transfer. It verifies the balance and
 * proceeds to the PIN confirmation stage.
 */
public class ChooseAmount extends javax.swing.JFrame {

    private Account loggedInUser; // User's account details
    private Transaction transaction;// Transaction details
    private UserBal userBal;// User's balance details
    private String selectedUsername, selectedPhoneNumber; // Receiver's details
    private double fromBal, toBal;// Balances for sender and receiver

    /**
     * Default constructor for ChooseAmount. Sets the title and initializes
     * components.
     */
    public ChooseAmount() {
        setTitle("Choose Amount");
        initComponents();
        fillCombo();
    }

    /**
     * Overloaded constructor for ChooseAmount.
     *
     * @param transaction The transaction details.
     * @param selectedUsername The username of the recipient.
     * @param selectedPhoneNumber The phone number of the recipient.
     * @param user The logged-in user's account details.
     */
    public ChooseAmount(Transaction transaction, String selectedUsername, String selectedPhoneNumber, Account user) {
        setTitle("Choose Amount");
        this.loggedInUser = user;
        this.transaction = transaction;
        this.userBal = getUserBalances(transaction.getFromAccount());
        this.selectedUsername = selectedUsername;
        this.selectedPhoneNumber = selectedPhoneNumber;
        initComponents();
        String imagePath = transaction.setProfilePic(profilePic, transaction.getToAccount());
        profilePic.setIcon(new ImageIcon(imagePath)); // Set the icon for the JLabel

        fillCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JPanel();
        profilePic = new javax.swing.JLabel();
        jlabel1 = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        lbl_verify = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        btn_confirmTransfer = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        amount = new javax.swing.JPanel();
        lbl_enterAmount = new javax.swing.JLabel();
        txtfield_chooseAmount = new javax.swing.JTextField();
        chooseCurrency = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chooseTransfertype = new javax.swing.JComboBox<>();
        currentBalance = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        user.setBackground(new java.awt.Color(0, 0, 0, 90));

        profilePic.setBackground(new java.awt.Color(102, 255, 255));
        profilePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profilePic.jpg"))); // NOI18N

        jlabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jlabel1.setForeground(new java.awt.Color(255, 255, 255));
        jlabel1.setText("Transfer to: ");

        phoneNumberLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        phoneNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        phoneNumberLabel.setText("Phone Number");

        lbl_verify.setForeground(new java.awt.Color(255, 255, 255));
        lbl_verify.setText("@ Always verify recipient's name before transferring");

        usernameLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username");

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(user);
        user.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePic)
                .addGap(28, 28, 28)
                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_verify, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userLayout.createSequentialGroup()
                        .addComponent(jlabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phoneNumberLabel)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(profilePic)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_verify)
                .addGap(18, 18, 18))
        );

        getContentPane().add(user);
        user.setBounds(30, 30, 540, 160);

        btn_confirmTransfer.setBackground(new java.awt.Color(249, 249, 221));
        btn_confirmTransfer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_confirmTransfer.setText("Confirm Transfer");
        btn_confirmTransfer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confirmTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmTransferActionPerformed(evt);
            }
        });
        getContentPane().add(btn_confirmTransfer);
        btn_confirmTransfer.setBounds(230, 470, 200, 40);

        cancel.setBackground(new java.awt.Color(240, 239, 227));
        cancel.setText("Cancel");
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel);
        cancel.setBounds(30, 500, 80, 30);

        amount.setBackground(new java.awt.Color(0, 0, 0, 90));

        lbl_enterAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_enterAmount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_enterAmount.setText("Enter amount");

        txtfield_chooseAmount.setBackground(new java.awt.Color(242, 242, 242));
        txtfield_chooseAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfield_chooseAmount.setForeground(new java.awt.Color(100, 90, 55));
        txtfield_chooseAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_chooseAmountActionPerformed(evt);
            }
        });

        chooseCurrency.setBackground(new java.awt.Color(242, 242, 242));
        chooseCurrency.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chooseCurrency.setForeground(new java.awt.Color(83, 75, 51));
        chooseCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCurrencyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("You can transfer up to");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("What's the transfer for?");

        chooseTransfertype.setBackground(new java.awt.Color(242, 242, 242));
        chooseTransfertype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chooseTransfertype.setForeground(new java.awt.Color(83, 75, 51));
        chooseTransfertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food", "Entertainment", "Grocery" }));
        chooseTransfertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseTransfertypeActionPerformed(evt);
            }
        });

        currentBalance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        currentBalance.setForeground(new java.awt.Color(255, 255, 255));
        currentBalance.setText("400");

        javax.swing.GroupLayout amountLayout = new javax.swing.GroupLayout(amount);
        amount.setLayout(amountLayout);
        amountLayout.setHorizontalGroup(
            amountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(amountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(amountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseTransfertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(amountLayout.createSequentialGroup()
                        .addGroup(amountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfield_chooseAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_enterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooseCurrency, 0, 232, Short.MAX_VALUE))
                    .addGroup(amountLayout.createSequentialGroup()
                        .addGroup(amountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(amountLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        amountLayout.setVerticalGroup(
            amountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(amountLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_enterAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(amountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfield_chooseAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(amountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currentBalance))
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseTransfertype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(amount);
        amount.setBounds(120, 210, 450, 250);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chooseAmount.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 600, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtfield_chooseAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_chooseAmountActionPerformed

    }//GEN-LAST:event_txtfield_chooseAmountActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        Search search = new Search(loggedInUser);
        search.setVisible(true);
        search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void btn_confirmTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmTransferActionPerformed
        // Get the amount entered by the user
        String amountText = txtfield_chooseAmount.getText();
        String currency = chooseCurrency.getSelectedItem().toString();
        String type = chooseTransfertype.getSelectedItem().toString();

        if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the amount you want to transfer.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method
        }

        //parse amount into double
        double amount = Double.parseDouble(amountText);

        // Get the current balance
        double currentBal = Double.parseDouble(currentBalance.getText());

        // Check if the amount exceeds the current balance
        if (amount > currentBal) {
            JOptionPane.showMessageDialog(this, "Error: Insufficient balance!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //create Transaction instance to save the details
            Transaction details = new Transaction(transaction.getFromAccount(), transaction.getToAccount(), amount, currency, type);

            // Create an instance of EnterPIN and pass in the data
            EnterPIN enterPIN = new EnterPIN(loggedInUser, details, currentBal);
            enterPIN.setVisible(true);
            enterPIN.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.dispose();
        }

    }//GEN-LAST:event_btn_confirmTransferActionPerformed

    private void chooseCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCurrencyActionPerformed
        //show the user their current balance of selected amount
        String selectedCurrency = chooseCurrency.getSelectedItem().toString();
        fromBal = userBal.getBalance(selectedCurrency);
        String currentBal = String.format("%.2f", fromBal);
        currentBalance.setText(currentBal);
    }//GEN-LAST:event_chooseCurrencyActionPerformed

    private void chooseTransfertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseTransfertypeActionPerformed

    }//GEN-LAST:event_chooseTransfertypeActionPerformed

    // Sets the user details on the interface
    public void setUser() {
        usernameLabel.setText(selectedUsername); // Sets the username label to the selected username
        phoneNumberLabel.setText(selectedPhoneNumber);// Sets the phone number label to the selected phone number
    }

    // Retrieves the user's balances for different currencies
    private UserBal getUserBalances(String userID) {
        ExchangePage currency = new ExchangePage(loggedInUser);// Creates a new ExchangePage instance with the logged-in user
        return currency.getUserBalances(userID);// Returns the balances for the specified user ID
    }

    // Fills the currency combo box with available currencies
    private void fillCombo() {
        ExchangePage currency = new ExchangePage(loggedInUser);// Creates a new ExchangePage instance with the logged-in user
        currency.fillCombo(chooseCurrency);// Fills the combo box (chooseCurrency) with available currencies
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
            java.util.logging.Logger.getLogger(ChooseAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseAmount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChooseAmount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel amount;
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_confirmTransfer;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> chooseCurrency;
    private javax.swing.JComboBox<String> chooseTransfertype;
    private javax.swing.JLabel currentBalance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel lbl_enterAmount;
    private javax.swing.JLabel lbl_verify;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel profilePic;
    private javax.swing.JTextField txtfield_chooseAmount;
    private javax.swing.JPanel user;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
