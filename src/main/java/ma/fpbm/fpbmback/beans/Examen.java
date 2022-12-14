package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Examen {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String jour;

    @Column
    private String heure;



    @ManyToOne
    private Salle salle;

    @ManyToOne
    private ProfesseurHasModule profHasModule;

    @OneToMany(mappedBy = "id_examen")
    @JsonBackReference(value = "surveillants")
    private Collection<Surveillant> surveillants;

    @OneToMany(mappedBy = "examen")
    @JsonBackReference(value = "examenProfModEtd")
    private Collection<ExamenHasProfesseurHasModuleHasEtudiant> examenProfModEtd;

}
