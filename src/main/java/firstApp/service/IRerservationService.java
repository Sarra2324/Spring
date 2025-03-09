package firstApp.service;

import firstApp.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IRerservationService {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);
}
