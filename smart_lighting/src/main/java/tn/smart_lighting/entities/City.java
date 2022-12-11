package tn.smart_lighting.entities;

import java.util.Objects;

public class City {
    private String city;
    private Country country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city, city1.city) && Objects.equals(country, city1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }

    @Override
    public String toString() {
        return "{" +
                "\"city\":\"" + city + '\"' +
                ", country=" + country +
                '}';
    }
}
