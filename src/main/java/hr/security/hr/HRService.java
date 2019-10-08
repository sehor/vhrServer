package hr.security.hr;

public interface HRService {
HR addHR(HR hR);
HR getHR(Integer id);
HR getHRViaName(String HrName);
HR updateHR(HR hR);
void deleteHR(HR hR);
void deleteHR(Integer id);

}