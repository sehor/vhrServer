package hr.security.menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>,MenuDataHelper {
	
	
	List<Menu> findByPattern(String pattern);

}