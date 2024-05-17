package com.progetto.progettobackendm1s2.repository;

import com.progetto.progettobackendm1s2.data.Building;
import com.progetto.progettobackendm1s2.data.TypeOfWorkstation;
import com.progetto.progettobackendm1s2.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkstationRepository extends JpaRepository<Workstation, Integer> {
    List<Workstation> findByTypeOfWorkStationAndBuilding (TypeOfWorkstation type, Building building);
    Optional<Workstation> findById(Integer id);
}
