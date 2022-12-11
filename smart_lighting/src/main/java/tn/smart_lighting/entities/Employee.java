package tn.smart_lighting.entities;

import java.util.Date;
import java.util.Objects;

public class Employee {

    private Integer id;
    private Integer nic;
    private String forename;
    private String surname;
    private String password;
    private Address address;
    private Integer phoneNumber;
    private Date birthDate;
    private Role userRole;
    private Date creationDate;
    private Boolean archived;

    public Integer getId() {
        return id;
    }

    public Integer getNIC() {
        return nic;
    }

    public void setNIC(Integer nic) {
        this.nic = nic;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && nic.equals(employee.nic) && forename.equals(employee.forename) && surname.equals(employee.surname) && password.equals(employee.password) && address.equals(employee.address) && phoneNumber.equals(employee.phoneNumber) && birthDate.equals(employee.birthDate) && userRole == employee.userRole && creationDate.equals(employee.creationDate) && archived.equals(employee.archived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nic, forename, surname, password, address, phoneNumber, birthDate, userRole, creationDate, archived);
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"NIC\":" + nic +
                ", \"forename\":\"" + forename + '\"' +
                ", \"surname=\":\"" + surname + '\"' +
                ", \"password\":\"" + password + '\"' +
                ", \"work\":\"" + address + '\"' +
                ", \"phoneNumber\":" + phoneNumber +
                ", \"birthDate\":" + birthDate +
                ", \"userRole\":" + userRole +
                ", \"creationDate\":" + creationDate +
                ", \"archived\":" + archived +
                '}';
    }
}
