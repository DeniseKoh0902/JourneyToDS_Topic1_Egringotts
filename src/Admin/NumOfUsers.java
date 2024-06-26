/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import Admin.AdminProfile;
import Bank.Account;
import Bank.Wand;
import Currency.ShowAccountBalance;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A class that displays the number of users and allows searching and viewing user details.
 */
public class NumOfUsers extends javax.swing.JFrame {
    private Account user; // Account object representing the current user
    
    /**
     * Creates new form NumOfUsers
     */
    public NumOfUsers() {
        setTitle("Number Of Users");
        initComponents();
        Wand.setCustomIcon(this);// Set custom icon for the window
        Wand.setCustomCursor(this);// Set custom cursor for the window 
        countNoOfUsers();// Count and display the number of users
        // Add a document listener to the search field to handle real-time search
        Search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }
        });

        setVisible(true);
    }
    
    /**
     * Creates new form NumOfUsers for a specific user.
     * 
     * @param user The account object of the current user
     */
    public NumOfUsers(Account user) {
        setTitle("Number Of Users");
        this.user=user;
        initComponents();
        countNoOfUsers();// Count and display the number of users
        // Add a document listener to the search field to handle real-time search
        Search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }
        });

        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NumOfUsers = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SearchLabel = new javax.swing.JLabel();
        DisplayData = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Search = new javax.swing.JTextField();
        NumOfUsersLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultTable = new rojeru_san.complementos.RSTableMetro();
        MagicTrainPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 600));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        NumOfUsers.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        NumOfUsers.setText("0");
        jPanel1.add(NumOfUsers);
        NumOfUsers.setBounds(500, 40, 60, 60);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel2.setLayout(null);

        SearchLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SearchLabel.setForeground(new java.awt.Color(255, 255, 255));
        SearchLabel.setText("Search user here:");
        jPanel2.add(SearchLabel);
        SearchLabel.setBounds(30, 20, 170, 30);

        DisplayData.setBackground(new java.awt.Color(204, 255, 255));
        DisplayData.setText("Display All Data");
        DisplayData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DisplayData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayDataActionPerformed(evt);
            }
        });
        jPanel2.add(DisplayData);
        DisplayData.setBounds(30, 230, 150, 40);

        Back.setBackground(new java.awt.Color(204, 255, 255));
        Back.setText("Back");
        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(Back);
        Back.setBounds(290, 230, 110, 40);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(Search);
        Search.setBounds(30, 60, 350, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(60, 120, 420, 290);

        NumOfUsersLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        NumOfUsersLabel.setText("Number Of Users:");
        jPanel1.add(NumOfUsersLabel);
        NumOfUsersLabel.setBounds(70, 40, 430, 60);

        resultTable.setBackground(new java.awt.Color(0, 102, 102));
        resultTable.setForeground(new java.awt.Color(255, 255, 255));
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Username", "Email", "Telephone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultTable.setAltoHead(30);
        resultTable.setColorBackgoundHead(new java.awt.Color(0, 51, 51));
        resultTable.setColorBordeFilas(new java.awt.Color(204, 255, 255));
        resultTable.setColorBordeHead(new java.awt.Color(204, 255, 255));
        resultTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        resultTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        resultTable.setColorSelBackgound(new java.awt.Color(0, 102, 102));
        resultTable.setColorSelForeground(new java.awt.Color(153, 255, 255));
        resultTable.setFont(new java.awt.Font("Yu Mincho", 0, 12)); // NOI18N
        resultTable.setFuenteFilas(new java.awt.Font("Yu Mincho Demibold", 1, 12)); // NOI18N
        resultTable.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
        resultTable.setFuenteHead(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        resultTable.setGridColor(new java.awt.Color(255, 255, 255));
        resultTable.setRowHeight(30);
        resultTable.setSelectionBackground(new java.awt.Color(204, 255, 255));
        resultTable.setSelectionForeground(new java.awt.Color(0, 102, 102));
        jScrollPane2.setViewportView(resultTable);
        resultTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleDoubleClick(e);
            }
        });

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(520, 120, 510, 280);

        MagicTrainPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MagicTrain.jpg"))); // NOI18N
        MagicTrainPic.setText("jLabel1");
        jPanel1.add(MagicTrainPic);
        MagicTrainPic.setBounds(0, 0, 1070, 600);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1070, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Displays the user data by executing a SQL query and updating the table model.
     * 
     * @param evt The action event
     */
    private void DisplayDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayDataActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");// Load the MySQL JDBC driver
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");
            
            Statement st=connection.createStatement();
            //mysql query and exclude admin
            String sql="SELECT * FROM Account WHERE UserID != '915d4c3cb8'";
            ResultSet rs=st.executeQuery(sql);
            
            DefaultTableModel tblModel = (DefaultTableModel) resultTable.getModel();
            // Clear the table model before adding new data
            tblModel.setRowCount(0);
            while(rs.next()){
                String userid=rs.getString("UserID");
                String username=rs.getString("Username");
                String email=rs.getString("Email");
                String telephone=rs.getString("Telephone");
                
                String []tbData={userid,username,email,telephone};// Create an array with the user data
                
                tblModel.addRow(tbData);// Add the row to the table model
            }
            connection.close();// Close the connection
        }catch(Exception e){
            System.out.println(e.getMessage());// Print any exception messages
        }
    }//GEN-LAST:event_DisplayDataActionPerformed

    /**
     * Event handler for the "Back" button. Navigates to the admin profile.
     * 
     * @param evt The action event
     */
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {    
        //parse the data to Admin Profile class as only admin can access this class
        AdminProfile adminProfile=new AdminProfile(user);
        adminProfile.setUser();  // Set the user for the admin profile
        adminProfile.setUserType("Goblin");
        adminProfile.setVisible(true);
        adminProfile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }
    
     /**
     * Handles double-click events on the result table to open the account balance of the selected user.
     * 
     * @param e The mouse event
     */
    private void handleDoubleClick(MouseEvent e) {
        if (e.getClickCount() == 1) { // Check if we click it
            int row = resultTable.getSelectedRow(); // Get the selected row
            if (row != -1) { // Check if a row is selected
                String selectedUserID = resultTable.getValueAt(row, 0).toString(); // Get the UserID of the selected row
                Account selecteduser = new Account();// Create a new Account object
                selecteduser.setUserID(selectedUserID); // Fetch user data based on the selected UserID
                if (selecteduser != null) {
                        openShowAccountBalance(selecteduser);
                } else {
                    JOptionPane.showMessageDialog(NumOfUsers.this, "User data not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    /**
     * Opens the ShowAccountBalance window for the specified user.
     * 
     * @param selectedUser The account object of the selected user
     */
    private void openShowAccountBalance(Account selecteduser){
        ShowAccountBalance showAccountBalance = new ShowAccountBalance(selecteduser);// Create a new ShowAccountBalance object
        showAccountBalance.setUserId();// Set the UserID for the show account balance
        showAccountBalance.setVisible(true);
        showAccountBalance.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    /**
     * Counts the number of users and displays the count.
     */
    private void countNoOfUsers(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");

            Statement st = connection.createStatement();
            //exclude admin(globin)
            String sql = "SELECT COUNT(*) AS rowCount FROM Account WHERE UserID != '915d4c3cb8'"; // Query to count rows
            ResultSet rs = st.executeQuery(sql);

            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt("rowCount");// Get the row count from the result set
            }
            String noOfUsers=String.valueOf(rowCount);// Convert the count to a string
            this.NumOfUsers.setText(noOfUsers);// Set the text of the NumOfUsers label to the count

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Searches for users based on the search term and updates the result table.
     */
    private void search() {
        String searchTerm = Search.getText().trim();// Get the search term from the search field
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("UserID");
        model.addColumn("Username");
        model.addColumn("Email");
        model.addColumn("Telephone");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");

            // Build the SQL query dynamically based on the search term
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM Account WHERE ");
            queryBuilder.append("(UserID LIKE ? OR ");
            queryBuilder.append("Username LIKE ? OR ");
            queryBuilder.append("Email LIKE ? OR ");
            queryBuilder.append("Telephone LIKE ?) AND ");
            queryBuilder.append("UserID != ?");

            PreparedStatement statement = connection.prepareStatement(queryBuilder.toString());
            // Set the search term for each column using wildcards
            for (int i = 1; i <= 4; i++) {
                statement.setString(i, "%" + searchTerm + "%");
            }
            // Set the exclusion UserID(globin userid)
            statement.setString(5, "915d4c3cb8");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] row = new Object[4]; // Adjust the size according to the number of columns
                row[0] = resultSet.getString("UserID");
                row[1] = resultSet.getString("Username");
                row[2] = resultSet.getString("Email");
                row[3] = resultSet.getString("Telephone");
                model.addRow(row);// Add the row to the table model
            }

            resultTable.setModel(model);
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(NumOfUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumOfUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumOfUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumOfUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumOfUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton DisplayData;
    private javax.swing.JLabel MagicTrainPic;
    private javax.swing.JLabel NumOfUsers;
    private javax.swing.JLabel NumOfUsersLabel;
    private javax.swing.JTextField Search;
    private javax.swing.JLabel SearchLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro resultTable;
    // End of variables declaration//GEN-END:variables
}
