package kr.co.lzc.domain.backOffice.dto.searchApplicant;

import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.entity.Registration;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Getter
public class SearchApplicantForBackOfficeRes {


  private final long lectureId;
  private final String lectureName;
  private final String lectureTime;
  private final List<Applicant> applicants;


  public SearchApplicantForBackOfficeRes(Registration registration, List<Long> employeeIds, Map<Long, Employee> employeeMap) {
    this.lectureId = registration.getLecture().getId();
    this.lectureName = registration.getLecture().getName();
    this.lectureTime = registration.getLecture().getTime().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm"));
    this.applicants = employeeIds.stream().map(id -> new Applicant(employeeMap.get(id))).toList();
  }

  @Getter
  public static class Applicant {

    private final String no;
    private final String name;

    public Applicant(Employee employee) {
      this.no = employee.getNo();
      this.name = employee.getName();
    }
  }
}
