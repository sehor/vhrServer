package hr.security.menu;

import java.util.List;

public interface MenuService {
Menu addMenu(Menu menu);
Menu getMenu(Integer id);
Menu updateMenu(Menu menu);
void deleteMenu(Menu menu);
void deleteMenu(Integer id);
List<Menu> findAllMenus();
}