package hr.security.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>,RoleDataHelper {

    @Query("FROM Role as r,HR_Role as h_r WHERE h_r.hrId=:hrId AND h_r.roleId=r.id")
    List<Role> getRolesViaHrId(Integer hrId);
}