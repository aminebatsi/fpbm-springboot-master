package ma.fpbm.fpbmback.repository;

import ma.fpbm.fpbmback.beans.CoursTdTp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursTdTpRepository extends JpaRepository<CoursTdTp, Long> {
    CoursTdTp findByCode(String code);
    int deleteByCode(String code);
}
