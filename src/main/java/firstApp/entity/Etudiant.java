package firstApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant implements Serializable {
   @Id
    private int idEtudiant;
   private String nomEt;
   private String prenomEt;
   private int CIN;
   private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @ManyToMany(mappedBy="etudiants", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
