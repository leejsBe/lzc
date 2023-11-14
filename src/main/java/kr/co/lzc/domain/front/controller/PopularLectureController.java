package kr.co.lzc.domain.front.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kidari")
@RequiredArgsConstructor
public class PopularLectureController {


  /**
   * 실시간 인기있는 강연 조회
   */
  @Operation(summary = "current popular lecture list", description = "실시간 인기있는 강연 조회")
  @PutMapping("/lecture/popular")
  public ResponseEntity<?> applyHistoryList() {
    return ResponseEntity.ok(true);
  }
}
