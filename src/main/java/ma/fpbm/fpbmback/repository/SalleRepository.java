package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.Examen;
import ma.fpbm.fpbmback.beans.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Long> {

}
