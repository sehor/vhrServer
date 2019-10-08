package hr.security.hr_role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HR_RoleRepository extends JpaRepository<HR_Role,Integer>,HR_RoleDataHelper {

    void deleteHR_RoleByHrId(Integer HrId);
    void deleteHR_RoleByRoleId(Integer roleId);
}