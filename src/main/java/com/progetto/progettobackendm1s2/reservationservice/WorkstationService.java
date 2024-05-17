package com.progetto.progettobackendm1s2.reservationservice;

import com.progetto.progettobackendm1s2.data.Building;
import com.progetto.progettobackendm1s2.data.TypeOfWorkstation;
import com.progetto.progettobackendm1s2.data.Workstation;
import com.progetto.progettobackendm1s2.repository.BuildingRepository;
import com.progetto.progettobackendm1s2.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class WorkstationService {

    @Autowired
    private WorkstationRepository workstationRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    public Workstation findById(Long id) {
        Optional<Workstation> workstationOptional = workstationRepository.findById(id);
        return workstationOptional.orElse(null);
    }

    public List<Workstation> findByTypeOfWorkStationAndBuilding(TypeOfWorkstation type, String city) {
        Building building = buildingRepository.findByCity(city);

        if (building != null) {
            return workstationRepository.findByTypeOfWorkStationAndBuilding(type, building);
        } else {
            return Collections.emptyList();
        }
    }

}
