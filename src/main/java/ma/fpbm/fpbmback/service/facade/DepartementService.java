package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Departement;

import java.util.List;
import java.util.Optional;

public interface DepartementService {
    List<Departement> findAll();
    Optional<Departement> findById(Long id);
    Departement save (Departement departement);
    int deleteByCode (String code);
    Departement update (Departement departement);
}
