package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Section {
    @Id
    @Column(name = "sectionId")

    private Long id;

    private String name;

    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
    @JsonBackReference(value = "prof/mod")
    private List<ProfesseurHasModule> professeurHasModules;

}
