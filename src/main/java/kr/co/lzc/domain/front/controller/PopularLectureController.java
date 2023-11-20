package kr.co.lzc.domain.front.controller;


import io.swagger.v3.oas.annotations.Operation;
import kr.co.lzc.domain.front.dto.popularLecture.PopularLectureRes;
import kr.co.lzc.domain.front.service.PopularLectureService;
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
public class PopularLectureController {

  private final PopularLectureService popularLectureService;

  /**
   * 실시간 인기있는 강연 조회
   */
  @Operation(summary = "current popular lecture list", description = "실시간 인기있는 강연 조회")
  @GetMapping("/lecture/popular")
  public ResponseEntity<List<PopularLectureRes>> applyHistoryList() {
    return ResponseEntity.ok(popularLectureService.search());
  }
}
