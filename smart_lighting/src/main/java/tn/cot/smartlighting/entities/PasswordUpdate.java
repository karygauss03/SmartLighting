package tn.cot.smartlighting.entities;


public class PasswordUpdate {
    private String oldPassword;
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public PasswordUpdate() {
    }

    public PasswordUpdate(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

}
