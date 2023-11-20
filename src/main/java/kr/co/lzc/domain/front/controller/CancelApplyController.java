package kr.co.lzc.domain.front.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.co.lzc.domain.front.dto.cancelApply.CancelApplyReq;
import kr.co.lzc.domain.front.dto.cancelApply.CancelApplyRes;
import kr.co.lzc.domain.front.service.CancelApplyService;
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

  private final CancelApplyService cancelApplyService;

  /**
   * 신청 강연 취소
   */
  @Operation(summary = "cancel lecture", description = "신청 강연 취소")
  @PutMapping("/history/{bookNo}")
  public ResponseEntity<CancelApplyRes> applyHistoryList(@PathVariable("bookNo") long bookNo) {
    return ResponseEntity.ok(cancelApplyService.cancel(CancelApplyReq.builder().bookNo(bookNo).build()));
  }
}
