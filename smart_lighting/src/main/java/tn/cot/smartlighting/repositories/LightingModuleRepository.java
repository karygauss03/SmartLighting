package tn.cot.smartlighting.repositories;

import jakarta.nosql.mapping.Repository;
import tn.cot.smartlighting.entities.LightingModule;

import java.util.stream.Stream;

public interface LightingModuleRepository extends Repository<LightingModule, String> {
    Stream<LightingModule> findAll();
    Stream<LightingModule> findByArchived(boolean archived);
    Stream <LightingModule> findByOn(boolean on);
    Stream <LightingModule> findByBroken(boolean broken);
}
