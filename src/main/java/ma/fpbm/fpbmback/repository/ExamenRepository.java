package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.Examen;
import ma.fpbm.fpbmback.beans.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamenRepository extends JpaRepository<Examen,Long> {
    //@Query("SELECT e.heure , s.name ,s.capacity From Examen e JOIN Salle s on e.salle = s.id")
    @Query("SELECT e.heure , e.jour, s.name ,s.capacity From Examen e JOIN Salle s on e.salle = s.id")
    public List<Object[]> query();
}