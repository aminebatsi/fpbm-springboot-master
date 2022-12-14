package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.ExamenHasProfesseurHasModuleHasEtudiant;
import ma.fpbm.fpbmback.beans.ProfesseurHasModule;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ExamenHasProfesseurHasModuleHasEtudiantImpl {
    public List<ExamenHasProfesseurHasModuleHasEtudiant> getAll();
    Page<ExamenHasProfesseurHasModuleHasEtudiant> findAll(int page, int size);
    Optional<ExamenHasProfesseurHasModuleHasEtudiant> findById(Long id);
    ExamenHasProfesseurHasModuleHasEtudiant save(ExamenHasProfesseurHasModuleHasEtudiant professeurHasModule);
    void deleteByCode (long id);
    ExamenHasProfesseurHasModuleHasEtudiant update (ExamenHasProfesseurHasModuleHasEtudiant professeurHasModule);

    int countEffectif(int idExament);
}
