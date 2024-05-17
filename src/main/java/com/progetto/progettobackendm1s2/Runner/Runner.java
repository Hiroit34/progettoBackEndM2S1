package com.progetto.progettobackendm1s2.Runner;

import com.progetto.progettobackendm1s2.data.*;
import com.progetto.progettobackendm1s2.repository.BuildingRepository;
import com.progetto.progettobackendm1s2.repository.ReservationRepository;
import com.progetto.progettobackendm1s2.repository.UserRepository;
import com.progetto.progettobackendm1s2.repository.WorkstationRepository;
import com.progetto.progettobackendm1s2.reservationservice.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    private final BuildingRepository buildingRepository;
    private final UserRepository userRepository;
    private final WorkstationRepository workstationRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    @Autowired
    public Runner(BuildingRepository buildingRepository, UserRepository userRepository, WorkstationRepository workstationRepository, ReservationRepository reservationRepository, ReservationService reservationService) {
        this.buildingRepository = buildingRepository;
        this.userRepository = userRepository;
        this.workstationRepository = workstationRepository;
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
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
                    .withId(0L)
                    .withFullName("Franz Natavio")
                    .withEmail("franz@natavio.com")
                    .withUserName("0")
                    .build();
            User user1 = User.builder()
                    .withId(1L)
                    .withFullName("Rosa Sorpreso")
                    .withEmail("rosa@sorpreso.com")
                    .withUserName("1")
                    .build();
            User user2 = User.builder()
                    .withId(2L)
                    .withFullName("Simone Giarnera")
                    .withEmail("simone@Giarnera.com")
                    .withUserName("MastrOdio")
                    .build();

            Workstation workstation0 = Workstation.builder()
                    .withId(3L)
                    .withBuilding(building0)
                    .withDescription("Sala usata per fare le riunioni")
                    .withMaxUser(4)
                    .withTypeOfWorkStation(TypeOfWorkstation.PRIVATE)
                    .build();

            Workstation workstation1 = Workstation.builder()
                    .withId(4L)
                    .withBuilding(building0)
                    .withDescription("Sala usata")
                    .withMaxUser(9)
                    .withTypeOfWorkStation(TypeOfWorkstation.OPEN_SPACE)
                    .build();

            Workstation workstation2 = Workstation.builder()
                    .withId(5L)
                    .withBuilding(building0)
                    .withDescription("Sala")
                    .withMaxUser(2)
                    .withTypeOfWorkStation(TypeOfWorkstation.MEETING_ROOM)
                    .build();


            buildingRepository.save(building0);
            buildingRepository.save(building1);
            buildingRepository.save(building2);
            userRepository.save(user0);
            userRepository.save(user1);
            workstationRepository.save(workstation0);
            workstationRepository.save(workstation1);
            workstationRepository.save(workstation2);

            System.out.println("edifici salvati correttamente");
            System.out.println("user salvati correttamente");
            System.out.println("postazioni salvati correttamente");
            System.out.println(reservationService.createReservation(user1.getId(),workstation0.getId(), LocalDate.now()));
            reservationService.createReservation(user1.getId(),workstation0.getId(), LocalDate.now());
            reservationService.createReservation(user0.getId(), workstation2.getId(), LocalDate.now());
            reservationService.createReservation(user2.getId(), workstation1.getId(), LocalDate.now().plusDays(1));


//            reservationService.createReservation(user1.getId(),workstation0.getId(), LocalDate.now());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Ciao, risparmiami");
        }


    }
}
