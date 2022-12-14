package ma.fpbm.fpbmback.service.facade;

import ma.fpbm.fpbmback.beans.Module;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IModule {

    Page<Module> findAll(int pageNo, int pageSize);
    List<Module> findAll();
Module findById(Long id);
    Module save (Module module);
    String deleteById (Long code);
    Module update (Module module);
}
