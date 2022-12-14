package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Examen;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ExamenService {
    List<Examen> findAll();
    Page<Examen> findByPage(int page, int size);
    Examen save (Examen examen);
    String deleteById (Long code);
    Examen update (Examen examen);

    List<Object[]> query();
}