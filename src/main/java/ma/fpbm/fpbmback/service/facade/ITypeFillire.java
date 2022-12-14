package ma.fpbm.fpbmback.service.facade;


import ma.fpbm.fpbmback.beans.TypeFiliere;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITypeFillire {

    TypeFiliere getTypeFillireById(Long idTpFilliere);
    List<TypeFiliere> getAllTpFilliere();
    TypeFiliere saveTpFilliere(TypeFiliere typeFiliere);
    TypeFiliere updateTpFilliere(TypeFiliere typeFiliere);
    String deleteTpFilliere(Long idFilliere);

    TypeFiliere findById(Long idTpFlr);
}
