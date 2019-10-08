package hr.security.hrSecurityDetails;

import hr.security.hr.HR;
import hr.security.hr.HRService;
import hr.security.role.Role;
import hr.security.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HRSecurityDetailsServiceImpl implements HRSecurityDetailsService, UserDetailsService {
 @Autowired
    HRService hrService;

 @Autowired
    RoleService roleService;


    @Override
    public HRSecurityDetails getByHrId(Integer hrId) {
        HR hr=hrService.getHR(hrId);
        List<Role> roles = roleService.getByHrId(hrId);
        HRSecurityDetails hrSecurityDetails=new HRSecurityDetails(hr);
        hrSecurityDetails.setRoles(roles);
        return hrSecurityDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       HR hr= hrService.getHRViaName(s);
       if(hr==null) throw new UsernameNotFoundException("改用户不存在！");

        List<Role> roles = roleService.getByHrId(hr.getId());
        HRSecurityDetails hrSecurityDetails=new HRSecurityDetails(hr);
        hrSecurityDetails.setRoles(roles);
        hrSecurityDetails.setId(hr.getId());

        return hrSecurityDetails;
    }
}