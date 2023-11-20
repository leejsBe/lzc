package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Employee;
import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureReq;
import kr.co.lzc.domain.front.dto.cancelApply.CancelApplyReq;
import kr.co.lzc.domain.front.dto.cancelApply.CancelApplyRes;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class CancelApplyServiceTest {

  @Autowired
  public LectureRepo lectureRepo;

  @Autowired
  public EmployeeRepo employeeRepo;

  @Autowired
  public ApplyLectureService applyLectureService;

  @Autowired
  public HistoryApplyService historyApplyService;

  @Autowired
  public CancelApplyService cancelApplyService;


  @BeforeEach
  void ready() {
    Lecture lecture = lectureRepo.findAll().stream().findFirst().get();
    Employee employee = employeeRepo.findAll().stream().findFirst().get();

    applyLectureService.apply(ApplyLectureReq.builder()
      .lectureId(lecture.getId())
      .employeeNo(employee.getNo())
      .build());
  }


  @Test
  @DisplayName("신청 강연 취소 테스트")
  void success() {
    Employee employee = employeeRepo.findAll().stream().findFirst().get();

    List<HistoryApplyRes> historyApplyRes = historyApplyService.search(HistoryApplyReq.builder().employeeNo(employee.getNo()).build());
    Assertions.assertNotNull(historyApplyRes);

    HistoryApplyRes history = historyApplyRes.stream().findFirst().get();

    Assertions.assertDoesNotThrow(() -> {
      CancelApplyRes cancelApplyRes = cancelApplyService.cancel(CancelApplyReq.builder().bookNo(history.getBookNo()).build());

      Assertions.assertNotNull(cancelApplyRes);
      if (cancelApplyRes.getBookNo() == 0) {
        throw new Exception();
      }
    });

  }


}