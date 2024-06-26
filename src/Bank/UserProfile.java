/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bank;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserProfile extends javax.swing.JFrame {
    private Account user;// User account object
    private String imagePathString;// Path to user's profile image
    
    /**
     * Creates new form UserProfile
     */
    public UserProfile() {
        setTitle("User Profile");
        initComponents();
        panelMouseEffect.registerMouseEffect();
    }

     /**
     * Constructor that initializes the UserProfile form with a specific user account.
     * @param user The account details of the user.
     */
    public UserProfile(Account user){
        setTitle("User Profile");
        this.user=user;
        initComponents();// Initialize components
        Wand.setCustomIcon(this);// Set custom icons
        Wand.setCustomCursor(this);// Set custom cursor
        panelMouseEffect.registerMouseEffect();// Register mouse effects for panels
    }
    
    /**
     * Set the type of user on the user interface.
     * @param userType The type of user to be displayed.
     */
    public void setUserType(String userType) {
        userTypes.setText(userType);
    }
    
    /**
     * Populate user information on the profile UI
     */
    public void setUser() {      
        nameOfUser.setText(user.getUsername());
        this.userID.setText(user.getUserID());
        this.username.setText(user.getUsername());
        this.DOB.setText(user.getDOB());
        this.phoneNumber.setText(user.getTelephone());
        this.email.setText(user.getEmail());
        this.homeAddress.setText(user.getAddress());
        
        // Check if user avatar is original without editing before, if so, set the profile picture by reading the imagepath from the database
        if (user.getUserAvatar() != null && user.getUserAvatar().getImagePath() != null && !user.getUserAvatar().getImagePath().trim().equals("/Images/profilePic.jpg")) {
            this.imagePathString = user.getUserAvatar().getImagePath();// Get image path
            profilePic.setIcon(new javax.swing.ImageIcon(this.imagePathString));//Set profile picture
            
        } else {
            System.out.println("Please wait for the image path to parse in...."); // Inform user about the image loading status
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMouseEffect = new Bank.PanelMouseEffect();
        top = new javax.swing.JPanel();
        myProfile = new java.awt.Label();
        logo = new javax.swing.JLabel();
        bottom = new javax.swing.JPanel();
        Home = new java.awt.Button();
        Profile = new java.awt.Button();
        homeAddressBackground = new javax.swing.JPanel();
        homeAddress = new javax.swing.JLabel();
        homeAdressLabel = new javax.swing.JLabel();
        profilePicBackground = new javax.swing.JPanel();
        nameOfUser = new javax.swing.JLabel();
        userTypes = new javax.swing.JLabel();
        profilePic = new javax.swing.JLabel();
        changeProfilePic = new javax.swing.JToggleButton();
        userID = new javax.swing.JLabel();
        phoneNumberBackground = new javax.swing.JPanel();
        phoneNumber = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        usernameBackground = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        emailBackground = new javax.swing.JPanel();
        email = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        DOBbackground = new javax.swing.JPanel();
        DOB = new javax.swing.JLabel();
        DOBlabel = new javax.swing.JLabel();
        editProfileButton = new javax.swing.JToggleButton();
        changePasswordButton = new javax.swing.JToggleButton();
        changePINButton = new javax.swing.JToggleButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 600));
        getContentPane().setLayout(null);

        top.setBackground(new java.awt.Color(78, 76, 74));

        myProfile.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        myProfile.setForeground(new java.awt.Color(255, 255, 255));
        myProfile.setText("My Profile");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo100x100.png"))); // NOI18N

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addComponent(logo)
                .addGap(21, 21, 21)
                .addComponent(myProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(640, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        panelMouseEffect.add(top);
        top.setBounds(0, 0, 1070, 100);

        bottom.setBackground(new java.awt.Color(78, 76, 74));

        Home.setBackground(new java.awt.Color(78, 76, 74));
        Home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Home.setLabel("Home");
        Home.setPreferredSize(new java.awt.Dimension(55, 25));
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        Profile.setBackground(new java.awt.Color(78, 76, 74));
        Profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Profile.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Profile.setLabel("Me");
        Profile.setPreferredSize(new java.awt.Dimension(55, 25));
        Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomLayout = new javax.swing.GroupLayout(bottom);
        bottom.setLayout(bottomLayout);
        bottomLayout.setHorizontalGroup(
            bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomLayout.createSequentialGroup()
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(Profile, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );
        bottomLayout.setVerticalGroup(
            bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomLayout.createSequentialGroup()
                .addComponent(Profile, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(bottomLayout.createSequentialGroup()
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelMouseEffect.add(bottom);
        bottom.setBounds(0, 520, 1070, 80);

        homeAddressBackground.setBackground(new java.awt.Color(0, 0, 0, 100));
        homeAddressBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        homeAddress.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        homeAddress.setForeground(new java.awt.Color(255, 255, 255));
        homeAddress.setText("Magical Land");

        homeAdressLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        homeAdressLabel.setForeground(new java.awt.Color(255, 255, 255));
        homeAdressLabel.setText("Home Address");

        javax.swing.GroupLayout homeAddressBackgroundLayout = new javax.swing.GroupLayout(homeAddressBackground);
        homeAddressBackground.setLayout(homeAddressBackgroundLayout);
        homeAddressBackgroundLayout.setHorizontalGroup(
            homeAddressBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeAddressBackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(homeAdressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(homeAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );
        homeAddressBackgroundLayout.setVerticalGroup(
            homeAddressBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeAddressBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(homeAddressBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeAddress)
                    .addComponent(homeAdressLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMouseEffect.add(homeAddressBackground);
        homeAddressBackground.setBounds(380, 370, 630, 40);

        profilePicBackground.setBackground(new java.awt.Color(0, 0, 0, 100));
        profilePicBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        nameOfUser.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        nameOfUser.setForeground(new java.awt.Color(255, 255, 255));
        nameOfUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameOfUser.setText("Harry Potter");

        userTypes.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        userTypes.setForeground(new java.awt.Color(204, 204, 204));
        userTypes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        String userType = userTypes.getText();
        userTypes.setText(userType);
        userTypes.setText("UserTypes");
        userTypes.setToolTipText("");

        profilePic.setBackground(new java.awt.Color(102, 255, 255));
        profilePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/profilePic.jpg"))); // NOI18N

        changeProfilePic.setBackground(new java.awt.Color(163, 151, 135));
        changeProfilePic.setText("Change Profile Picture");
        changeProfilePic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changeProfilePic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeProfilePicActionPerformed(evt);
            }
        });

        userID.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        userID.setForeground(new java.awt.Color(255, 255, 255));
        userID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userID.setText("userID");

        javax.swing.GroupLayout profilePicBackgroundLayout = new javax.swing.GroupLayout(profilePicBackground);
        profilePicBackground.setLayout(profilePicBackgroundLayout);
        profilePicBackgroundLayout.setHorizontalGroup(
            profilePicBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameOfUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(userTypes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePicBackgroundLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(profilePicBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePicBackgroundLayout.createSequentialGroup()
                        .addComponent(changeProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePicBackgroundLayout.createSequentialGroup()
                        .addComponent(profilePic)
                        .addGap(73, 73, 73))))
            .addComponent(userID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profilePicBackgroundLayout.setVerticalGroup(
            profilePicBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePicBackgroundLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(profilePic)
                .addGap(18, 18, 18)
                .addComponent(changeProfilePic)
                .addGap(30, 30, 30)
                .addComponent(nameOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        panelMouseEffect.add(profilePicBackground);
        profilePicBackground.setBounds(60, 120, 250, 380);

        phoneNumberBackground.setBackground(new java.awt.Color(0, 0, 0, 100));
        phoneNumberBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        phoneNumber.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        phoneNumber.setForeground(new java.awt.Color(255, 255, 255));
        phoneNumber.setText("0123456789");

        phoneNumberLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        phoneNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        phoneNumberLabel.setText("Phone Number");

        javax.swing.GroupLayout phoneNumberBackgroundLayout = new javax.swing.GroupLayout(phoneNumberBackground);
        phoneNumberBackground.setLayout(phoneNumberBackgroundLayout);
        phoneNumberBackgroundLayout.setHorizontalGroup(
            phoneNumberBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phoneNumberBackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(phoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );
        phoneNumberBackgroundLayout.setVerticalGroup(
            phoneNumberBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phoneNumberBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(phoneNumberBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumber)
                    .addComponent(phoneNumberLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMouseEffect.add(phoneNumberBackground);
        phoneNumberBackground.setBounds(380, 250, 630, 40);

        usernameBackground.setBackground(new java.awt.Color(0, 0, 0, 100));
        usernameBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        username.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Harry Potter");

        usernameLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username ");

        javax.swing.GroupLayout usernameBackgroundLayout = new javax.swing.GroupLayout(usernameBackground);
        usernameBackground.setLayout(usernameBackgroundLayout);
        usernameBackgroundLayout.setHorizontalGroup(
            usernameBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameBackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );
        usernameBackgroundLayout.setVerticalGroup(
            usernameBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(usernameBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(usernameLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMouseEffect.add(usernameBackground);
        usernameBackground.setBounds(380, 130, 630, 40);

        emailBackground.setBackground(new java.awt.Color(0, 0, 0, 100));
        emailBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        email.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("harrypotter@gmail.com");

        emailLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email Address");

        javax.swing.GroupLayout emailBackgroundLayout = new javax.swing.GroupLayout(emailBackground);
        emailBackground.setLayout(emailBackgroundLayout);
        emailBackgroundLayout.setHorizontalGroup(
            emailBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailBackgroundLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(emailLabel)
                .addGap(74, 74, 74)
                .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );
        emailBackgroundLayout.setVerticalGroup(
            emailBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(emailBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(emailLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMouseEffect.add(emailBackground);
        emailBackground.setBounds(380, 310, 630, 40);

        DOBbackground.setBackground(new java.awt.Color(0, 0, 0, 100));
        DOBbackground.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DOB.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        DOB.setForeground(new java.awt.Color(255, 255, 255));
        DOB.setText("12/ 12/ 2004");

        DOBlabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        DOBlabel.setForeground(new java.awt.Color(255, 255, 255));
        DOBlabel.setText("Date of Birth");

        javax.swing.GroupLayout DOBbackgroundLayout = new javax.swing.GroupLayout(DOBbackground);
        DOBbackground.setLayout(DOBbackgroundLayout);
        DOBbackgroundLayout.setHorizontalGroup(
            DOBbackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOBbackgroundLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(DOBlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(DOB, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addContainerGap())
        );
        DOBbackgroundLayout.setVerticalGroup(
            DOBbackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOBbackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DOBbackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DOB)
                    .addComponent(DOBlabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMouseEffect.add(DOBbackground);
        DOBbackground.setBounds(380, 190, 630, 40);

        editProfileButton.setBackground(new java.awt.Color(163, 151, 135));
        editProfileButton.setText("Edit Profile");
        editProfileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });
        panelMouseEffect.add(editProfileButton);
        editProfileButton.setBounds(850, 450, 160, 30);

        changePasswordButton.setBackground(new java.awt.Color(213, 210, 175));
        changePasswordButton.setText("Password Resetus");
        changePasswordButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });
        panelMouseEffect.add(changePasswordButton);
        changePasswordButton.setBounds(380, 450, 160, 30);

        changePINButton.setBackground(new java.awt.Color(213, 210, 175));
        changePINButton.setText("PIN Resetus");
        changePINButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changePINButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePINButtonActionPerformed(evt);
            }
        });
        panelMouseEffect.add(changePINButton);
        changePINButton.setBounds(560, 450, 160, 30);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/userProfile.jpg"))); // NOI18N
        panelMouseEffect.add(background);
        background.setBounds(0, 0, 1070, 601);

        getContentPane().add(panelMouseEffect);
        panelMouseEffect.setBounds(0, 0, 1070, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action performed when the Home button is clicked.
     * @param evt The event triggered by clicking the Home button.
     */
    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        UserHomePage userHomePage = new UserHomePage(user);// Create a new UserHomePage with the user's account
        userHomePage.setUser();// Set user details on the home page
        userHomePage.setUserTypes();// Set user type on the home page
        userHomePage.updateProfilePicture(); // Update profile picture on the home page
        userHomePage.setVisible(true);
        userHomePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileActionPerformed

    }//GEN-LAST:event_ProfileActionPerformed

    /**
     * Action performed when the Change Password button is clicked.
     * @param evt The event triggered by clicking the Change Password button.
     */
    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        ChangePassword changePassword = new ChangePassword(user);// Create ChangePassword form with user's account
        changePassword.setVisible(true);
        changePassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    /**
     * Action performed when the Change PIN button is clicked.
     * @param evt The event triggered by clicking the Change PIN button.
     */
    private void changePINButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePINButtonActionPerformed
        ChangePIN changePIN = new ChangePIN(user); // Create ChangePIN form with user's account
        changePIN.setVisible(true);
        changePIN.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_changePINButtonActionPerformed

    /**
     * Action performed when the Edit Profile button is clicked.
     * @param evt The event triggered by clicking the Edit Profile button.
     */
    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButtonActionPerformed
        EditProfile editProfile = new EditProfile(user);// Create EditProfile form with user's account
        editProfile.setUser();// Set user details on the EditProfile form so that user can edit easily
        editProfile.setVisible(true);
        editProfile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_editProfileButtonActionPerformed

    /**
     * Action performed when the Change Profile Picture button is clicked.
     * @param evt The event triggered by clicking the Change Profile Picture button.
     */
    private void changeProfilePicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeProfilePicActionPerformed
        System.out.println(OpenFileViaExplorer(profilePic)); // Open file explorer to select a new profile picture

    }//GEN-LAST:event_changeProfilePicActionPerformed

    /**
     * Open file explorer to select a new profile picture and update it
     * @param profilePic JLabel component to set the profile picture
     * @return boolean indicating success or failure
     */
    private boolean OpenFileViaExplorer(JLabel profilePic) {
        try {
            JFileChooser fileChooser = new JFileChooser();// Create file chooser
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "png", "jpg");
            fileChooser.setFileFilter(filter);// Set file filter for image files
            fileChooser.setCurrentDirectory(new File("."));// Set current directory
            int result = fileChooser.showOpenDialog(null);// Show open dialog and get result
            System.out.println("Result" + result);
            if (result == JFileChooser.APPROVE_OPTION) {// If a file is selected
                File selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());// Get selected file
                System.out.println("Filepath: " + selectedFile);
                
                String selectedfilepath=selectedFile.getAbsolutePath();// Get the absolute path of the selected file
                // Create an ImageIcon from the selected file
                ImageIcon icon = new ImageIcon(selectedfilepath);

                // Set the ImageIcon as the icon for the profilePic component
                profilePic.setIcon(icon);
                user.setUserAvatar(new UserAvatar(selectedfilepath,user.getUserID()));// Update user's avatar with the new image path
                System.out.println("the path is:" +user.getUserAvatar().getImagePath());
                
                // Initialize database connection to store the imagepath
                Connection connection = null;
                String userid, selectquery, updatequery,finduserid,oldImagePath;
                int notFound = 0;// Flag to check if user is found
                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Egringotts", "root", "password");

                    userid=user.getUserID();
                    selectquery = "SELECT * FROM Account WHERE UserID= ?";
                    updatequery = "UPDATE Account SET ImagePath=? WHERE UserID=?";
                    
                    PreparedStatement selectStatement = connection.prepareStatement(selectquery);
                    selectStatement.setString(1, userid);
                    ResultSet resultset = selectStatement.executeQuery();
                    
                    while (resultset.next()) {// Iterate through the result set
                        finduserid=resultset.getString("UserID");
                        oldImagePath = resultset.getString("ImagePath");
                        notFound = 1;

                        if (notFound == 1 ) {// If user is found
                            PreparedStatement updateStatement = connection.prepareStatement(updatequery); // Prepare update statement
                            updateStatement.setString(1, selectedfilepath);// Set new image path in the update statement
                            updateStatement.setString(2, userid);// Set user ID in the update statement
                            updateStatement.executeUpdate();// Execute update query
                            JOptionPane.showMessageDialog(new JFrame(), "Profile Picture change successfully!");

                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Profile Picture change unsuccessfully!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (notFound == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (Exception e) {
                    System.out.println("Error!" + e.getMessage());
                }
                if (!Desktop.isDesktopSupported()) {
                    System.out.println("Not supported");
                    return false;
                } else {
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(selectedFile);
                    return true;
                }
            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("Cancelled.");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
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
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DOB;
    private javax.swing.JPanel DOBbackground;
    private javax.swing.JLabel DOBlabel;
    private java.awt.Button Home;
    private java.awt.Button Profile;
    private javax.swing.JLabel background;
    private javax.swing.JPanel bottom;
    private javax.swing.JToggleButton changePINButton;
    private javax.swing.JToggleButton changePasswordButton;
    private javax.swing.JToggleButton changeProfilePic;
    private javax.swing.JToggleButton editProfileButton;
    private javax.swing.JLabel email;
    private javax.swing.JPanel emailBackground;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel homeAddress;
    private javax.swing.JPanel homeAddressBackground;
    private javax.swing.JLabel homeAdressLabel;
    private javax.swing.JLabel logo;
    private java.awt.Label myProfile;
    private javax.swing.JLabel nameOfUser;
    private Bank.PanelMouseEffect panelMouseEffect;
    private javax.swing.JLabel phoneNumber;
    private javax.swing.JPanel phoneNumberBackground;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel profilePic;
    private javax.swing.JPanel profilePicBackground;
    private javax.swing.JPanel top;
    private javax.swing.JLabel userID;
    private javax.swing.JLabel userTypes;
    private javax.swing.JLabel username;
    private javax.swing.JPanel usernameBackground;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
