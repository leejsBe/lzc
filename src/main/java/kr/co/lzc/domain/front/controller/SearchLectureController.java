package kr.co.lzc.domain.front.controller;


import io.swagger.v3.oas.annotations.Operation;
import kr.co.lzc.domain.front.dto.searchLecture.SearchLectureRes;
import kr.co.lzc.domain.front.service.SearchLectureService;
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
public class SearchLectureController {

  private final SearchLectureService searchLectureService;

  /**
   * 강연 목록
   */
  @Operation(summary = "lecture list", description = "강연 목록 조회")
  @GetMapping("/lecture")
  public ResponseEntity<List<SearchLectureRes>> lectureList() {
    return ResponseEntity.ok(searchLectureService.search());
  }
}
