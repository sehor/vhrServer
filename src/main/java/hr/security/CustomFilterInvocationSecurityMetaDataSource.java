package hr.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import hr.security.role.RoleService;

@Component
public class CustomFilterInvocationSecurityMetaDataSource implements FilterInvocationSecurityMetadataSource{
	
	@Autowired
	RoleService roleService;

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String urlStr=((FilterInvocation) object).getRequestUrl();
		
		List<String> attributes=new ArrayList<>();
		
		roleService.findRolesViaPathUrl(urlStr).forEach(r->attributes.add(r.getName()));
		
		return attributes.size()!=0?SecurityConfig.createList(attributes.toArray(new String[attributes.size()]))
				:SecurityConfig.createList("ROLE_LOGIN");
	}

	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

}
