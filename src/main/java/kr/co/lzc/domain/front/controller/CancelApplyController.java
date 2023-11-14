package kr.co.lzc.domain.front.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kidari")
@RequiredArgsConstructor
public class CancelApplyController {


  /**
   * 신청 강연 취소
   */
  @Operation(summary = "cancel lecture", description = "신청 강연 취소")
  @PutMapping("/apply/{applyId}/lecture/{lectureId}")
  public ResponseEntity<?> applyHistoryList(@PathVariable("applyId") long applyId, @PathVariable("lectureId") long lectureId) {
    return ResponseEntity.ok(true);
  }
}
