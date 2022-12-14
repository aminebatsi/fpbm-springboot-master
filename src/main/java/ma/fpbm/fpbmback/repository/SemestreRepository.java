package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre,Long> {

}
