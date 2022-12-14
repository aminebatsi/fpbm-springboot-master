package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Filiere;
import ma.fpbm.fpbmback.beans.Section;

import java.util.List;
import java.util.Optional;

public interface SectionService {
    List<Section> findAll();
    Optional<Section> findById(Long id);
    Section save (Section section);
    String deleteByCode (Long code);
    Section update (Section section);
}
