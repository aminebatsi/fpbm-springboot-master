package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class TypeJury {
    @Id
    private int id;

    @OneToMany(mappedBy = "typeJury")
    @JsonBackReference(value = "typedeJury")
    private Collection<Jury> jury;


}
