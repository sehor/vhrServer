package hr.security.menu_role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.security.menu.MenuRepository;
import hr.security.role.RoleRepository;
import hr.security.role.RoleService;
import javassist.NotFoundException;

@Service
public class Menu_RoleServiceImpl implements Menu_RoleService {
@Autowired
Menu_RoleRepository repository;
@Autowired
RoleRepository r_repository;
@Autowired
MenuRepository m_repository;


     @Override
    public Menu_Role addMenu_Role(Menu_Role menu_Role) {
    	try { 
    		
    	     if(!r_repository.existsById(menu_Role.getRoleId()))
			
				throw new NotFoundException("no such role!");
    	     
    	     if(!m_repository.existsById(menu_Role.getMenuId()))
    	    	 throw new NotFoundException("no such menu!");
    	     
    	     return repository.save(menu_Role);
    	    	 
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return null;
				
			}
    	 
              
    }
    @Override
    public Menu_Role getMenu_Role(Integer id) {

		return repository.findById(id).orElse(null);
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