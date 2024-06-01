/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bank;

import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.JFrame;

public class ForgotPassword extends javax.swing.JFrame {

    private int otp;

    /**
     * Creates new form ForgotPassword
     */
    public ForgotPassword() {
        setTitle("Forgot Password");
        initComponents();
        Wand.setCustomIcon(this);
        Wand.setCustomCursor(this);
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
        HogwattsPic = new javax.swing.JLabel();
        ForgotPwTitle = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        OTP = new javax.swing.JLabel();
        OTPmessage = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        OTPfield = new javax.swing.JTextField();
        ConfirmButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        Time = new javax.swing.JLabel();
        Help = new javax.swing.JLabel();
        Phone = new javax.swing.JLabel();
        Send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 600));
        setPreferredSize(new java.awt.Dimension(1070, 600));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(52, 55, 59));
        jPanel1.setForeground(new java.awt.Color(110, 85, 89));
        jPanel1.setMaximumSize(new java.awt.Dimension(1070, 600));
        jPanel1.setLayout(null);

        HogwattsPic.setBackground(new java.awt.Color(52, 55, 59));
        HogwattsPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hogwatts.jpg"))); // NOI18N
        HogwattsPic.setText("jLabel1");
        jPanel1.add(HogwattsPic);
        HogwattsPic.setBounds(0, 0, 484, 600);

        ForgotPwTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        ForgotPwTitle.setForeground(new java.awt.Color(255, 255, 255));
        ForgotPwTitle.setText("Forgot Password?");
        jPanel1.add(ForgotPwTitle);
        ForgotPwTitle.setBounds(611, 50, 334, 95);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo50x50.png"))); // NOI18N
        Logo.setText("jLabel2");
        jPanel1.add(Logo);
        Logo.setBounds(658, 462, 64, 50);

        Email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setText("Email:");
        jPanel1.add(Email);
        Email.setBounds(564, 167, 113, 48);

        OTP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OTP.setForeground(new java.awt.Color(255, 255, 255));
        OTP.setText("Enter OTP:");
        jPanel1.add(OTP);
        OTP.setBounds(560, 290, 113, 31);

        OTPmessage.setForeground(new java.awt.Color(255, 255, 255));
        OTPmessage.setText("Please enter the OTP we sent to your email.");
        jPanel1.add(OTPmessage);
        OTPmessage.setBounds(690, 260, 265, 16);

        EmailField.setBackground(new java.awt.Color(110, 85, 89));
        EmailField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EmailField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(EmailField);
        EmailField.setBounds(695, 172, 265, 39);

        OTPfield.setBackground(new java.awt.Color(110, 85, 89));
        OTPfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OTPfield.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(OTPfield);
        OTPfield.setBounds(690, 290, 270, 40);

        ConfirmButton.setBackground(new java.awt.Color(255, 204, 102));
        ConfirmButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ConfirmButton.setForeground(new java.awt.Color(0, 0, 0));
        ConfirmButton.setText("Confirm");
        ConfirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ConfirmButton);
        ConfirmButton.setBounds(657, 363, 100, 31);

        BackButton.setBackground(new java.awt.Color(255, 204, 102));
        BackButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BackButton.setForeground(new java.awt.Color(0, 0, 0));
        BackButton.setText("Back");
        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        jPanel1.add(BackButton);
        BackButton.setBounds(816, 363, 81, 31);

        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setText("24/7 Phone Assistance");
        jPanel1.add(Time);
        Time.setBounds(740, 474, 118, 16);

        Help.setForeground(new java.awt.Color(255, 255, 255));
        Help.setText("Need Help?");
        jPanel1.add(Help);
        Help.setBounds(740, 452, 81, 16);

        Phone.setForeground(new java.awt.Color(255, 255, 255));
        Phone.setText("018-7777358");
        jPanel1.add(Phone);
        Phone.setBounds(740, 496, 118, 16);

        Send.setBackground(new java.awt.Color(255, 204, 102));
        Send.setForeground(new java.awt.Color(0, 0, 0));
        Send.setText("Send");
        Send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Send);
        Send.setBounds(888, 219, 72, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1070, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    /**
     * Action performed when the Back button is clicked.
     * Opens the LoginPage, sets its default close operation, and disposes the current window.
     *
     * @param evt The action event triggered by the button click.
     */
    public void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        LoginPage login = new LoginPage();//display login page
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }

    /**
     * Action performed when the Confirm button is clicked.
     * Validates the OTP and email fields, verifies the OTP, and opens the ChangePassword window if successful.
     *
     * @param evt The action event triggered by the button click.
     */
    public void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String otpfield = OTPfield.getText();
        if (otpfield.trim().isEmpty() && EmailField.getText().trim().isEmpty()) {
            // Display error message if OTP and email fields are empty
            JOptionPane.showMessageDialog(new JFrame(), "Please fill in the field before confirming!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // Parse the entered OTP
                int enteredOTP = Integer.parseInt(otpfield);
                // Check if entered OTP matches the generated OTP
                if (enteredOTP != otp) {
                    JOptionPane.showMessageDialog(new JFrame(), "Wrong OTP!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Display success message and open ChangePassword window if OTP is correct
                    JOptionPane.showMessageDialog(new JFrame(), "OTP verified successfully. You may now proceed to change your password.");

                    ChangePassword changePassword = new ChangePassword(true);
                    changePassword.getUsernamebyEmail(EmailField.getText());
                    changePassword.setVisible(true);
                    changePassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.dispose();
                }
            } catch (NumberFormatException e) {
                // Handle invalid OTP format
                JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid OTP!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Action performed when the Send button is clicked.
     * Generates a random OTP, validates the email, and sends the OTP to the specified email address.
     *
     * @param evt The action event triggered by the button click.
     */
    public void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Random r = new Random();
        otp = r.nextInt(999999 - 100000 + 1) + 100000;// Generate a random OTP

        String emailAddress = EmailField.getText().trim();
        System.out.println(otp);// Print the OTP to the console for debugging
        if (emailAddress.isEmpty()) {
            // Display error message if email field is empty
            JOptionPane.showMessageDialog(new JFrame(), "Please fill your email!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!emailAddress.contains("@")) {
            // Display error message if email address is invalid
            JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid email!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
             // Send the OTP to the specified email address
            EmailVerification.sendEmail(
                    EmailField.getText(),
                    "Your Wizarding OTP for Password Change",
                    "Greetings, Esteemed Wizard!\n\n"
                    + "Your OTP to change your password is: " + otp + "\n\n"
                    + "Important: Guard this OTP with the vigilance of a dragon, and do not reveal it to anyone.\n\n"
                    + "With magical regards,\n"
                    + "The Egringotts Team"
            );
            JOptionPane.showMessageDialog(new JFrame(), "Email sent successfully! Please check your mailbox.");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JLabel Email;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel ForgotPwTitle;
    private javax.swing.JLabel Help;
    private javax.swing.JLabel HogwattsPic;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel OTP;
    private javax.swing.JTextField OTPfield;
    private javax.swing.JLabel OTPmessage;
    private javax.swing.JLabel Phone;
    private javax.swing.JButton Send;
    private javax.swing.JLabel Time;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
