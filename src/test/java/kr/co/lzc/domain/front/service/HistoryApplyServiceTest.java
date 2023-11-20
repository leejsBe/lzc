package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureReq;
import kr.co.lzc.domain.front.dto.historyApply.HistoryApplyReq;
import kr.co.lzc.domain.front.dto.historyApply.HistoryApplyRes;
import kr.co.lzc.domain.repository.EmployeeRepo;
import kr.co.lzc.domain.repository.LectureRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HistoryApplyServiceTest {

  @Autowired
  public LectureRepo lectureRepo;

  @Autowired
  public EmployeeRepo employeeRepo;

  @Autowired
  public ApplyLectureService applyLectureService;

  @Autowired
  public HistoryApplyService historyApplyService;



  @Test
  @DisplayName("신청 내역 조회 테스트")
  void success() {
    Employee employee = employeeRepo.findAll().stream().findFirst().get();


    Assertions.assertDoesNotThrow(() -> {
      List<HistoryApplyRes> result = historyApplyService.search(HistoryApplyReq.builder().employeeNo(employee.getNo()).build());

      Assertions.assertNotNull(result);

      if (result.size() == 0) {
        throw new Exception();
      }
    });

  }
}