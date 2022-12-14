package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity @Data @ToString
@NoArgsConstructor @AllArgsConstructor
public class Etudiant extends Personne{

    @ManyToOne

    private Filiere idfiliere;

    @OneToMany(mappedBy = "idEtudiant")
    @JsonBackReference(value = "profhas_module_has_etudiant")
    private Collection<ProfesseurHasModuleHasEtudiant> professeurHasModuleHasEtudiants;

    /*
    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL,mappedBy="moduleEtud")
    private Collection<Module> modules;*/



    
}