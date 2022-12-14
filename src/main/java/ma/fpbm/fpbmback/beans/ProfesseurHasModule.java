package ma.fpbm.fpbmback.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "professeur_has_module")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfesseurHasModule {
    @Id
    @Column(name = "profModId")

    private Long id;
    @ManyToOne

    private Annee annee;
    @ManyToOne

    private Professeur professeur;
    @ManyToOne

    private Module module;
    @ManyToOne

    private CoursTdTp coursTdTp;
    @ManyToOne
    private Section section;

}
