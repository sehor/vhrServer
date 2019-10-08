package hr.security.menu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Menu 接口测试")
@RestController
@RequestMapping("/Menu")
public class MenuController {
    @Autowired
    MenuService service;

    @ApiOperation(value = "example", notes = "this is a example")
    @ApiResponse(message = "访问成功", code = 200)
    @ApiImplicitParam(value = "str", type = "path", required = false, name = "path variable")
    @GetMapping("/example/{str}")
    public String example(@PathVariable(value = "str") String str) {
        return "你好，" + str;
    }

    @PostMapping("/add")
    public Menu add(@RequestBody Menu menu) {

        return service.addMenu(menu);
    }

    @GetMapping("/get/{id}")
    public Menu getMenu(@PathVariable(value = "id") Integer id) {
        return service.getMenu(id);
    }

    @PutMapping("/update")
    public Menu update(@RequestBody Menu menu) {
        return service.updateMenu(menu);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

        service.deleteMenu(id);
        return "delete menu by id :" + id;
    }

    @GetMapping("/showAll")
    List<Menu> showAllMenu(){


        return service.findAllMenus();
    }


}