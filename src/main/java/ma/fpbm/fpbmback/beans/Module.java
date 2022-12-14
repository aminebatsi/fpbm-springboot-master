package ma.fpbm.fpbmback.beans;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @Column(name = "Module_id")
    private Long id;
    private String codeModule;
    private String groupes;
    private  String name;
    @ManyToOne
    private Semestre semestre;
    @OneToMany(mappedBy = "module")
    @JsonBackReference(value = "prof")
    private Collection<ProfesseurHasModule> professeurHasModules;


}
