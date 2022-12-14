package ma.fpbm.fpbmback.beans;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhdEtudiant extends Personne {

    private String sujet;

    @OneToMany(mappedBy = "phdEtudiant")
    @JsonBackReference(value = "phdinsc")
    private List<Inscription> inscription;

    //relation avec la table ced
    @ManyToOne

    private Ced idCed;

    //relation avec la table soutenance
    @OneToMany(mappedBy = "phdEtudiant_sout")
    @JsonBackReference(value = "phdsous")
    private Collection<Soutenance> soutenance;


}
