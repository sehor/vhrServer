package hr.security.menu;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class MenuRepositoryImpl implements MenuDataHelper {

    @PersistenceContext
    EntityManager em;

    @Override
    @Cacheable(value = "menusCache")
    public List<Menu> findAllMenus() {
        String query=" from Menu";
        System.out.println("find all menus in db!");
        return em.createQuery(query).getResultList();
    }


    @Override
    @CacheEvict(value = "menusCache",allEntries = true)
    public void refreshCache() {

    }


}