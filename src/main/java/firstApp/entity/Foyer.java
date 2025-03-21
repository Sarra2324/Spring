package firstApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private  int capaciteFoyer;

    @OneToMany(mappedBy = "foyer")
    private Set<Bloc> blocs;
    @OneToOne(mappedBy = "foyer")
    private Universite universite;

    public long getIdFoyer() {
        return idFoyer;
    }

    public void setIdFoyer(long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public String getNomFoyer() {
        return nomFoyer;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public int getCapaciteFoyer() {
        return capaciteFoyer;
    }

    public void setCapaciteFoyer(int capaciteFoyer) {
        this.capaciteFoyer = capaciteFoyer;
    }

    public Set<Bloc> getBlocs() {
        return blocs;
    }

    public void setBlocs(Set<Bloc> blocs) {
        this.blocs = blocs;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }
}

