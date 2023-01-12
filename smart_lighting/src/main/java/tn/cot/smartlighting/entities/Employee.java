package tn.cot.smartlighting.entities;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import tn.cot.smartlighting.FieldPropertyVisibilityStrategy;
import tn.cot.smartlighting.utils.Argon2Utils;

import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
@Table(name = "employees")
public class Employee implements Serializable {
    @Id
    @Column("email")
    private String email;
    @Column("forename")
    private String forename;
    @Column("surname")
    private String surname;
    @Column("addressId")
    private String address_id;
    @Column("phoneNumber")
    private String phoneNumber;
    @Column("password")
    private String password;
    @Column("userRole")
    private Set<Role> roles;

    public Employee() {
    }

    public String getEmail() {
        return email;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress_id() {
        return address_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Employee(String email, String forename, String surname, String address_id, String phoneNumber, String password, Set<Role> roles) {
        this.email = email;
        this.forename = forename;
        this.surname = surname;
        this.address_id = address_id;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(email, employee.email) && Objects.equals(forename, employee.forename) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, forename, surname, address_id, phoneNumber, password, roles);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", address_id='" + address_id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public void hashPassword(String password, Argon2Utils argon2Utility) {
        this.password = argon2Utility.hash(password.toCharArray());
    }
}
