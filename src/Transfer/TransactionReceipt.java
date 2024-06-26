/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Transfer;

//This class is to show display the transfer transaction receipt to the user
import Bank.*;
import Transfer.Transaction;
import Bank.UserHomePage;
import javax.swing.JFrame;
import java.text.DecimalFormat;

public class TransactionReceipt extends javax.swing.JFrame {

    private Account user;// The user account for which the receipt is generated

    // Default constructor
    public TransactionReceipt() {
        setTitle("Transaction Receipt");
        initComponents();
    }

    // Constructor with parameters
    /**
     * Constructs a TransactionReceipt with the specified user, transaction ID, and transaction data.
     *
     * @param user the user account
     * @param transactionID the ID of the transaction
     * @param data the transaction data
     */
    public TransactionReceipt(Account user, String transactionID, Transaction data) {
        this.user=user;
        setTitle("Transaction Receipt");
        initComponents();
        setReceiptData(transactionID, data);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_transactionID = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        lbl_fromAcc = new javax.swing.JLabel();
        lbl_toAcc = new javax.swing.JLabel();
        lbl_amount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_type = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btn_done = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        setPreferredSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 1, 28)); // NOI18N
        jLabel2.setText("E-GRINGOTTS RECEIPT");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 10, 390, 50);

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel1.setText("Fizzling Whizbees !");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 500, 330, 30);

        lbl_transactionID.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lbl_transactionID.setText("transactionID");
        getContentPane().add(lbl_transactionID);
        lbl_transactionID.setBounds(330, 70, 250, 30);

        lbl_date.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lbl_date.setText("March 34, 2001");
        getContentPane().add(lbl_date);
        lbl_date.setBounds(230, 100, 290, 30);

        lbl_fromAcc.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lbl_fromAcc.setText("Harry Potter");
        getContentPane().add(lbl_fromAcc);
        lbl_fromAcc.setBounds(240, 160, 310, 30);

        lbl_toAcc.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lbl_toAcc.setText("Hermione Granger");
        getContentPane().add(lbl_toAcc);
        lbl_toAcc.setBounds(210, 190, 310, 30);

        lbl_amount.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lbl_amount.setText("50.00 Knut");
        getContentPane().add(lbl_amount);
        lbl_amount.setBounds(260, 220, 170, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel8.setText("Thank you for using E-Gringotts ! Your");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(170, 310, 420, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel9.setText("transfer has been successfully completed.");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(170, 340, 430, 30);

        jLabel10.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel10.setText("For any inquiries or further assistance, ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(170, 390, 490, 30);

        jLabel11.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel11.setText("owl us at egringotts@gmail.com.");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(170, 420, 380, 30);

        jLabel12.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel12.setText("May your galleons multiply like");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(170, 470, 440, 30);

        jLabel13.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel13.setText("Transaction ID:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(170, 70, 150, 30);

        jLabel14.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel14.setText("Date:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(170, 100, 60, 30);

        jLabel15.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel15.setText("From:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(170, 160, 70, 30);

        jLabel17.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel17.setText("To:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(170, 190, 40, 30);

        lbl_type.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lbl_type.setText("transferTypes");
        getContentPane().add(lbl_type);
        lbl_type.setBounds(300, 250, 130, 30);

        jLabel19.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel19.setText("Amount:");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(170, 220, 90, 30);

        jLabel20.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel20.setText("Transfer for:");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(170, 250, 130, 30);

        btn_done.setBackground(new java.awt.Color(252, 252, 236));
        btn_done.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_done.setText("Done");
        btn_done.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doneActionPerformed(evt);
            }
        });
        getContentPane().add(btn_done);
        btn_done.setBounds(490, 510, 73, 30);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/transactionReceipt.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 600, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event handler for the "Done" button. Closes the receipt window and opens the user's home page.
     *
     * @param evt the action event
     */
    private void btn_doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doneActionPerformed
        UserHomePage userHomePage = new UserHomePage(user);
        userHomePage.setUser();
        userHomePage.setUserTypes();
        userHomePage.setVisible(true);
        userHomePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btn_doneActionPerformed

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
            java.util.logging.Logger.getLogger(TransactionReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TransactionReceipt().setVisible(true);
            }
        });
    }

    /**
     * Sets the data on the receipt using the provided transaction ID and transaction data.
     *
     * @param transactionID the ID of the transaction
     * @param data the transaction data
     */
    private void setReceiptData(String transactionID, Transaction data) {
        DecimalFormat df = new DecimalFormat("#0.00");
        lbl_transactionID.setText(transactionID);
        lbl_fromAcc.setText(data.getFromUsername());
        lbl_toAcc.setText(data.getToUsername());
        lbl_amount.setText(df.format(data.getAmount()) + " " + data.getCurrency());  
        lbl_type.setText(data.getCategory());  
        lbl_date.setText(data.getDateOfTrans());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_fromAcc;
    private javax.swing.JLabel lbl_toAcc;
    private javax.swing.JLabel lbl_transactionID;
    private javax.swing.JLabel lbl_type;
    // End of variables declaration//GEN-END:variables
}
