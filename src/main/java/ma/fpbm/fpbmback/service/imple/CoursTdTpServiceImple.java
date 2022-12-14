package ma.fpbm.fpbmback.service.imple;

import ma.fpbm.fpbmback.beans.CoursTdTp;
import ma.fpbm.fpbmback.repository.CoursTdTpRepository;
import ma.fpbm.fpbmback.service.facade.CoursTdTpService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoursTdTpServiceImple implements CoursTdTpService {
    @Autowired
    private CoursTdTpRepository coursTdTpRepository;

    @Override
    public List<CoursTdTp> findAll() {
        return coursTdTpRepository.findAll();
    }

    @Override
    public CoursTdTp save(CoursTdTp coursTdTp) {
        // validate the input data :
        if (coursTdTp.getTypeDeResponsabilite().isEmpty())
            return null;

        // validate the DB data;

        coursTdTp.setCode(String.valueOf(coursTdTp.hashCode()));

        if (coursTdTpRepository.findByCode(coursTdTp.getCode()) == null){
            return this.coursTdTpRepository.save(coursTdTp);
        }
        return null;
    }

    @Override
    public int deleteByCode(String code) {
        return coursTdTpRepository.deleteByCode(code);
    }

    @Override
    public CoursTdTp update(CoursTdTp departement) {
        return null;
    }
}
