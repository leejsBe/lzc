package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.front.dto.popularLecture.PopularLectureRes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PopularLectureServiceTest {


  @Autowired
  public PopularLectureService popularLectureService;


  @Test
  @DisplayName("실시간 인기 강연 조회")
  void success() {

    Assertions.assertDoesNotThrow(() -> {
      List<PopularLectureRes> result = popularLectureService.search();
      Assertions.assertNotNull(result);
      if (result.size() == 0) {
        throw new Exception();
      }

      int applyCount = Integer.MAX_VALUE;

      for (PopularLectureRes popularLectureRes : result) {
        if (applyCount < popularLectureRes.getReservedCount()) {
          throw new Exception();
        }

        applyCount = popularLectureRes.getReservedCount();
      }
    });
  }
}