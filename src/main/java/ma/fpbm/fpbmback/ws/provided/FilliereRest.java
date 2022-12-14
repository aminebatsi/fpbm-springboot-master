package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.Departement;
import ma.fpbm.fpbmback.beans.Filiere;
import ma.fpbm.fpbmback.service.facade.DepartementService;
import ma.fpbm.fpbmback.service.imple.FilliereServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("filliere")
public class FilliereRest {
    @Autowired
    private FilliereServiceImple filliereServiceImple;

    @GetMapping
    public List<Filiere> findAll() {
        return filliereServiceImple.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Filiere> findById(@PathVariable Long id){
        return filliereServiceImple.findById(id);
    }
    @PostMapping
    public Filiere save(@RequestBody Filiere filiere) {
        return filliereServiceImple.save(filiere);
    }

    @DeleteMapping("/deletecode/{code}")
    public int deleteByCode(@PathVariable String code) {
        return filliereServiceImple.deleteByCode(code);
    }

    @PutMapping
    public Filiere update(@RequestBody Filiere filiere) {
        return filliereServiceImple.update(filiere);
    }
}
