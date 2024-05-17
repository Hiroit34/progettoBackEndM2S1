package com.progetto.progettobackendm1s2.reservationservice;



import com.progetto.progettobackendm1s2.data.Reservation;
import com.progetto.progettobackendm1s2.data.User;
import com.progetto.progettobackendm1s2.data.Workstation;
import com.progetto.progettobackendm1s2.repository.ReservationRepository;
import com.progetto.progettobackendm1s2.repository.UserRepository;
import com.progetto.progettobackendm1s2.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private WorkstationRepository workstationRepository;
    @Autowired
    private UserRepository userRepository;

    public ReservationRepository createReservation(String username, Long workstationId, LocalDate date){
        User user = userRepository.findById(Integer.valueOf(username))
                .orElseThrow(() -> new RuntimeException("User not find"));
        Workstation workstation = workstationRepository.findById(Math.toIntExact(workstationId))
                .orElseThrow(() -> new RuntimeException("Workstation not found"));

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setWorkstation(workstation);
        reservation.setDate(date);

        return (ReservationRepository) reservationRepository.save(reservation);

    }

}
