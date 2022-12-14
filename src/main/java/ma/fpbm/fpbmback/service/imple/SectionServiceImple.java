package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Filiere;
import ma.fpbm.fpbmback.beans.Section;
import ma.fpbm.fpbmback.repository.FilliereRepository;
import ma.fpbm.fpbmback.repository.SectionRepository;
import ma.fpbm.fpbmback.service.facade.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImple implements SectionService {
    @Autowired
    private SectionRepository sectionRepository;


    @Override
    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    @Override
    public Optional<Section> findById(Long id) {
        return sectionRepository.findById(id);
    }

    @Override
    public Section save(Section section) {
        // validate the input data :
        if (section.getName().isEmpty())
            return null;

        // validate the DB data;

        return this.sectionRepository.save(section);
    }

    @Override
    public String deleteByCode(Long code) {
        sectionRepository.deleteById(code);
        return "Deleted Section with the id : " + code;
    }

    @Override
    public Section update(Section section) {
        return null;
    }
}
