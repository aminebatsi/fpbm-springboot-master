package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.Extern;
import ma.fpbm.fpbmback.beans.LieuDeTravail;
import ma.fpbm.fpbmback.beans.Professeur;

import ma.fpbm.fpbmback.repository.ExternRepository;
import ma.fpbm.fpbmback.repository.LieuTravailRepository;
import ma.fpbm.fpbmback.repository.ProfesseurRepository;

import ma.fpbm.fpbmback.service.facade.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurServiceImple implements ProfesseurService {
    @Autowired
    private ProfesseurRepository professeurRepository;
    @Autowired
    private LieuTravailRepository lieuTravailRepository;
    @Autowired
    private ExternRepository externRepository;
    @Override
    public Page<Professeur> findAll(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return professeurRepository.findAll(paging);
    }

    @Override
    public List<Professeur> findAll() {
        return professeurRepository.findAll(Sort.by(Sort.Direction.ASC,"nom"));
    }

    @Override
    public Optional<Professeur> findById(Long id) {
        return professeurRepository.findById(id);
    }

    public Professeur save(Professeur prof) {
        // validate the input data :
        if(foreignExtern(prof).isEmpty() || foreignLieuDeTravail(prof).isEmpty()){
            System.out.println("Id of lieuTravail or Extern not found");
            return null;
        }
        return professeurRepository.save(prof);
    }

    @Override
    public String deleteByCode(Long id) {
        professeurRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Professeur update(Professeur prof) {
        if(foreignExtern(prof).isEmpty() || foreignLieuDeTravail(prof).isEmpty()){
            System.out.println("Id of lieuTravail or Extern not found");
            return null;
        }
        return professeurRepository.save(prof);
    }

    private Optional<LieuDeTravail> foreignLieuDeTravail(Professeur professeur) {
        return this.lieuTravailRepository.findById(professeur.getIdLieuTravail().getId());
    }
    private Optional<Extern> foreignExtern(Professeur professeur) {
        return this.externRepository.findById(professeur.getId_extern().getId());
    }
}
