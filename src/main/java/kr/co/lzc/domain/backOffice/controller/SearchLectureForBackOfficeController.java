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
public class SearchLectureForBackOfficeController {


  /**
   * 강연 전체 목록
   */
  @Operation(summary = "total lecture list", description = "강연 전체 목록 조회(back-office)")
  @GetMapping("/back-office/lecture")
  public ResponseEntity<?> lectureTotalList() {
    return ResponseEntity.ok(true);
  }

}
