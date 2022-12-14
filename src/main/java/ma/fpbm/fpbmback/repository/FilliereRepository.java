package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.Departement;
import ma.fpbm.fpbmback.beans.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilliereRepository extends JpaRepository<Filiere,Long> {
    Filiere findByCode(String code);
    int deleteByCode(String code);
}
