package hr.security.role;

import hr.security.hr_role.HR_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository repository;
    @Autowired
    HR_RoleService hr_roleService;

    @Override
    @CacheEvict(value = "roleCache",allEntries = true)
    public Role addRole(Role role) {
        return repository.save(role);
    }

    @Override
    @Cacheable(value= "roleCache")
    public Role getRole(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    @CacheEvict(value = "roleCache",allEntries = true)
    public Role updateRole(Role role) {
        return repository.save(role);
    }

    @Override
    @CacheEvict(value = "roleCache",allEntries = true)
    public void deleteRole(Role role) {

        repository.delete(role);
        hr_roleService.deleteViaRloeId(role.getId());
    }

    @Override
    @CacheEvict(value = "roleCache",allEntries = true)
    public void deleteRole(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Role> getByHrId(Integer hrId) {
        return repository.getRolesViaHrId(hrId);
    }


    @Cacheable(value= "roleCache", key = "#root.methodName")
    @Override
    public List<Role> findAllRoles() {
        System.out.println("查找全部角色。。");
        return repository.findAll();
    }

    /*
      new user's default role is ROLE_Guest,
      if there is no one, add one into database;
    */
    @Override
    @Cacheable(value = "roleCache",key = "#root.methodName")
    public Role getDefaultRole() {

        System.out.println("查找默认角色。。。");
        for(Role role:repository.findAll()){
            if("ROLE_Guest".equalsIgnoreCase(role.getName())){
                return role;
            }
        }

        Role role=new Role();
        role.setName("ROLE_Guest");
        role.setNameZh("游客");

        Role role1=repository.save(role); //add to database


        return role1;
    }

}