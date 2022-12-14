package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Annee;

import java.util.List;
import java.util.Optional;

public interface AnneeService {
    List<Annee> findAll();
    Optional<Annee> findById(Long id);
    Annee save (Annee Annee);
    String deleteByCode (Long id);
    Annee update (Annee Annee);
}
