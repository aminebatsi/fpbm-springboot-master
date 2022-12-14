package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.Examen;
import ma.fpbm.fpbmback.beans.Section;
import ma.fpbm.fpbmback.service.imple.ExamenServiceImple;
import ma.fpbm.fpbmback.service.imple.SectionServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("section")
public class SectionRest {
    @Autowired
    private SectionServiceImple sectionServiceImple;

    @GetMapping
    public List<Section> findAll() {
        return sectionServiceImple.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Section> findById(@PathVariable Long id){
        return sectionServiceImple.findById(id);
    }
    @PostMapping
    public Section save(@RequestBody Section section) {
        return sectionServiceImple.save(section);
    }

    @DeleteMapping("/deletecode/{code}")
    public String deleteByCode(@PathVariable Long code) {
        return sectionServiceImple.deleteByCode(code);
    }

    @PutMapping
    public Section update(@RequestBody Section section) {
        return sectionServiceImple.update(section);
    }
}
