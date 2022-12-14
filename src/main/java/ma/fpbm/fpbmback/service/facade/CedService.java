package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Ced;

import java.util.List;
import java.util.Optional;

public interface CedService {
    List<Ced> findAll();
    Optional<Ced> findById(Long id);
    Ced save (Ced ced);
    String deleteByCode (Long id);
    Ced update (Ced ced);
}
