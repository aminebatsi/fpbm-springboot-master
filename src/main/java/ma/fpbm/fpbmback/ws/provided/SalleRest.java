package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.Salle;
import ma.fpbm.fpbmback.repository.SalleRepository;
import ma.fpbm.fpbmback.service.imple.SalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping( "salle")
public class SalleRest {
    @Autowired
    private SalleServiceImpl salleService;

    @Autowired
    private SalleRepository salleRepository;

    @GetMapping("/{idSalle}")
    public Salle getSalleById(@PathVariable Long idSalle){
        return salleService.getSalleById(idSalle);
    }

    @GetMapping
    public List<Salle> getAllSalle(){
        return salleService.getAllSalle();
    }

    @PutMapping("/{idSalle}")
    public Salle updateSalle(@RequestBody Salle salle,@PathVariable Long idSalle){
        Salle tpUp = salleRepository.findById(idSalle).orElseThrow();
        tpUp.setName(salle.getName());
        tpUp.setCode(salle.getCode());
        tpUp.setCapacity(salle.getCapacity());
        tpUp.setCapacityExam(salle.getCapacityExam());
        tpUp.setNombreDeSurveillant(salle.getNombreDeSurveillant());
        return salleRepository.save(tpUp);
    }

    @PostMapping
    public Salle saveSalle(@RequestBody Salle salle){
        return salleService.saveSalle(salle);
    }

    @DeleteMapping("/{idSalle}")
    public String deleteSalle(@PathVariable Long idSalle){
        return salleService.deleteSalle(idSalle);
    }
}
