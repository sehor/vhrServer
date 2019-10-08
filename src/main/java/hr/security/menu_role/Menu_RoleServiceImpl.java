package hr.security.menu_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Menu_RoleServiceImpl implements Menu_RoleService {
@Autowired
Menu_RoleRepository repository;
     @Override
    public Menu_Role addMenu_Role(Menu_Role menu_Role) {
        return repository.save(menu_Role);
    }
    @Override
    public Menu_Role getMenu_Role(Integer id) {
        return repository.findById(id).get();
    }
    @Override
    public Menu_Role updateMenu_Role(Menu_Role menu_Role) {
        return repository.save(menu_Role);
    }
    @Override
    public void deleteMenu_Role(Menu_Role menu_Role) {
       repository.delete(menu_Role);
    }
    @Override
    public void deleteMenu_Role(Integer id) {
        repository.deleteById(id);
    }
}