package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Surveillant;

import java.util.List;
import java.util.Optional;

public interface SurveillantService {
    List<Surveillant> findAll();
    Optional<Surveillant> findById(Long id);
    Surveillant save (Surveillant surveillant);
    String deleteByCode (Long id);
    Surveillant update (Surveillant surveillant);
}
