package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Equipe;
import ma.fpbm.fpbmback.repository.EquipeRepository;
import ma.fpbm.fpbmback.service.facade.IEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EquipeServiceImp implements IEquipe {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public Equipe saveEquipe(Equipe equipe){
        System.out.println("Saving Equipe...");
        return equipeRepository.save(equipe);
    }

    @Override
    public List<Equipe> getAllEquipes(){

        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipeById(Long idEquipe){
        return equipeRepository.findById(idEquipe).orElseThrow(() -> new RuntimeException("Departement not found"));
    }

    @Override
    public Equipe updateEquipe(Equipe equipe){
        return equipeRepository.save(equipe);
    }

    @Override
    public String deleteEquipe(Long equipeId){
        try {
            equipeRepository.deleteById(equipeId);
            return "Departement deleted";
        }catch (Exception e){
            System.out.println(e);
        }
        return "Error while deleting Equipe";
    }
}
