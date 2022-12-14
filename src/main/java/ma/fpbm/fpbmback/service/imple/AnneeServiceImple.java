package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Annee;
import ma.fpbm.fpbmback.repository.AnneeRepository;
import ma.fpbm.fpbmback.service.facade.AnneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnneeServiceImple implements AnneeService {
    @Autowired
    private AnneeRepository anneeRepository;

    @Override
    public List<Annee> findAll() {
        return anneeRepository.findAll();
    }

    @Override
    public Optional<Annee> findById(Long id) {
        return anneeRepository.findById(id);
    }

    public Annee save(Annee annee) {
        // validate the input data :
            return anneeRepository.save(annee);
    }

    @Override
    public String deleteByCode(Long id) {
       anneeRepository.deleteById(id);
       return "Deleted";
    }

    @Override
    public Annee update(Annee annee) {
        return anneeRepository.save(annee);
    }

}
