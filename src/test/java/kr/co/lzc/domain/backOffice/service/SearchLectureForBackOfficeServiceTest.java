package kr.co.lzc.domain.backOffice.service;

import kr.co.lzc.domain.backOffice.dto.searchLecture.SearchLectureForBackOfficeRes;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchLectureForBackOfficeServiceTest {

  @Autowired
  public SearchLectureForBackOfficeService searchLectureForBackOfficeService;


  @Test
  @DisplayName("전체목록 조회")
  void success() {
    List<SearchLectureForBackOfficeRes> result = searchLectureForBackOfficeService.search();

    assertNotNull(result);
  }


}