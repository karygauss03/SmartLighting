package tn.smart_lighting.entities;

import java.util.Objects;

public class Address {
    private String AddressLine1;
    private String AddressLine2;
    private String district;
    private String postalCode;
    private String phone;
    private City city;

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return AddressLine1.equals(address.AddressLine1) && Objects.equals(AddressLine2, address.AddressLine2) && district.equals(address.district) && postalCode.equals(address.postalCode) && phone.equals(address.phone) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AddressLine1, AddressLine2, district, postalCode, phone, city);
    }

    @Override
    public String toString() {
        return "{" +
                "\"addressLine1\":\"" + AddressLine1 + '\"' +
                ", \"addressLine2\":\"" + AddressLine2 + '\"' +
                ", \"district\":\"" + district + '\"' +
                ", \"postalCode\":\"" + postalCode + '\"' +
                ", \"phone\":\"" + phone + '\"' +
                ", \"city\":\"" + city +
                '}';
    }
}
