package kr.co.lzc.domain.backOffice.controller;


import io.swagger.v3.oas.annotations.Operation;
import kr.co.lzc.domain.backOffice.dto.searchLecture.SearchLectureForBackOfficeRes;
import kr.co.lzc.domain.backOffice.service.SearchLectureForBackOfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/kidari")
@RequiredArgsConstructor
public class SearchLectureForBackOfficeController {


  private final SearchLectureForBackOfficeService searchLectureForBackOfficeService;


  /**
   * 강연 전체 목록
   */
  @Operation(summary = "total lecture list", description = "강연 전체 목록 조회(back-office)")
  @GetMapping("/back-office/lecture")
  public ResponseEntity<List<SearchLectureForBackOfficeRes>> lectureTotalList() {
    return ResponseEntity.ok(searchLectureForBackOfficeService.search());
  }

}
