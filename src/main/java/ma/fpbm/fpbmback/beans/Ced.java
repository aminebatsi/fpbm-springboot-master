package ma.fpbm.fpbmback.beans;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Ced {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCed;
    private String name;
    @OneToMany(mappedBy = "ced")
    @JsonBackReference(value = "ced-labo")
    private List<Labo> labo;
    @OneToMany(mappedBy = "idCed")
    @JsonBackReference(value = "idCed-phdEtd")
    private List<PhdEtudiant> phdEtudiants;
    @OneToMany(mappedBy = "idCed")
    @JsonBackReference(value = "ced-equipes")
    private  List<Equipe> equipes;

}
