package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.Departement;
import ma.fpbm.fpbmback.service.facade.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("departement")
public class DepartementRest {
    @Autowired
    private DepartementService departementService;
    @GetMapping
    public List<Departement> findAll() {
        return departementService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Departement> findById(@PathVariable Long id){
        return departementService.findById(id);
    }
    @PostMapping
    public Departement save(@RequestBody Departement departement) {
        return departementService.save(departement);
    }

    @DeleteMapping("/deletecode/{code}")
    public int deleteByCode(@PathVariable String code) {
        return departementService.deleteByCode(code);
    }

    @PutMapping
    public Departement update(@RequestBody Departement departement)  {
        return departementService.update(departement);
    }
}
