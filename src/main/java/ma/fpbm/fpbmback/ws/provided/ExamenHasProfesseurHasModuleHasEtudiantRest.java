package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.ExamenHasProfesseurHasModuleHasEtudiant;
import ma.fpbm.fpbmback.service.imple.ExamenHasProfesseurHasModuleHasEtudiantImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examprofmodetud")
public class ExamenHasProfesseurHasModuleHasEtudiantRest {
    @Autowired
    private ExamenHasProfesseurHasModuleHasEtudiantImple examenHasProfesseurHasModuleHasEtudiantImple;

    //used in generate PV
    @GetMapping("/every")
    public List<ExamenHasProfesseurHasModuleHasEtudiant> getAll(){
        return examenHasProfesseurHasModuleHasEtudiantImple.getAll();
    }

    @GetMapping
    public Page<ExamenHasProfesseurHasModuleHasEtudiant> findAll(@RequestParam(name="page",defaultValue = "0") int page,
                                             @RequestParam(name="size",defaultValue = "5") int size) {
        return examenHasProfesseurHasModuleHasEtudiantImple.findAll(page, size);
    }
    @GetMapping("/{id}")
    public Optional<ExamenHasProfesseurHasModuleHasEtudiant> findById(@PathVariable Long id){
        return examenHasProfesseurHasModuleHasEtudiantImple.findById(id);
    }

    @PostMapping
    public ExamenHasProfesseurHasModuleHasEtudiant save(@RequestBody ExamenHasProfesseurHasModuleHasEtudiant profMod) {
        return examenHasProfesseurHasModuleHasEtudiantImple.save(profMod);
    }

    @DeleteMapping("/deletecode/{code}")
    public String deleteByCode(@PathVariable Long code) {
        examenHasProfesseurHasModuleHasEtudiantImple.deleteByCode(code);
        return "Record Deleted";
    }

    @PutMapping("/{id}")
    public ExamenHasProfesseurHasModuleHasEtudiant update(@PathVariable Long id, @RequestBody ExamenHasProfesseurHasModuleHasEtudiant profMod) {
        profMod.setId(id);
        return examenHasProfesseurHasModuleHasEtudiantImple.update(profMod);
    }

    @GetMapping("/count/{idExamen}")
    public int countEffectif(@PathVariable int idExamen){
        return examenHasProfesseurHasModuleHasEtudiantImple.countEffectif(idExamen);
    }
}
