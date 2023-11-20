package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.entity.Registration;
import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureReq;
import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureRes;
import kr.co.lzc.domain.front.enumeration.FrontResCode;
import kr.co.lzc.domain.front.exception.FrontException;
import kr.co.lzc.domain.repository.EmployeeRepo;
import kr.co.lzc.domain.repository.LectureRepo;
import kr.co.lzc.domain.repository.RegistrationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ApplyLectureService {

  private final LectureRepo lectureRepo;
  private final EmployeeRepo employeeRepo;
  private final RegistrationRepo registrationRepo;


  @Transactional
  public ApplyLectureRes apply(ApplyLectureReq applyLectureReq) {
    Lecture lecture = lectureRepo.findById(applyLectureReq.getLectureId()).orElseThrow(() -> new FrontException(FrontResCode.NOT_FOUND_LECTURE));
    Employee employee = employeeRepo.findByNo(applyLectureReq.getEmployeeNo()).orElseThrow(() -> new FrontException(FrontResCode.NOT_FOUND_EMPLOYEE));

    Registration registration = registrationRepo.save(Registration.builder()
      .lecture(lecture)
      .employee(employee)
      .duplicateCheck(lecture.getId() + "_" + employee.getId())
      .createAt(LocalDateTime.now())
      .build());

    return new ApplyLectureRes(registration);
  }

}
