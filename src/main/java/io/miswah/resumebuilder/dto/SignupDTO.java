package io.miswah.resumebuilder.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SignupDTO {
    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String password;

    private String matchingPassword;

    @NotNull
    @NotEmpty
    private String email;

    public SignupDTO() {
    }

    public SignupDTO(String userName, String password, String matchingPassword, String email) {
        this.userName = userName;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
