package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Filiere;
import ma.fpbm.fpbmback.beans.Semestre;
import ma.fpbm.fpbmback.repository.FilliereRepository;
import ma.fpbm.fpbmback.repository.SemestreRepository;
import ma.fpbm.fpbmback.service.facade.ISemestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreServiceImpl implements ISemestre {
    @Autowired
    private SemestreRepository semestreRepository;
    @Autowired
    private FilliereRepository filliereRepository;
    @Override
    public Semestre getSemestreById(Long idSemestre){
        return semestreRepository.findById(idSemestre).orElseThrow(() -> new RuntimeException("Semestre not found"));
    }

    @Override
    public List<Semestre> getAllSemestre() {
        return semestreRepository.findAll();
    }

    @Override
    public Semestre saveSemestre(Semestre semestre) {
        if(fillereById(semestre).isEmpty()){
            System.out.println("Foreign key error");
            return null;
        }
        return semestreRepository.save(semestre);
    }

    @Override
    public Semestre updateSemestre(Semestre semestre) {
        if(fillereById(semestre).isEmpty()){
            System.out.println("Foreign key error");
            return null;
        }
        return semestreRepository.save(semestre);
    }

    @Override
    public String deleteSemestre(Long idSemestre) {
        try {
            semestreRepository.deleteById(idSemestre);
            return "Semestre deleted";
        }catch (Exception e){
            System.out.println(e);
        }
        return "Error while deleting Semestre";
    }
    private Optional<Filiere> fillereById(Semestre semestre){
        return this.filliereRepository.findById(semestre.getFillier_id().getId());
    }
}
