package tn.cot.smartlighting.entities;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import tn.cot.smartlighting.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
@Table(name = "cities")
public class City {
    @Id
    private String id;
    @Column
    private Country country;
    @Column
    private String name;

    public City() { };
    public City(Country country, String name, LocalDateTime dateTime) {
        this.country = country;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && country == city.country && Objects.equals(name, city.name);
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", country=" + country +
                ", name='" + name + '\'' +
                '}';
    }
}
