package hr.security.hrSecurityDetails;

import hr.security.hr.HR;
import hr.security.role.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@ApiModel(value = "", description = "")
public class HRSecurityDetails implements UserDetails, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
    private HR hr;

    @ApiModelProperty(value = "")
    private List<Role> roles;

    @ApiModelProperty(value = "")
    private Integer id;



    public HRSecurityDetails(HR hr) {
        this.hr = hr;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

       List<GrantedAuthority> authorities=new ArrayList<>();
       for(Role role:this.roles){

          authorities.add(new SimpleGrantedAuthority(role.getName()));
       }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.hr.getPassword();
    }

    @Override
    public String getUsername() {
        return this.hr.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.hr.getEnabled();
    }


    public HR getHr() {
        return hr;
    }


    public List<Role> getRoles() {
        return roles;
    }

    void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}