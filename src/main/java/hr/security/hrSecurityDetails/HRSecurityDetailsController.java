package hr.security.hrSecurityDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Api(tags = "HRSecurityDetails 接口测试")
@RestController
@RequestMapping("/HRSecurityDetails")
public class HRSecurityDetailsController {
    @Autowired
    HRSecurityDetailsService service;

    @ApiOperation(value = "example", notes = "this is a example")
    @ApiResponse(message = "访问成功", code = 200)
    @ApiImplicitParam(value = "str", type = "path", required = false, name = "path variable")
    @GetMapping("/example/{str}")
    public String example(@PathVariable(value = "str") String str) {
        return "你好，" + str;
    }



    @GetMapping("/get/{id}")
    public HRSecurityDetails getHRSecurityDetails(@PathVariable(value = "id") Integer id) {
        return service.getByHrId(id);
    }

}