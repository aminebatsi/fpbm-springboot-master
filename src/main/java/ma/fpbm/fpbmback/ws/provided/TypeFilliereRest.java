package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.TypeFiliere;
import ma.fpbm.fpbmback.service.imple.TypeFilliereServiveImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TypeFilliere")
public class TypeFilliereRest {
    @Autowired
    private TypeFilliereServiveImpl typeFilliereServive;

    @GetMapping("/")
    public List<TypeFiliere> getAllEquipe(){
        return typeFilliereServive.getAllTpFilliere();
    }

    @GetMapping("/{idTpFlr}")
    public TypeFiliere getEquipeById(@PathVariable Long idTpFlr){
        return typeFilliereServive.getTypeFillireById(idTpFlr);
    }

    @PostMapping
    public TypeFiliere saveEquipe(@RequestBody TypeFiliere typeFiliere){
        return typeFilliereServive.saveTpFilliere(typeFiliere);
    }

    @PutMapping("/{idTpFlr}")
    public TypeFiliere updateEquipe(@PathVariable Long idTpFlr,@RequestBody TypeFiliere typeFiliere){
        TypeFiliere toUp = typeFilliereServive.findById(idTpFlr);
        toUp.setCode(typeFiliere.getCode());
        toUp.setName(typeFiliere.getName());
        return typeFilliereServive.saveTpFilliere(typeFiliere);
    }

    @DeleteMapping("/{idTpFlr}")
    public String deleteEquipe(@PathVariable Long idTpFlr){
        return typeFilliereServive.deleteTpFilliere(idTpFlr);
    }
}
