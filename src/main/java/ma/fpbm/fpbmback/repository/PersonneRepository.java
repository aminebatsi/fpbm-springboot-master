package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
