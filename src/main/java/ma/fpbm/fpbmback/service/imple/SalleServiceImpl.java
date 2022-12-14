package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Salle;
import ma.fpbm.fpbmback.repository.SalleRepository;
import ma.fpbm.fpbmback.service.facade.ISalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements ISalle {
    @Autowired
    private SalleRepository salleRepository;
    @Override
    public Salle getSalleById(Long idSalle){
        return salleRepository.findById(idSalle).orElseThrow(() -> new RuntimeException("Salle not found"));
    }

    @Override
    public List<Salle> getAllSalle() {
        return salleRepository.findAll();
    }

    @Override
    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public Salle updateSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public String deleteSalle(Long idSalle) {
        try {
            salleRepository.deleteById(idSalle);
            return "Salle deleted";
        }catch (Exception e){
            System.out.println(e);
        }
        return "Error while deleting Salle";
    }
}
