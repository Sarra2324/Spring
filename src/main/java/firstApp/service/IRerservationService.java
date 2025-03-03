package firstApp.service;

import firstApp.entity.Reservation;

import java.util.List;

public interface IRerservationService {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);
}
