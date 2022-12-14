package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    Departement findByCode(String code);
    int deleteByCode(String code);

}
