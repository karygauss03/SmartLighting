package tn.cot.smartlighting.repositories;

import jakarta.nosql.mapping.Repository;
import tn.cot.smartlighting.entities.City;
import tn.cot.smartlighting.entities.Country;

import java.util.stream.Stream;

public interface CityRepository extends Repository<City, String> {
    Stream<City> findAll();
    Stream<City> findByCountry(Country country);
}
