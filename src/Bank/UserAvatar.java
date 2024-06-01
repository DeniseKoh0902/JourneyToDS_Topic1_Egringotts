/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

/**
 *
 * @author Asus
 */
public class UserAvatar {
    private String imagePath;
    private String userId;

    /**
     * Constructs a UserAvatar with the specified image path and user ID.
     *
     * @param imagePath The path to the avatar image.
     * @param userId    The ID of the user.
     */
    public UserAvatar(String imagePath, String userId) {
        this.imagePath = imagePath;
        this.userId = userId;
    }

    // Getters and Setters
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUserId() {
        return userId;
    }

}

