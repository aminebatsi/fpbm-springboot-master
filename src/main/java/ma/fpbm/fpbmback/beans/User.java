package ma.fpbm.fpbmback.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    private Long id;

    private String code;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean hadVerifyEmail;

    private String avatar;
}
