package tn.cot.smartlighting.repositories;

import jakarta.nosql.mapping.Repository;
import tn.cot.smartlighting.entities.Address;

import java.util.stream.Stream;

public interface AddressRepository extends Repository<Address, String> {
    Stream<Address> findAll();
}
