package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Filiere;

import java.util.List;
import java.util.Optional;

public interface IFilliereService {
    List<Filiere> findAll();
    Optional<Filiere> findById(Long id);
    Filiere save (Filiere filiere);
    int deleteByCode (String code);
    Filiere update (Filiere filiere);
}
