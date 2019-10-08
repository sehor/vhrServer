package hr.security.role;

import java.util.List;

public interface RoleService {
Role addRole(Role role);
Role getRole(Integer id);
Role updateRole(Role role);
void deleteRole(Role role);
void deleteRole(Integer id);
List<Role> getByHrId(Integer hrId);
List<Role> findAllRoles();
Role getDefaultRole();
}