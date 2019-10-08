package hr.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		// TODO Auto-generated method stub
		
		
	    for(ConfigAttribute configAttribute:configAttributes) {
	    	
	    	if(configAttribute.getAttribute().equalsIgnoreCase("ROLE_LOGIN")
	    			&&authentication instanceof UsernamePasswordAuthenticationToken) {
	    		return;
	    		
	    	}
	    	
	    	for(GrantedAuthority authority:authentication.getAuthorities()) {
	    		
	    		 if(authority.getAuthority().equals(configAttribute.getAttribute())) {
	    			 return;
	    		 }
	    	}
	    	
	    	
	    }
	    
	    throw new AccessDeniedException("sorry,you have no right access ..");
		
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
