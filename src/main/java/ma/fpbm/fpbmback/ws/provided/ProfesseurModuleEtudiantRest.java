package ma.fpbm.fpbmback.ws.provided;


import ma.fpbm.fpbmback.beans.ProfesseurHasModuleHasEtudiant;
import ma.fpbm.fpbmback.service.imple.ProfesseurModuleEtudiantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profmodetud")
public class ProfesseurModuleEtudiantRest {


    @Autowired
    private ProfesseurModuleEtudiantServiceImpl professeurModuleEtudiantService;

    @GetMapping("/all")
    public List<ProfesseurHasModuleHasEtudiant> getAll(){
        return professeurModuleEtudiantService.getAll();
    }
    @GetMapping
    public Page<ProfesseurHasModuleHasEtudiant> getByPage(@RequestParam(name = "page", defaultValue = "0") int page,
                                                          @RequestParam(name = "size", defaultValue = "5") int size){
        return professeurModuleEtudiantService.getByPage(page, size);
    }
    @PostMapping
    public ProfesseurHasModuleHasEtudiant save(@RequestBody ProfesseurHasModuleHasEtudiant professeurHasModuleHasEtudiant){
        return professeurModuleEtudiantService.save(professeurHasModuleHasEtudiant);
    }
    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id){
        return professeurModuleEtudiantService.deleteById(id);
    }
    @PutMapping("/{id}")
    public ProfesseurHasModuleHasEtudiant ProfesseurHasModule(@PathVariable Long id,
                               @RequestBody ProfesseurHasModuleHasEtudiant professeurHasModuleEtudiant){
        professeurHasModuleEtudiant.setId(id);
        return professeurModuleEtudiantService.update(professeurHasModuleEtudiant);
    }
    @GetMapping("/count")
    public int countEffectif(){
        return professeurModuleEtudiantService.countEffectif("M01:Analyse","section B");
    }
}
