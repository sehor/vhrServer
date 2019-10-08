package hr.security.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository repository;


    @Override
    @CachePut(value = "menuCache",key = "#result.id")
    public Menu addMenu(Menu menu) {
        repository.refreshCache();
        return repository.save(menu);
    }

    @Override
    @Cacheable(value ="menuCache")
    public Menu getMenu(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    @CachePut(value = "menuCache",key="#result.id")
    public Menu updateMenu(Menu menu) {
        repository.refreshCache();
        return repository.save(menu);
    }

    @Override
    @CacheEvict(value = "menuCache",key = "#menu.id")
    public void deleteMenu(Menu menu) {
        repository.refreshCache();
        repository.delete(menu);
    }

    @Override
    @CacheEvict(value = "menuCache",key = "#id")
    public void deleteMenu(Integer id) {
        repository.refreshCache();
        repository.deleteById(id);
    }

    @Override
    public List<Menu> findAllMenus() {
        return repository.findAllMenus();
    }



}