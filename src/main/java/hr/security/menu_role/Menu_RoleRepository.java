package hr.security.menu_role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Menu_RoleRepository extends JpaRepository<Menu_Role,Integer>,Menu_RoleDataHelper {
}