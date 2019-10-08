package hr.security.hr_role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Api(tags = "HR_Role 接口测试")
@RestController
@RequestMapping("/HR_Role")
public class HR_RoleController {
@Autowired
HR_RoleService service;

@ApiOperation(value = "example",notes = "this is a example")
@ApiResponse(message = "访问成功",code = 200)
@ApiImplicitParam(value= "str",type = "path",required = false,name = "path variable")
@GetMapping("/example/{str}")
public String example(@PathVariable(value = "str") String str) { 
 return "你好，"+ str;
 }
    @PostMapping("/add")
    public HR_Role add(@RequestBody HR_Role hR_Role){

         return service.addHR_Role(hR_Role);
    }
    @GetMapping("/get/{id}")
    public HR_Role getHR_Role(@PathVariable(value = "id") Integer id){
      return service.getHR_Role(id);
    }
   @PutMapping("/update")
    public HR_Role update(@RequestBody HR_Role hR_Role){
     return service.updateHR_Role(hR_Role);
    }
    @DeleteMapping("/delete/{id}")
   public String delete(@PathVariable("id") Integer id){

      service.deleteHR_Role(id);
      return "delete hR_Role by id :" +id;
    }
}