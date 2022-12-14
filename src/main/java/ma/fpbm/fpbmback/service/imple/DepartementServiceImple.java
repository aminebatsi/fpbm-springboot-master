package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Departement;
import ma.fpbm.fpbmback.repository.DepartementRepository;
import ma.fpbm.fpbmback.service.facade.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceImple implements DepartementService {

    @Autowired
    private DepartementRepository departementRepository;


    @Override
    public List<Departement> findAll() {
        return departementRepository.findAll();
    }

    @Override
    public Optional<Departement> findById(Long id) {
        return departementRepository.findById(id);
    }

    @Override
    public Departement save(Departement departement) {
        // validate the input data :
        if (departement.getName().isEmpty())
            return null;

        // validate the DB data;

        departement.setCode(String.valueOf(departement.hashCode()));

        if (departementRepository.findByCode(departement.getCode()) == null){
            return this.departementRepository.save(departement);
        }
        return null;
    }

    @Override
    public int deleteByCode(String code) {
        return departementRepository.deleteByCode(code);
    }

    @Override
    public Departement update(Departement departement) {
        return null;
    }
}
