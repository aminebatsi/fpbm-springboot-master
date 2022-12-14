package ma.fpbm.fpbmback.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
    * Cette class a pour but de representer le genre de la responsabilité d'un prof vers un module
    * Il y'a acuellement 7 type dans l'application
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDeResponsabilite {
    @Id
    private Long id;

    private String code;

    private String name;

}
