package firstApp.controller;

import firstApp.entity.Reservation;
import firstApp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/getAll")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservation();
    }

    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation res) {
        return reservationService.updateReservation(res);
    }

    @GetMapping("/get/{id}")
    public Reservation retrieveReservation(@PathVariable("id") String idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }
}
