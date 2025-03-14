package firstApp.service;

import firstApp.entity.Reservation;
import firstApp.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ReservationService implements IRerservationService{
    @Autowired
    IReservationRepository reservationRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {

        return List.of();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return  reservationRepository.findReservationsByAnneeUniversitaire(anneeUniversitaire);
    }
}
