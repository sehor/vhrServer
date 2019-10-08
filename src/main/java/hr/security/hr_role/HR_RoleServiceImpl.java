package hr.security.hr_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HR_RoleServiceImpl implements HR_RoleService {
@Autowired
HR_RoleRepository repository;
     @Override
    public HR_Role addHR_Role(HR_Role hR_Role) {
        return repository.save(hR_Role);
    }
    @Override
    public HR_Role getHR_Role(Integer id) {
        return repository.findById(id).get();
    }
    @Override
    public HR_Role updateHR_Role(HR_Role hR_Role) {
        return repository.save(hR_Role);
    }
    @Override
    public void deleteHR_Role(HR_Role hR_Role) {
       repository.delete(hR_Role);
    }
    @Override
    public void deleteHR_Role(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteViaRloeId(Integer roleId) {
         repository.deleteHR_RoleByRoleId(roleId);
    }

    @Override
    public void deleteViaHrId(Integer hrId) {
        repository.deleteHR_RoleByHrId(hrId);
    }

}