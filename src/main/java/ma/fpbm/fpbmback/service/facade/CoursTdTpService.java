package ma.fpbm.fpbmback.service.facade;


import ma.fpbm.fpbmback.beans.CoursTdTp;

import java.util.List;

public interface CoursTdTpService {
    List<CoursTdTp> findAll();
    CoursTdTp save (CoursTdTp coursTdTp);
    int deleteByCode (String code);
    CoursTdTp update (CoursTdTp coursTdTp);
}
