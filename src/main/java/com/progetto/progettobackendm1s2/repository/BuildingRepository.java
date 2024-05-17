package com.progetto.progettobackendm1s2.repository;

import com.progetto.progettobackendm1s2.data.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
    Building findByCity(String city);
}
