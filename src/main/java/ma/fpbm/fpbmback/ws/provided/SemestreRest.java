package ma.fpbm.fpbmback.ws.provided;


import ma.fpbm.fpbmback.beans.Semestre;
import ma.fpbm.fpbmback.service.imple.SemestreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("semestre")
public class SemestreRest {

    @Autowired
    private SemestreServiceImpl semestreService;

    @GetMapping("/{idSemestre}")
    public Semestre getSemestreById(@PathVariable Long idSemestre){
        return semestreService.getSemestreById(idSemestre);
    }

    @GetMapping
    public List<Semestre> getAllSemestre(){
        return semestreService.getAllSemestre();
    }

    @PutMapping
    public Semestre updateSemestre(@RequestBody Semestre semestre){
        return semestreService.updateSemestre(semestre);
    }

    @PostMapping
    public Semestre saveSemestre(@RequestBody Semestre semestre){
        return semestreService.saveSemestre(semestre);
    }

    @DeleteMapping("/{idSemestre}")
    public String deleteSemestre(@PathVariable Long idSemestre){
        return semestreService.deleteSemestre(idSemestre);
    }



}