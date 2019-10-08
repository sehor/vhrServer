package hr.security.menu_role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Api(tags = "Menu_Role 接口测试")
@RestController
@RequestMapping("/Menu_Role")
public class Menu_RoleController {
@Autowired
Menu_RoleService service;

@ApiOperation(value = "example",notes = "this is a example")
@ApiResponse(message = "访问成功",code = 200)
@ApiImplicitParam(value= "str",type = "path",required = false,name = "path variable")
@GetMapping("/example/{str}")
public String example(@PathVariable(value = "str") String str) { 
 return "你好，"+ str;
 }
    @PostMapping("/add")
    public Menu_Role add(@RequestBody Menu_Role menu_Role){

         return service.addMenu_Role(menu_Role);
    }
    @GetMapping("/get/{id}")
    public Menu_Role getMenu_Role(@PathVariable(value = "id") Integer id){
      return service.getMenu_Role(id);
    }
   @PutMapping("/update")
    public Menu_Role update(@RequestBody Menu_Role menu_Role){
     return service.updateMenu_Role(menu_Role);
    }
    @DeleteMapping("/delete/{id}")
   public String delete(@PathVariable("id") Integer id){

      service.deleteMenu_Role(id);
      return "delete menu_Role by id :" +id;
    }
}