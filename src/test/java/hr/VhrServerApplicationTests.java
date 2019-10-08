package hr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hr.security.hr.HR;
import hr.security.hr.HRService;
import hr.security.hrSecurityDetails.HRSecurityDetailsService;
import hr.security.hr_role.HR_Role;
import hr.security.hr_role.HR_RoleService;
import hr.security.menu.MenuService;
import hr.security.menu_role.Menu_RoleService;
import hr.security.role.RoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VhrServerApplicationTests {
    @Autowired
    HRService hrService;
    @Autowired
    MenuService menuService;
    @Autowired
    HRSecurityDetailsService hrSecurityDetailsService;
    
    @Autowired
    Menu_RoleService m_rService;

    @Autowired
	RoleService roleService;
    
    @Autowired
    HR_RoleService h_rService;

	/*
	 * @Test public void contextLoads() { }
	 */

    @Test
    public void dataTest() {
		/*
		 * HR hr = new HR(); hr.setId(1); hr.setEnabled(true); hr.setName("tomcat");
		 * hr.setUsername("kitty"); hr.setPassword("123");
		 * hr.setAddress("ShenZhen city,where"); hrService.updateHR(hr);
		 * //hrService.deleteHR(1);
		 */        
        
        HR_Role hr_Role=new HR_Role();
        hr_Role.setHrId(1);
        hr_Role.setRoleId(1);
        h_rService.addHR_Role(hr_Role);

/* Role role=new Role();
 role.setId(6);
 role.setNameZh("通用的认证账户");
 role.setName("ROLE_LOGIN");
 roleService.updateRole(role);*/



  // roleService.findAllRoles().forEach(v-> System.out.println(v.getNameZh()));
    //	menuService.findMenusViaUrl("/admin/123").forEach(v->System.out.println(v.getPattern()));;
  // roleService.findRolesViaPathUrl("/guest/12f3").forEach(v->System.out.println(v.getNameZh()));
        


/* Menu menu=new Menu();
 menu.setPattern("/admin/**");
 menuService.addMenu(menu);*/

        //hrSecurityDetailsService.getByHrId(1).getRoles().forEach(v-> System.out.println(v.getName()));


    }

}
