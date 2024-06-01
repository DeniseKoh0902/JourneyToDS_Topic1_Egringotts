package Transfer;

import Bank.*;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * This class handles the search functionality for transferring funds.
 * Users can search for other users by name or phone number, and select a user to transfer funds to.
 */
public class Search extends javax.swing.JFrame {

    private Account user;// The logged-in user account

    /**
     * Default constructor for creating the Search frame.
     */
    public Search() {
        setTitle("Search");
        initComponents();
    }

    /**
     * Constructor for creating the Search frame with a user account.
     *
     * @param user The logged-in user account
     */
    public Search(Account user) {
        setTitle("Search");
        this.user = user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_transfer = new javax.swing.JLabel();
        lbl_enter = new javax.swing.JLabel();
        txtfield_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        displaySearchResult = new javax.swing.JList<>();
        btn_cancel = new javax.swing.JButton();
        btn_confirmPerson = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        lbl_transfer.setFont(new java.awt.Font("Calibri", 1, 45)); // NOI18N
        lbl_transfer.setForeground(new java.awt.Color(255, 255, 255));
        lbl_transfer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_transfer.setText("Transfer");
        getContentPane().add(lbl_transfer);
        lbl_transfer.setBounds(30, 30, 170, 60);

        lbl_enter.setBackground(new java.awt.Color(255, 255, 255));
        lbl_enter.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbl_enter.setForeground(new java.awt.Color(255, 255, 255));
        lbl_enter.setText("Enter name or phone number");
        getContentPane().add(lbl_enter);
        lbl_enter.setBounds(40, 120, 250, 23);

        txtfield_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtfield_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_searchActionPerformed(evt);
            }
        });
        getContentPane().add(txtfield_search);
        txtfield_search.setBounds(40, 150, 300, 30);

        btn_search.setBackground(new java.awt.Color(224, 224, 184));
        btn_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_search.setText("search");
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_search);
        btn_search.setBounds(360, 150, 100, 30);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        displaySearchResult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane3.setViewportView(displaySearchResult);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(444, 444, 444))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 190, 420, 260);

        btn_cancel.setBackground(new java.awt.Color(252, 252, 236));
        btn_cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cancel.setText("Cancel");
        btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel);
        btn_cancel.setBounds(480, 500, 80, 30);

        btn_confirmPerson.setBackground(new java.awt.Color(204, 204, 204));
        btn_confirmPerson.setText("Confirm");
        btn_confirmPerson.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_confirmPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmPersonActionPerformed(evt);
            }
        });
        getContentPane().add(btn_confirmPerson);
        btn_confirmPerson.setBounds(360, 470, 96, 32);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 600, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        UserHomePage userHomePage = new UserHomePage(user);
        userHomePage.setUser();
        userHomePage.setUserTypes();
        userHomePage.setVisible(true);
        userHomePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    /**
     * Event handler for the Confirm button. Confirms the selected user for transfer.
     *
     * @param evt The action event
     */
    private void btn_confirmPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmPersonActionPerformed
        if (displaySearchResult.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Please choose a user you wish to transfer to.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String selectedResult = displaySearchResult.getSelectedValue();

        // Split the selected item to extract the username and phone number
        String[] parts = selectedResult.split(" - ");
        String nameAndUserID = parts[0];
        String selectedPhoneNumber = parts[1];

        // Further split nameAndUserID to extract the username and userID
        String[] nameParts = nameAndUserID.split(" ");
        String selectedUsername = nameParts[0];
        String selectedUserID = nameParts[1];

         // Check if the user is trying to transfer to themselves
        if (selectedUserID.equals(user.getUserID())) {
            JOptionPane.showMessageDialog(this, "You cannot make a magical transfer to yourself", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Create a new transaction and proceed to the ChooseAmount page
        Transaction transaction=new Transaction();
        transaction.setFromAccount(user.getUserID());
        transaction.setToAccount(selectedUserID);
        
        // proceed to the ChooseAmount page
        ChooseAmount chooseAmount = new ChooseAmount(transaction,selectedUsername, selectedPhoneNumber,user);
        chooseAmount.setUser();
        chooseAmount.setVisible(true);
        chooseAmount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    
    }//GEN-LAST:event_btn_confirmPersonActionPerformed

    private void txtfield_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_searchActionPerformed

    }//GEN-LAST:event_txtfield_searchActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String searchNameOrPhone = txtfield_search.getText();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // Establish a connection to your database
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");

            // Create a PreparedStatement to perform the query
            statement = connection.prepareStatement("SELECT * FROM account WHERE Username LIKE ? OR Telephone LIKE ?");

            // Set the parameters in the query to search for the searchText in the 'name' and 'phone_number' columns
            statement.setString(1, "%" + searchNameOrPhone + "%");
            statement.setString(2, "%" + searchNameOrPhone + "%");

            // Execute the query
            resultSet = statement.executeQuery();

            // Iterate through the results and add them to the searchResults list
            while (resultSet.next()) {
                String name = resultSet.getString("Username");
                String phoneNumber = resultSet.getString("Telephone");
                String userID = resultSet.getString("UserID");
                listModel.addElement(name +" "+userID+" - " + phoneNumber);
            }
        } catch (SQLException ex) {
            // Handle any exceptions
            
        } finally {
            try {
                // Close the ResultSet, PreparedStatement, and connection
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                // Handle any exceptions
                
            }
        }

        displaySearchResult.setModel(listModel);
    }//GEN-LAST:event_btn_searchActionPerformed

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
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Search().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_confirmPerson;
    private javax.swing.JButton btn_search;
    private javax.swing.JList<String> displaySearchResult;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_enter;
    private javax.swing.JLabel lbl_transfer;
    private javax.swing.JTextField txtfield_search;
    // End of variables declaration//GEN-END:variables
}
