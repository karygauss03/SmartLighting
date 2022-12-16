package tn.cot.smartlighting.entities;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import tn.cot.smartlighting.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
@Table(name = "cities")
public class City {
    @Id
    private UUID id;
    @Column
    private Country country;
    @Column
    private String name;
    @Column
    private LocalDateTime createdOn;

    public City() { };
    public City(Country country, String name) {
        this.id = UUID.randomUUID();
        this.country = country;
        this.name = name;
        this.createdOn = LocalDateTime.now();
    }


    public String getCityName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, name, createdOn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && country == city.country && Objects.equals(name, city.name) && Objects.equals(createdOn, city.createdOn);
    }
}
