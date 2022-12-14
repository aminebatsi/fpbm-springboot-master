package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
