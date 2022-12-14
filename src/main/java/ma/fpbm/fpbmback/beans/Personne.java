package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne extends User {
    @ToString.Exclude
    private String cin;
    @ToString.Exclude
    private String cne;
    @ToString.Exclude
    private String nom;
    @ToString.Exclude
    private String prenom;
    @ToString.Exclude
    private String adress;
    @ToString.Exclude
    private String dateNaissance;

}