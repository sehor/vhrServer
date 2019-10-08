package hr.security.hr;
import hr.security.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HRRepository extends JpaRepository<HR,Integer>,HRDataHelper {

  HR findHRSByUsername(String HrUsername);
}