package tn.cot.smartlighting.repositories;

import jakarta.nosql.mapping.Repository;
import tn.cot.smartlighting.entities.Assignment;

import java.util.stream.Stream;

public interface AssignmentRepository extends Repository<Assignment, String> {
    Stream<Assignment> findAll();
    Stream<Assignment> findByEmployeeId(String id);
    Stream<Assignment> findByRepaired(boolean repaired);
}
