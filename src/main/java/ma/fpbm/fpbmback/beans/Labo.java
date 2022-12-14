package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Labo {
    @Id
    private int id;
    @ManyToOne

    private Ced ced;
}
