package hr.security.hr;

import hr.security.hr_role.HR_Role;
import hr.security.hr_role.HR_RoleService;
import hr.security.role.Role;
import hr.security.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HRServiceImpl implements HRService {
    @Autowired
    HRRepository repository;
    @Autowired
    HR_RoleService hr_roleService;
    @Autowired
    RoleService roleService;

    @Override
    @CachePut(cacheNames = "hrCache",key="#result.id")
    public HR addHR(HR hR) {
        hR.setPassword(new BCryptPasswordEncoder().encode(hR.getPassword()));
        HR hr1=repository.save(hR);

        //保存到hr_role关系表，设置默认角色
        HR_Role hr_role=new HR_Role();

        hr_role.setHrId(hr1.getId());
        hr_role.setRoleId(roleService.getDefaultRole().getId());

        hr_roleService.addHR_Role(hr_role);

        return hr1;
    }

    @Override
    @Cacheable(value = "hrCache",unless = "#result!=null")
    public HR getHR(Integer id) {
        return repository.getOne(id);
    }

    @Override
    @Cacheable(value = "hrCache")
    public HR getHRViaName(String hrName) {
        return repository.findHRSByUsername(hrName);
    }

    @Override
    @CachePut(value = "hrCache",key = "#result.id")
    public HR updateHR(HR hR) {
        hR.setPassword(new BCryptPasswordEncoder().encode(hR.getPassword()));
        return repository.save(hR);
    }

    @Override
    @CacheEvict(value = "hrCache",key = "#hR.id")
    public void deleteHR(HR hR) {
        repository.delete(hR);
        hr_roleService.deleteViaHrId(hR.getId());
    }

    @Override
    @CacheEvict(value = "hrCache",key = "#id")
    public void deleteHR(Integer id) {
        repository.deleteById(id);
        hr_roleService.deleteViaHrId(id);
    }


}