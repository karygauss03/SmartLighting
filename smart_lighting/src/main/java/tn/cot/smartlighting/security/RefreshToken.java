package tn.cot.smartlighting.security;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import java.util.Objects;

@Entity
public class RefreshToken {
    @Column
    private String token;
    @Column
    private AccessToken accessToken;
    RefreshToken(Token token, AccessToken accessToken) {
        this.token = token.get();
        this.accessToken = accessToken;
    }

    @Deprecated

    public RefreshToken() {
    }

    public String getToken() {
        return token;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefreshToken that = (RefreshToken) o;
        return Objects.equals(token, that.token) && Objects.equals(accessToken, that.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, accessToken);
    }

    @Override
    public String toString() {
        return "RefreshToken{" +
                "token='" + token + '\'' +
                ", accessToken=" + accessToken +
                '}';
    }
}
