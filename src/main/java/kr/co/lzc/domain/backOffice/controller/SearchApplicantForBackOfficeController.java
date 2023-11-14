package kr.co.lzc.domain.backOffice.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kidari")
@RequiredArgsConstructor
public class SearchApplicantForBackOfficeController {


  /**
   * 강연 신청자 목록
   */
  @Operation(summary = "applicant list by lecture", description = "강연별 신청한 사번 목록(back-office)")
  @GetMapping("/back-office/applicant")
  public ResponseEntity<?> applicantByLecture() {
    return ResponseEntity.ok(true);
  }
}
