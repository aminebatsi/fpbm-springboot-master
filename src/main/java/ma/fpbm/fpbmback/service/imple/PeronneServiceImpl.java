package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Personne;
import ma.fpbm.fpbmback.repository.PersonneRepository;
import ma.fpbm.fpbmback.service.facade.IPersonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeronneServiceImpl implements IPersonne {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public List<Personne> getAllPersonne(){
        return personneRepository.findAll();
    };
}
