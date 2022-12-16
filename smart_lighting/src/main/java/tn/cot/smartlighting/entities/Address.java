package tn.cot.smartlighting.entities;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import tn.cot.smartlighting.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
@Table(name = "addresses")
public class Address {
    @Id
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
    private Boolean archived;

    public Address() { };

    public Address(Country country, String cityId, String zipCode, String description) {
        this.country = country;
        this.cityId = cityId;
        this.zipCode = zipCode;
        this.description = description;
    }

    public void setArchived(Boolean archived) {
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

    public Boolean getArchived() {
        return archived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && country == address.country && Objects.equals(cityId, address.cityId) && Objects.equals(zipCode, address.zipCode) && Objects.equals(description, address.description) && Objects.equals(archived, address.archived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, cityId, zipCode, description, archived);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", country=" + country +
                ", cityId='" + cityId + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", description='" + description + '\'' +
                ", archived=" + archived +
                '}';
    }
}
