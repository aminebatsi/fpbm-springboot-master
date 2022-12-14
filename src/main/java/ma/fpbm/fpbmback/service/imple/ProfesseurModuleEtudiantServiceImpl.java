package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Etudiant;
import ma.fpbm.fpbmback.beans.ProfesseurHasModule;
import ma.fpbm.fpbmback.beans.ProfesseurHasModuleHasEtudiant;
import ma.fpbm.fpbmback.repository.EtudiantRepository;
import ma.fpbm.fpbmback.repository.ProfesseurModuleEtudiantRepository;
import ma.fpbm.fpbmback.repository.ProfesseurModuleRepository;
import ma.fpbm.fpbmback.service.facade.ProfesseurModuleEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProfesseurModuleEtudiantServiceImpl implements ProfesseurModuleEtudiantService {

    @Autowired
    private ProfesseurModuleEtudiantRepository professeurModuleEtudiantRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ProfesseurModuleRepository professeurModuleRepository;
    @Override
    public List<ProfesseurHasModuleHasEtudiant> getAll(){
        return professeurModuleEtudiantRepository.findAll();
    }

    @Override
    public int countEffectif(String nomModule , String section){
        int countEff = 0;
        List<ProfesseurHasModuleHasEtudiant> list = professeurModuleEtudiantRepository.findAll();
        for(ProfesseurHasModuleHasEtudiant temp:list){
         if(nomModule.equals(temp.getProfesseurHasModule_id().getModule().getName()) && section.equals(temp.getProfesseurHasModule_id().getSection().getName())){
             countEff++;
         }
         System.out.println(temp.getProfesseurHasModule_id().getModule().getGroupes().getClass());
        }
        return countEff;
    }

    @Override
    public Page<ProfesseurHasModuleHasEtudiant> getByPage(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return professeurModuleEtudiantRepository.findAll(paging);
    }

    @Override
    public ProfesseurHasModuleHasEtudiant save(ProfesseurHasModuleHasEtudiant professeurHasModuleHasEtudiant) {
return professeurModuleEtudiantRepository.save(professeurHasModuleHasEtudiant)  ;  }

    @Override
    public String deleteById(Long id) {
        professeurModuleEtudiantRepository.deleteById(id);
        return "success";
    }

    @Override
    public ProfesseurHasModuleHasEtudiant update(ProfesseurHasModuleHasEtudiant professeurHasModuleEtudiant) {
        if(etdById(professeurHasModuleEtudiant).isEmpty() || profModById(professeurHasModuleEtudiant).isEmpty()){
            System.out.println(" Foreign Key does not exist");
            return null;
        }
        return professeurModuleEtudiantRepository.save(professeurHasModuleEtudiant);
    }

    private Optional<Etudiant> etdById(ProfesseurHasModuleHasEtudiant professeurHasModuleHasEtudiant){
        return this.etudiantRepository.findById(professeurHasModuleHasEtudiant.getIdEtudiant().getId());
    }
    private Optional<ProfesseurHasModule> profModById(ProfesseurHasModuleHasEtudiant professeurHasModuleHasEtudiant){
        return this.professeurModuleRepository.findById(professeurHasModuleHasEtudiant.getProfesseurHasModule_id().getId());
    }
}
