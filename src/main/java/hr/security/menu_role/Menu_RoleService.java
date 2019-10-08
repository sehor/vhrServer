package hr.security.menu_role;
public interface Menu_RoleService {
Menu_Role addMenu_Role(Menu_Role menu_Role);
Menu_Role getMenu_Role(Integer id);
Menu_Role updateMenu_Role(Menu_Role menu_Role);
void deleteMenu_Role(Menu_Role menu_Role);
void deleteMenu_Role(Integer id);
}