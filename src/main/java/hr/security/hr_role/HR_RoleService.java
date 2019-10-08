package hr.security.hr_role;
public interface HR_RoleService {
HR_Role addHR_Role(HR_Role hR_Role);
HR_Role getHR_Role(Integer id);
HR_Role updateHR_Role(HR_Role hR_Role);
void deleteHR_Role(HR_Role hR_Role);
void deleteHR_Role(Integer id);
void deleteViaRloeId(Integer RoleId);
void deleteViaHrId(Integer hrId);
}