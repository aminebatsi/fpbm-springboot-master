package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Filiere;
import ma.fpbm.fpbmback.repository.FilliereRepository;
import ma.fpbm.fpbmback.service.facade.IFilliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilliereServiceImple implements IFilliereService {
    @Autowired
    private FilliereRepository filliereRepository;


    @Override
    public List<Filiere> findAll() {
        return filliereRepository.findAll();
    }

    @Override
    public Optional<Filiere> findById(Long id) {
        return filliereRepository.findById(id);
    }

    @Override
    public Filiere save(Filiere filiere) {
        // validate the input data :
        if (filiere.getName().isEmpty())
            return null;

        // validate the DB data;

        filiere.setCode(String.valueOf(filiere.hashCode()));

        if (filliereRepository.findByCode(filiere.getCode()) == null){
            return this.filliereRepository.save(filiere);
        }
        return null;
    }

    @Override
    public int deleteByCode(String code) {
        return filliereRepository.deleteByCode(code);
    }

    @Override
    public Filiere update(Filiere filiere) {
        return filliereRepository.save(filiere);
    }
}
