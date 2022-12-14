package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Examen;
import ma.fpbm.fpbmback.beans.ProfesseurHasModule;
import ma.fpbm.fpbmback.beans.Salle;
import ma.fpbm.fpbmback.repository.ExamenRepository;
import ma.fpbm.fpbmback.repository.ProfesseurModuleRepository;
import ma.fpbm.fpbmback.repository.SalleRepository;
import ma.fpbm.fpbmback.service.facade.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImple implements ExamenService {
    @Autowired
    private ExamenRepository examenRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private ProfesseurModuleRepository pmr;

    @Override
    public List<Examen> findAll() {
        return examenRepository.findAll(Sort.by(Sort.Direction.ASC,"jour"));
    }

    @Override
    public Page<Examen> findByPage(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return examenRepository.findAll(paging);
    }

    @Override
    public Examen save(Examen examen) {
        if (foreignSalle(examen).isEmpty() || foreignPHM(examen).isEmpty()) {
            System.out.println("Salle or ProfesseurHasModule does not exist");
            return null;
        }
        return examenRepository.save(examen);
    }

    @Override
    public String deleteById(Long code) {
        examenRepository.deleteById(code);
        return "Deleted";
    }

    @Override
    public Examen update(Examen examen) {
        if (foreignSalle(examen).isEmpty() || foreignPHM(examen).isEmpty()) {
            System.out.println("Salle or ProfesseurHasModule does not exist");
            return null;
        }
        return examenRepository.save(examen);
    }

    @Override
    public List<Object[]> query(){
        return examenRepository.query();
    }

    private Optional<Salle> foreignSalle (Examen examen){
        return this.salleRepository.findById(examen.getSalle().getId());
    }
    private Optional<ProfesseurHasModule> foreignPHM(Examen examen){
        return this.pmr.findById(examen.getProfHasModule().getId());
    }

}