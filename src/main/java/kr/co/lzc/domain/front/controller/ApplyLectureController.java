package kr.co.lzc.domain.front.controller;


import io.swagger.v3.oas.annotations.Operation;
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
public class ApplyLectureController {


  /**
   * 강연 신청
   */
  @Operation(summary = "apply lecture", description = "강연 신청")
  @PostMapping("/lecture")
  public ResponseEntity<?> applyLecture() {
    return ResponseEntity.ok(true);
  }
}
