package hr;

import hr.security.hr.HR;
import hr.security.hr.HRService;
import hr.security.hrSecurityDetails.HRSecurityDetails;
import hr.security.hrSecurityDetails.HRSecurityDetailsService;
import hr.security.menu.Menu;
import hr.security.menu.MenuService;
import hr.security.role.Role;
import hr.security.role.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	RoleService roleService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void dataTest() {
/*        HR hr = new HR();
        // hr.setId(1);
        hr.setName("DBAdmin");
        hr.setUsername("super");
        hr.setPassword("123456");
        hr.setAddress("ShenZhen city,where");
        hrService.addHR(hr);
        hrService.deleteHR(1);*/

/* Role role=new Role();
 role.setId(6);
 role.setNameZh("通用的认证账户");
 role.setName("ROLE_LOGIN");
 roleService.updateRole(role);*/



  // roleService.findAllRoles().forEach(v-> System.out.println(v.getNameZh()));
        menuService.findAllMenus().forEach(v-> System.out.println(v.getPattern()));


/* Menu menu=new Menu();
 menu.setPattern("/admin/**");
 menuService.addMenu(menu);*/

        //hrSecurityDetailsService.getByHrId(1).getRoles().forEach(v-> System.out.println(v.getName()));


    }

}
