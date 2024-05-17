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
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private WorkstationRepository workstationRepository;
    @Autowired
    private UserRepository userRepository;

    public Reservation createReservation(String username, Long workstationId, LocalDate reservationDate) {
        User user = userRepository.findById(Integer.valueOf(username))
                .orElseThrow(() -> new RuntimeException("User not found"));
        Workstation workstation = workstationRepository.findById(Math.toIntExact(workstationId))
                .orElseThrow(() -> new RuntimeException("Workstation not found"));

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setWorkstation(workstation);
        reservation.setReservationDate(reservationDate);

        return reservationRepository.save(reservation);
    }

    public boolean isUserAlreadyReserved(User user, LocalDate reservationDate) {
        return reservationRepository.existsByUserAndReservationDate(user, reservationDate);
    }

    public boolean isWorkstationAvailable(Workstation workstation, LocalDate reservationDate) {
        return !reservationRepository.existsByWorkstationAndReservationDate(workstation, reservationDate);
    }
}
