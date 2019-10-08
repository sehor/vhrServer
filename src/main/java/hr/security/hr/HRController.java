package hr.security.hr;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Api(tags = "HR 接口测试")
@RestController
@RequestMapping("/HR")
public class HRController {
    @Autowired
    HRService service;

    @ApiOperation(value = "example", notes = "this is a example")
    @ApiResponse(message = "访问成功", code = 200)
    @ApiImplicitParam(value = "str", type = "path", required = false, name = "path variable")
    @GetMapping("/example/{str}")
    public String example(@PathVariable(value = "str") String str) {
        return "你好，" + str;
    }

    @PostMapping("/add")
    public HR add(@RequestBody HR hR) {

        return service.addHR(hR);
    }

    @GetMapping("/get/{id}")
    public HR getHR(@PathVariable(value = "id") Integer id) {
        return service.getHR(id);
    }

    @GetMapping("/getByName/{name}")
    HR getHRVia(@PathVariable(value = "name") String name ){

         return service.getHRViaName(name);
    }

    @PutMapping("/update")
    public HR update(@RequestBody HR hR) {
        return service.updateHR(hR);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

        service.deleteHR(id);
        return "delete hR by id :" + id;
    }

    @DeleteMapping("/deleteHr")
    String deleteByName(@RequestBody HR hr){
        service.deleteHR(hr);
        return "delete hR by name:" + hr.getUsername();
    }


}