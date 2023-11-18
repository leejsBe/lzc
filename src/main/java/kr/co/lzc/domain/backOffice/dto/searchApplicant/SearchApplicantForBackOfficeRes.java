package kr.co.lzc.domain.backOffice.dto.searchApplicant;

import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.entity.Lecture;
import lombok.Getter;
import lombok.ToString;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class SearchApplicantForBackOfficeRes {


  private final long lectureId;
  private final String lectureName;
  private final String lectureTime;
  private final List<Applicant> applicants;


  public SearchApplicantForBackOfficeRes(Lecture lecture, List<Long> employeeIds, Map<Long, Employee> employeeMap) {
    this.lectureId = lecture.getId();
    this.lectureName = lecture.getName();
    this.lectureTime = lecture.getTime().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm"));
    this.applicants = employeeIds.stream().map(id -> new Applicant(employeeMap.get(id))).toList();
  }

  @Getter
  @ToString
  public static class Applicant {

    private final String no;
    private final String name;

    public Applicant(Employee employee) {
      this.no = employee.getNo();
      this.name = employee.getName();
    }
  }
}
