package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Surveillant;
import ma.fpbm.fpbmback.repository.SurveillantRepository;
import ma.fpbm.fpbmback.service.facade.SurveillantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveillantServiceImple implements SurveillantService {
    @Autowired
    private SurveillantRepository surveillantRepo;

    @Override
    public List<Surveillant> findAll() {
        return surveillantRepo.findAll();
    }

    @Override
    public Optional<Surveillant> findById(Long id) {
        return surveillantRepo.findById(id);
    }

    public Surveillant save(Surveillant ced) {
        // validate the input data :
            return surveillantRepo.save(ced);
    }

    @Override
    public String deleteByCode(Long id) {
       surveillantRepo.deleteById(id);
       return "Deleted";
    }

    @Override
    public Surveillant update(Surveillant annee) {
        return surveillantRepo.save(annee);
    }
}
