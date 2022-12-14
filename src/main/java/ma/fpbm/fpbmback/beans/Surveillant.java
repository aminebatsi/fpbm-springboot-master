package ma.fpbm.fpbmback.beans;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Surveillant {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_surveillant;


    @ManyToOne
    private Professeur profSurveillant;


    @ManyToOne
    private Examen id_examen;

}
