package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.Surveillant;
import ma.fpbm.fpbmback.service.imple.SurveillantServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("surveillant")
public class SurveillantRest {
    @Autowired
    private SurveillantServiceImple surveillantService;

    @GetMapping
    public List<Surveillant> findAll() {
        return surveillantService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Surveillant> findById(@PathVariable Long id) {
        return surveillantService.findById(id);
    }

    @PostMapping
    public Surveillant save(@RequestBody Surveillant surveillant) {
        return surveillantService.save(surveillant);
    }

    @DeleteMapping("/deletecode/{code}")
    public String deleteByCode(@PathVariable Long code) {
        return surveillantService.deleteByCode(code);
    }

    @PutMapping
    public Surveillant update(@RequestBody Surveillant surveillant) {
        return surveillantService.update(surveillant);
    }
}
