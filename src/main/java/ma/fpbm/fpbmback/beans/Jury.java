package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Jury {
    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //relation Many To One avec la table professeur
    @ManyToOne

    private Professeur professeur;

    //relation Many To One avec la table soutenance
    @ManyToOne


    private Soutenance jury_soutenance;

    //relation Many To One avec la table Type jury
    @ManyToOne

    private TypeJury typeJury;


}
