package com.progetto.progettobackendm1s2.Runner;

import com.progetto.progettobackendm1s2.data.Building;
import com.progetto.progettobackendm1s2.data.TypeOfWorkstation;
import com.progetto.progettobackendm1s2.data.User;
import com.progetto.progettobackendm1s2.data.Workstation;
import com.progetto.progettobackendm1s2.repository.BuildingRepository;
import com.progetto.progettobackendm1s2.repository.UserRepository;
import com.progetto.progettobackendm1s2.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final BuildingRepository buildingRepository;
    private final UserRepository userRepository;
    private final WorkstationRepository workstationRepository;

    @Autowired
    public Runner(BuildingRepository buildingRepository, UserRepository userRepository, WorkstationRepository workstationRepository) {
        this.buildingRepository = buildingRepository;
        this.userRepository = userRepository;
        this.workstationRepository = workstationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Building building0 = Building.builder()
                .withName("Metting room")
                .withAddress("Via le mani dal naso 10")
                .withCity("Roma")
                .build();

        Building building1 = Building.builder()
                .withName("Main Office")
                .withAddress("Via dei Mille 145")
                .withCity("Roma")
                .build();

        Building building2 = Building.builder()
                .withName("Secondary Office")
                .withAddress("Via dei Partigiani 123")
                .withCity("Roma")
                .build();

        User user0 = User.builder()
                .withFullName("Franz Natavio")
                .withEmail("franz@natavio.com")
                .withUserName("Franz2")
                .build();
        User user1 = User.builder()
                .withFullName("Rosa Sorpreso")
                .withEmail("rosa@sorpreso.com")
                .withUserName("Rosa1")
                .build();
        User user2 = User.builder()
                .withFullName("Simone Giarnera")
                .withEmail("simone@Giarnera.com")
                .withUserName("MastrOdio")
                .build();

        Workstation workstation0 = Workstation.builder()
                .withBuilding(building0)
                .withDescription("Sala usata per fare le riunioni")
                .withMaxUser(4)
                .withTypeOfWorkStation(TypeOfWorkstation.PRIVATE)
                .build();

        buildingRepository.save(building0);
        buildingRepository.save(building1);
        userRepository.save(user0);
        userRepository.save(user1);
        workstationRepository.save(workstation0);

        System.out.println("edifici salvati correttamente");
        System.out.println("user salvati correttamente");
        System.out.println("postazioni salvati correttamente");
    }
}
