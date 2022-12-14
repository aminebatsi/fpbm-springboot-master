package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Salle;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISalle {
    Salle getSalleById(Long idSalle);
    List<Salle> getAllSalle();
    Salle saveSalle(Salle module);
    Salle updateSalle(Salle module);
    String deleteSalle(Long idSalle);

}
