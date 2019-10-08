package hr.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/security")
@RestController
public class SecurityController {


    @GetMapping ("/me")
    String showMyself(Authentication auth) throws JsonProcessingException {

        ObjectMapper om=new ObjectMapper();
        Object principal=auth.getPrincipal();
        return om.writeValueAsString(principal);
    }

}
