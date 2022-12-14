package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.ProfesseurHasModule;
import ma.fpbm.fpbmback.service.facade.ProfesseurModuleService;
import ma.fpbm.fpbmback.service.imple.ProfesseurModuleServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("professeurModule")
public class ProfessurModuleRest {
    @Autowired
    private ProfesseurModuleServiceImple professurModuleService;

    @GetMapping
    public Page<ProfesseurHasModule> findAll(@RequestParam(name="page",defaultValue = "0") int page,
                                             @RequestParam(name="size",defaultValue = "5") int size) {
        return professurModuleService.findAll(page, size);
    }
    @GetMapping("/all")
    public List<ProfesseurHasModule> findAll(){
        return professurModuleService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<ProfesseurHasModule> findById(@PathVariable Long id){
        return professurModuleService.findById(id);
    }
    @PostMapping
    public ProfesseurHasModule save(@RequestBody ProfesseurHasModule profMod) {
        return professurModuleService.save(profMod);
    }

    @DeleteMapping("/deletecode/{code}")
    public String deleteByCode(@PathVariable Long code) {
        professurModuleService.deleteByCode(code);
        return "Record Deleted";
    }

    @PutMapping("/{id}")
    public ProfesseurHasModule update(@PathVariable Long id, @RequestBody ProfesseurHasModule profMod) {
        profMod.setId(id);
        return professurModuleService.update(profMod);
    }
}
