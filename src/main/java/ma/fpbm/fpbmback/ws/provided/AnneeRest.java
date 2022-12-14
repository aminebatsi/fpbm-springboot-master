package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.Annee;
import ma.fpbm.fpbmback.beans.Annee;
import ma.fpbm.fpbmback.service.imple.AnneeServiceImple;
import ma.fpbm.fpbmback.service.imple.FilliereServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("annee")
public class AnneeRest {
    @Autowired
    private AnneeServiceImple anneeServiceImple;

    @GetMapping
    public List<Annee> findAll() {
        return anneeServiceImple.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Annee> findById(@PathVariable Long id){
        return anneeServiceImple.findById(id);
    }
    @PostMapping
    public Annee save(@RequestBody Annee annee) {
        return anneeServiceImple.save(annee);
    }

    @DeleteMapping("/deletecode/{code}")
    public String deleteByCode(@PathVariable Long code) {
        return anneeServiceImple.deleteByCode(code);
    }

    @PutMapping
    public Annee update(@RequestBody Annee annee) {
        return anneeServiceImple.update(annee);
    }
}
