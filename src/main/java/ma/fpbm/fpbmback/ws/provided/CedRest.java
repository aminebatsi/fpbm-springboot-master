package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.Ced;
import ma.fpbm.fpbmback.service.imple.CedServiceImple;
import ma.fpbm.fpbmback.service.imple.CedServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ced")
public class CedRest {
    @Autowired
    private CedServiceImple cedService;

    @GetMapping
    public List<Ced> findAll() {
        return cedService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Ced> findById(@PathVariable Long id){
        return cedService.findById(id);
    }
    @PostMapping(consumes = {"application/json"})
    public Ced save(@RequestBody Ced ced) {
        return cedService.save(ced);
    }

    @DeleteMapping("/deletecode/{code}")
    public String deleteByCode(@PathVariable Long code) {
        return cedService.deleteByCode(code);
    }

    @PutMapping("/{id}")
    public Ced update(@PathVariable Long id, @RequestBody Ced ced) {
        ced.setIdCed(id);
        return cedService.update(ced);
    }
}
