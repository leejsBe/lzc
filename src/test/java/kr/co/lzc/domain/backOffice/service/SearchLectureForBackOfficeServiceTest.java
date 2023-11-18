package kr.co.lzc.domain.backOffice.service;

import kr.co.lzc.domain.backOffice.dto.searchLecture.SearchLectureForBackOfficeRes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SearchLectureForBackOfficeServiceTest {

  @Autowired
  public SearchLectureForBackOfficeService searchLectureForBackOfficeService;


  @Test
  @DisplayName("전체목록 조회")
  void success() {

    List<SearchLectureForBackOfficeRes> result = searchLectureForBackOfficeService.search();

    result.forEach(lecture -> System.out.println("강연 이름 : " + lecture.getLectureName() + " 강연장 : " + lecture.getHallName()));
    assertNotNull(result);
  }


}