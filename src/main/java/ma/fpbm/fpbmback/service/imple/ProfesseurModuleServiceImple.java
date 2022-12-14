package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.*;
import ma.fpbm.fpbmback.beans.Module;
import ma.fpbm.fpbmback.repository.*;
import ma.fpbm.fpbmback.service.facade.ProfesseurModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurModuleServiceImple implements ProfesseurModuleService {
    @Autowired
    private ProfesseurModuleRepository professeurModuleRepository;
    @Autowired
    private ProfesseurRepository professeurRepository;
    @Autowired
    private AnneeRepository anneeRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private CoursTdTpRepository coursTdTpRepository;
    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public Page<ProfesseurHasModule> findAll(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        return professeurModuleRepository.findAll(paging);
    }

    @Override
    public List<ProfesseurHasModule> findAll() {
        return professeurModuleRepository.findAll();
    }

    @Override
    public Optional<ProfesseurHasModule> findById(Long id) {
        return professeurModuleRepository.findById(id);
    }

    @Override
    public ProfesseurHasModule save(ProfesseurHasModule professeurHasModule) {
        if(profById(professeurHasModule).isEmpty() || anneeById(professeurHasModule).isEmpty() ||
                moduleById(professeurHasModule).isEmpty() || coursById(professeurHasModule).isEmpty()
                || sectionById(professeurHasModule).isEmpty()) {
            System.out.println("One of the foreign key does not exist");
            return null;
        }
        return this.professeurModuleRepository.save(professeurHasModule);
    }

    @Override
    public void deleteByCode(long code) {
        professeurModuleRepository.deleteById(code);
    }

    @Override
    public ProfesseurHasModule update(ProfesseurHasModule professeurHasModule) {
        if(profById(professeurHasModule).isEmpty() || anneeById(professeurHasModule).isEmpty() ||
               moduleById(professeurHasModule).isEmpty() || coursById(professeurHasModule).isEmpty()
               || sectionById(professeurHasModule).isEmpty()) {
            System.out.println("One of the foreign key does not exist");
            return null;
        }

        return this.professeurModuleRepository.save(professeurHasModule);
    }

    private Optional<Professeur> profById(ProfesseurHasModule professeurHasModule) {
        return this.professeurRepository.findById(professeurHasModule.getProfesseur().getId());
    }
    private Optional<Annee> anneeById(ProfesseurHasModule professeurHasModule) {
        return this.anneeRepository.findById(professeurHasModule.getAnnee().getId());
    }
    private Optional<Module> moduleById(ProfesseurHasModule professeurHasModule) {
        return this.moduleRepository.findById(professeurHasModule.getModule().getId());
    }
    private Optional<CoursTdTp> coursById(ProfesseurHasModule professeurHasModule) {
        return this.coursTdTpRepository.findById(professeurHasModule.getCoursTdTp().getId());
    }
    private Optional<Section> sectionById(ProfesseurHasModule professeurHasModule) {
        return this.sectionRepository.findById(professeurHasModule.getSection().getId());
    }
}
