package tn.cot.smartlighting.entities;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import tn.cot.smartlighting.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private Country country;
    @Column
    private String cityId;
    @Column
    private String zipCode;
    @Column
    private String description;
    @Column
    private boolean archived;
    @Column
    private String created_on;

    public Address() { };

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public String getCityId() {
        return cityId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getDescription() {
        return description;
    }

    public boolean isArchived() {
        return archived;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
        private String id;
        private Country country;
        private String cityId;
        private String zipCode;
        private String description;
        private boolean archived;
        private String created_on;
        public AddressBuilder WithId(String id){
            this.id = id;
            return this;
        }
        public AddressBuilder WithCountry(Country country) {
            this.country = country;
            return this;
        }
        public AddressBuilder WithCityId(String cityId) {
            this.cityId = cityId;
            return this;
        }
        public AddressBuilder WithZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }
        public AddressBuilder WithDescription(String description) {
            this.description = description;
            return this;
        }
        public AddressBuilder WithArchived() {
            this.archived = false;
            return this;
        }
        public AddressBuilder WithCreatedOn() {
            this.created_on = LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy hh:mm:ss a"));
            return this;
        }
        public Address build() {
            Address address = new Address();
            address.id = id;
            address.country = country;
            address.cityId = cityId;
            address.zipCode = zipCode;
            address.description = description;
            address.archived = archived;
            address.created_on = created_on;
            return address;
        }
    }

}
