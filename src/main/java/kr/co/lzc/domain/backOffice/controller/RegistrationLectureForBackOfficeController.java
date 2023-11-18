package kr.co.lzc.domain.backOffice.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.co.lzc.domain.backOffice.dto.registrationLecture.RegistrationLectureForBackOfficeReq;
import kr.co.lzc.domain.backOffice.service.RegistrationLectureForBackOfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kidari")
@RequiredArgsConstructor
public class RegistrationLectureForBackOfficeController {

  private final RegistrationLectureForBackOfficeService registrationLectureForBackOfficeService;

  /**
   * 강연 등록
   */
  @Operation(summary = "lecture registration", description = "강연 등록(back-office)")
  @PostMapping("/back-office/lecture")
  public ResponseEntity<Boolean> lectureRegistration(RegistrationLectureForBackOfficeReq registrationLectureForBackOfficeReq) {
    registrationLectureForBackOfficeService.save(registrationLectureForBackOfficeReq);
    return ResponseEntity.ok(true);
  }

}
