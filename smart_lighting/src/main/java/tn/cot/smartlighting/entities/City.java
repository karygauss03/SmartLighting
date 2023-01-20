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
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private Country country;
    @Column
    private String name;
    @Column
    private String created_on;

    public City() {
    }

    public String getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && country == city.country && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, name, created_on);
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", country=" + country +
                ", name='" + name + '\'' +
                '}';
    }

    public static CityBuilder builder() {
        return new CityBuilder();
    }

    public static class CityBuilder {
        private String id;
        private Country country;
        private String name;
        private String created_on;
        public CityBuilder WithId(String id) {
            this.id = id;
            return this;
        }
        public CityBuilder WithCountry(Country country) {
            this.country = country;
            return this;
        }
        public CityBuilder WithName(String name) {
            this.name = name;
            return this;
        }
        public CityBuilder WithCreatedOn(String created_on) {
            this.created_on = LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy hh:mm:ss a"));
            return this;
        }
        public City build() {
            City city = new City();
            city.id = this.id;
            city.country = this.country;
            city.name = this.name;
            city.created_on = this.created_on;
            return city;
        }
    }
}