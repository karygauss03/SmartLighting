package tn.cot.smartlighting.security;

import tn.cot.smartlighting.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import javax.validation.constraints.NotBlank;

@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Oauth2Request {
    @NotBlank
    private GrantType grandType;

    @NotBlank(groups = {GenerateToken.class})
    private String email;

    @NotBlank(groups = {GenerateToken.class})
    private String password;

    @NotBlank(groups = {RefreshToken.class})
    private String refreshToken;

    public GrantType getGrandType() {
        return grandType;
    }

    public void setGrandType(GrantType grandType) {
        this.grandType = grandType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Oauth2Request{" +
                "grandType='" + grandType + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public @interface GenerateToken{}

    public @interface RefreshToken{}
}