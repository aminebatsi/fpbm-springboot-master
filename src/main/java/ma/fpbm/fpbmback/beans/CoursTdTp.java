package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursTdTp {
    @Id
    @Column(name = "id_courstptp")
    private Long id;


    // reference set à la comparaison
    private String code;

    @OneToMany(mappedBy = "coursTdTp")
    @JsonBackReference(value = "coursTdTp")
    private List<ProfesseurHasModule> professeurHasModules;

    private String typeDeResponsabilite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CoursTdTp coursTdTp = (CoursTdTp) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
