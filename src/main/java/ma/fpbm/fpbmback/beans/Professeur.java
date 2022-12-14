package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class Professeur extends Personne {

    private String grade;
    private String telephone;


    @JsonBackReference(value = "profFill")
    @OneToMany(mappedBy = "responsable", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Filiere> fillier;
    @JsonBackReference(value = "profandmod")
    @OneToMany(mappedBy = "professeur")

    private List<ProfesseurHasModule> professeurHasModules;

    @JsonBackReference(value = "profasjury")
    //relation avec la table jury
    @OneToMany(mappedBy = "professeur")
    private Collection<Jury> jury;

    @ManyToOne
    private LieuDeTravail idLieuTravail;


    @OneToMany(mappedBy = "profSurveillant")
    @JsonBackReference(value = "profassurv")
    private Collection<Surveillant> surveillants;

    @ManyToOne
    private Extern id_extern;

}
