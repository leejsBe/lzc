package kr.co.lzc.domain.front.dto.historyApply;


import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.entity.Registration;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class HistoryApplyRes {


  private final String lectureName;
  private final String lecturer;
  private final String lectureTime;
  private final String contents;
  private final String lectureHallName;
  private final String applyTime;

  private final String employeeNo;
  private final String employeeName;

  public HistoryApplyRes(Registration registration, Employee employee) {
    this.lectureName = registration.getLecture().getName();
    this.lecturer = registration.getLecture().getLecturer();
    this.lectureTime = registration.getLecture().getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    this.contents = registration.getLecture().getContents();
    this.lectureHallName = registration.getLecture().getLectureHall().getName();
    this.applyTime = registration.getCreateAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    this.employeeNo = employee.getNo();
    this.employeeName = employee.getName();
  }

}
