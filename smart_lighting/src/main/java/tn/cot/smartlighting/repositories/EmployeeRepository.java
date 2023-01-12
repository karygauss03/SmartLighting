package tn.cot.smartlighting.repositories;

import jakarta.nosql.mapping.Repository;
import tn.cot.smartlighting.entities.Employee;

import java.util.Optional;
import java.util.stream.Stream;

public interface EmployeeRepository extends Repository<Employee, String> {
    Optional<Employee> findByEmail(String email);
    Stream<Employee> findAll();
}
