package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.ProfesseurHasModule;
import ma.fpbm.fpbmback.beans.ProfesseurHasModuleHasEtudiant;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProfesseurModuleEtudiantService {
    public List<ProfesseurHasModuleHasEtudiant> getAll();

    public int countEffectif(String nomModule , String section);

    Page<ProfesseurHasModuleHasEtudiant> getByPage(int page, int size);

    ProfesseurHasModuleHasEtudiant save(ProfesseurHasModuleHasEtudiant professeurHasModuleHasEtudiant);

    String deleteById(Long id);

    ProfesseurHasModuleHasEtudiant update(ProfesseurHasModuleHasEtudiant professeurHasModuleEtudiant);
}
