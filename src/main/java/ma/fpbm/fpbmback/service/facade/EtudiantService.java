package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Etudiant;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {
    List<Etudiant> getAll();
    Optional<Etudiant> findById(Long id);
    Etudiant save(Etudiant etudiant);
    String deletebyId(Long id);
    String update(Etudiant etudiant);

    Page<Etudiant> getByPage(int page, int size);
}
