package kr.co.lzc.domain.front.controller;


import io.swagger.v3.oas.annotations.Operation;
import kr.co.lzc.domain.front.dto.historyApply.HistoryApplyReq;
import kr.co.lzc.domain.front.dto.historyApply.HistoryApplyRes;
import kr.co.lzc.domain.front.service.HistoryApplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/kidari")
@RequiredArgsConstructor
public class HistoryApplyController {

  private final HistoryApplyService historyApplyService;

  /**
   * 신청 내역 조회
   */
  @Operation(summary = "apply history", description = "강연 신청 내역 조회")
  @GetMapping("/employee/{employeeNo}")
  public ResponseEntity<List<HistoryApplyRes>> applyHistoryList(@PathVariable("employeeNo") String employeeNo) {
    return ResponseEntity.ok(historyApplyService.search(HistoryApplyReq.builder().employeeNo(employeeNo).build()));
  }
}
