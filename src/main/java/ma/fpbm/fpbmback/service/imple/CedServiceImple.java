package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Ced;
import ma.fpbm.fpbmback.repository.CedRepository;
import ma.fpbm.fpbmback.service.facade.CedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CedServiceImple implements CedService {
    @Autowired
    private CedRepository cedRepository;

    @Override
    public List<Ced> findAll() {
        return cedRepository.findAll();
    }

    @Override
    public Optional<Ced> findById(Long id) {
        return cedRepository.findById(id);
    }

    public Ced save(Ced ced) {
        // validate the input data :
            return cedRepository.save(ced);
    }

    @Override
    public String deleteByCode(Long id) {
       cedRepository.deleteById(id);
       return "Deleted";
    }

    @Override
    public Ced update(Ced annee) {
        return cedRepository.save(annee);
    }
}
