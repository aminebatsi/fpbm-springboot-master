package ma.fpbm.fpbmback.service.imple;


import ma.fpbm.fpbmback.beans.Module;
import ma.fpbm.fpbmback.repository.ModuleRepository;
import ma.fpbm.fpbmback.service.facade.IModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ModuleServiceImpl implements IModule {

    @Autowired
    private ModuleRepository moduleRepository;
    @Override
    public Page<Module> findAll(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
       return moduleRepository.findAll(paging);

    }

    @Override
    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    @Override
    public Module findById(Long id) {
        return moduleRepository.findById(id).orElse(null);

    }

    @Override
    public Module save(Module module) {

       return  moduleRepository.save(module);
    }

    @Override
    public String deleteById(Long code) {
        moduleRepository.deleteById(code);
        return "Deleted";
    }

    @Override
    public Module update(Module module) {
        return moduleRepository.save(module);
    }
}
