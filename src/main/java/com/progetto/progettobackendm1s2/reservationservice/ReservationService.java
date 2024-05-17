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
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private WorkstationService workstationService;
    @Autowired
    private UserService userService;

    public Reservation createReservation(Long userId, Long workstationId, LocalDate reservationDate) {
        User user = userService.findById(userId);

        Workstation workstation = workstationService.findById(workstationId);

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

    public List<Reservation> reservationsByUserAndDate(User user, LocalDate reservationDate) {
        return reservationRepository.findByUserAndReservationDate(user, reservationDate);
    }
}
