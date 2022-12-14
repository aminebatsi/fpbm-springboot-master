package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.Etudiant;
import ma.fpbm.fpbmback.service.imple.EtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("etudiant")
public class EtudiantRest {
    @Autowired
    private EtudiantServiceImpl etudiantService;

    @GetMapping("/all")
    public List<Etudiant> getAll() {
        return etudiantService.getAll();
    }

    @GetMapping
    public Page<Etudiant> getByPage(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "5") int size) {
        return etudiantService.getByPage(page, size);
    }

    @GetMapping("/{id}")
    public Optional<Etudiant> findById(Long id) {
        return etudiantService.findById(id);
    }

    @PostMapping
    public Etudiant save(@RequestBody Etudiant etudiant) {
        return etudiantService.save(etudiant);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id,@RequestBody Etudiant etudiant) {
        etudiant.setId(id);
        return etudiantService.update(etudiant);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return etudiantService.deletebyId(id);
    }

}
