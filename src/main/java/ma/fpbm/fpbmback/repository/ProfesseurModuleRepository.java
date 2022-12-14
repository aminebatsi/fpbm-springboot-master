package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.ProfesseurHasModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurModuleRepository extends JpaRepository<ProfesseurHasModule, Long> {
}
