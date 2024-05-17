package com.progetto.progettobackendm1s2.repository;

import com.progetto.progettobackendm1s2.data.Reservation;
import com.progetto.progettobackendm1s2.data.User;
import com.progetto.progettobackendm1s2.data.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserAndDate(User user, LocalDate date);
    boolean existsByWorkstationAndDate(Workstation workstation, LocalDate date);
    boolean existsByUserAndReservationDate(User user, LocalDate reservationDate);
}
