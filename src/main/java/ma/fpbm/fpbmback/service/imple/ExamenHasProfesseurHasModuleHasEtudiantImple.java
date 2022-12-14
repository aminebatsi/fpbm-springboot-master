package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.*;
import ma.fpbm.fpbmback.repository.ExamenHasProfesseurHasModuleHasEtudiantRepository;
import ma.fpbm.fpbmback.repository.ExamenRepository;
import ma.fpbm.fpbmback.repository.ProfesseurModuleEtudiantRepository;
import ma.fpbm.fpbmback.service.facade.ExamenHasProfesseurHasModuleHasEtudiantImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenHasProfesseurHasModuleHasEtudiantImple implements ExamenHasProfesseurHasModuleHasEtudiantImpl {
    @Autowired
    private ExamenHasProfesseurHasModuleHasEtudiantRepository examenHasProfesseurHasModuleHasEtudiantRepository;
    @Autowired
    private ExamenRepository examenRepository;
    @Autowired
    private ProfesseurModuleEtudiantRepository professeurHasEtudiantRepository;
    @Override
    public List<ExamenHasProfesseurHasModuleHasEtudiant> getAll(){
        return examenHasProfesseurHasModuleHasEtudiantRepository.findAll();
    }

    @Override
    public Page<ExamenHasProfesseurHasModuleHasEtudiant> findAll(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        return examenHasProfesseurHasModuleHasEtudiantRepository.findAll(paging);
    }

    @Override
    public Optional<ExamenHasProfesseurHasModuleHasEtudiant> findById(Long id) {
        return examenHasProfesseurHasModuleHasEtudiantRepository.findById(id);
    }

    @Override
    public ExamenHasProfesseurHasModuleHasEtudiant save(ExamenHasProfesseurHasModuleHasEtudiant examenHasProfesseurHasModuleHasEtudiant) {
        if (foreignExam(examenHasProfesseurHasModuleHasEtudiant).isEmpty() || foreignPHME(examenHasProfesseurHasModuleHasEtudiant).isEmpty()){
            System.out.println("ProfesseurHasModuleHasEtudiant or Examen does not exist");
            return null;
        }
        return examenHasProfesseurHasModuleHasEtudiantRepository.save(examenHasProfesseurHasModuleHasEtudiant);
    }

    @Override
    public void deleteByCode(long code) {
        examenHasProfesseurHasModuleHasEtudiantRepository.deleteById(code);
    }

    @Override
    public ExamenHasProfesseurHasModuleHasEtudiant update(ExamenHasProfesseurHasModuleHasEtudiant examenHasProfesseurHasModuleHasEtudiant) {
        if (foreignExam(examenHasProfesseurHasModuleHasEtudiant).isEmpty() || foreignPHME(examenHasProfesseurHasModuleHasEtudiant).isEmpty()){
            System.out.println("ProfesseurHasModuleHasEtudiant or Examen does not exist");
            return null;
        }
        return examenHasProfesseurHasModuleHasEtudiantRepository.save(examenHasProfesseurHasModuleHasEtudiant);
    }

    @Override
    public int countEffectif(int idExamen){
        int count = 0;
        List<ExamenHasProfesseurHasModuleHasEtudiant> temp = examenHasProfesseurHasModuleHasEtudiantRepository.findAll();
        for(ExamenHasProfesseurHasModuleHasEtudiant spec:temp){
            if (spec.getExamen().getId() == idExamen){
                count++;
            }
        }
        return count;
    }

    private Optional<Examen> foreignExam(ExamenHasProfesseurHasModuleHasEtudiant ehpm){
        return this.examenRepository.findById(ehpm.getExamen().getId());
    }
    private Optional<ProfesseurHasModuleHasEtudiant> foreignPHME(ExamenHasProfesseurHasModuleHasEtudiant ehpm){
        return  this.professeurHasEtudiantRepository.findById(ehpm.getProfesseurHasModuleHasEtudiant().getId());
    }
}

