package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Semestre;

import java.util.List;

public interface ISemestre {
    Semestre getSemestreById(Long idSemestre);
    List<Semestre> getAllSemestre();
    Semestre saveSemestre(Semestre semestre);
    Semestre updateSemestre(Semestre semestre);
    String deleteSemestre(Long idSemestre);
}
