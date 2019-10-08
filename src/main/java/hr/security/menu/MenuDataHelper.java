package hr.security.menu;

import java.util.List;

public interface MenuDataHelper {
    List<Menu> findAllMenus();
    void refreshCache();
}