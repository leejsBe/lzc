package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureReq;
import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureRes;
import kr.co.lzc.domain.repository.EmployeeRepo;
import kr.co.lzc.domain.repository.LectureRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ApplyLectureServiceTest {


  @Autowired
  public LectureRepo lectureRepo;

  @Autowired
  public EmployeeRepo employeeRepo;

  @Autowired
  public ApplyLectureService applyLectureService;


  @Test
  @DisplayName("강연 신청 테스트")
  void success() {
    Lecture lecture = lectureRepo.findAll().stream().findFirst().get();
    Employee employee = employeeRepo.findAll().stream().findFirst().get();


    Assertions.assertDoesNotThrow(() -> {
      ApplyLectureRes result = applyLectureService.apply(ApplyLectureReq.builder()
        .lectureId(lecture.getId())
        .employeeNo(employee.getNo())
        .build());

      Assertions.assertNotNull(result);
    });
  }

}