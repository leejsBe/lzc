package kr.co.lzc.domain.front.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kidari")
@RequiredArgsConstructor
public class HistoryApplyController {


  /**
   * 신청 내역 조회
   */
  @Operation(summary = "apply history", description = "강연 신청 내역 조회")
  @GetMapping("/apply/{applyId}")
  public ResponseEntity<?> applyHistoryList(@PathVariable("applyId") long applyId) {
    return ResponseEntity.ok(true);
  }
}
