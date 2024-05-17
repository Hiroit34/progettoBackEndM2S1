package com.progetto.progettobackendm1s2.repository;

import com.progetto.progettobackendm1s2.data.Building;
import com.progetto.progettobackendm1s2.data.TypeOfWorkstaion;
import com.progetto.progettobackendm1s2.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkstationRepository extends JpaRepository<Workstation, Integer> {
    List<WorkstationRepository> findByTypeOfWorkStationAndBuilding (TypeOfWorkstaion type, Building building);
}
