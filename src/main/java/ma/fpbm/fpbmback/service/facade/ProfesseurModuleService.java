package ma.fpbm.fpbmback.service.facade;


import ma.fpbm.fpbmback.beans.ProfesseurHasModule;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProfesseurModuleService {
    Page<ProfesseurHasModule> findAll(int page, int size);
    List<ProfesseurHasModule> findAll();
    Optional<ProfesseurHasModule> findById(Long id);
    ProfesseurHasModule save (ProfesseurHasModule professeurHasModule);
    void deleteByCode (long id);
    ProfesseurHasModule update (ProfesseurHasModule professeurHasModule);
}
