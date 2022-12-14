package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.ExamenHasProfesseurHasModuleHasEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenHasProfesseurHasModuleHasEtudiantRepository extends JpaRepository<ExamenHasProfesseurHasModuleHasEtudiant,Long> {
}
