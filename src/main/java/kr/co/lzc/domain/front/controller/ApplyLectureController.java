package kr.co.lzc.domain.front.controller;


import io.swagger.v3.oas.annotations.Operation;
import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureReq;
import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureRes;
import kr.co.lzc.domain.front.service.ApplyLectureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kidari")
@RequiredArgsConstructor
public class ApplyLectureController {

  private final ApplyLectureService applyLectureService;

  /**
   * 강연 신청
   */
  @Operation(summary = "apply lecture", description = "강연 신청")
  @PostMapping("/lecture")
  public ResponseEntity<ApplyLectureRes> applyLecture(@RequestBody ApplyLectureReq applyLectureReq) {
    return ResponseEntity.ok(applyLectureService.apply(applyLectureReq));
  }
}
