package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.ProfesseurHasModuleHasEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesseurModuleEtudiantRepository extends JpaRepository<ProfesseurHasModuleHasEtudiant,Long> {

}
