package ma.fpbm.fpbmback.ws.provided;


import ma.fpbm.fpbmback.beans.Module;
import ma.fpbm.fpbmback.service.imple.ModuleServiceImpl;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "module")
public class ModuleRest {

    @Autowired
    private ModuleServiceImpl moduleServiceImple;

    @GetMapping
    public Page<Module> findAll(@RequestParam(name="page",defaultValue = "0") int page,
                                @RequestParam(name="size",defaultValue = "5") int size) {
        return moduleServiceImple.findAll(page,size);
    }
    @GetMapping("all")
    public List<Module> findAll() {
        return moduleServiceImple.findAll();
    }
    @GetMapping("/{id}")
    public Module findById(@PathVariable Long id){
        return moduleServiceImple.findById(id);
    }

    @PostMapping
    public Module save(@RequestBody Module module) {
        return moduleServiceImple.save(module);
    }

    @DeleteMapping("/deletecode/{code}")
    public String deleteByCode(@PathVariable Long code) {
        return moduleServiceImple.deleteById(code);
    }

    @PutMapping("/{id}")
    public Module update(@PathVariable Long id,@RequestBody Module module) {
        module.setId(id);
        return moduleServiceImple.update(module);
    }



}
