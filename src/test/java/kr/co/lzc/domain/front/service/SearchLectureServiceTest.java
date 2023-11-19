package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.LectureHall;
import kr.co.lzc.domain.front.dto.searchLecture.SearchLectureRes;
import kr.co.lzc.domain.repository.LectureHallRepo;
import kr.co.lzc.domain.repository.LectureRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
class SearchLectureServiceTest {


  @Autowired
  public LectureHallRepo lectureHallRepo;

  @Autowired
  public LectureRepo lectureRepo;

  @Autowired
  public SearchLectureService searchLectureService;

  @BeforeEach
  public void ready() {
    /// 테스트 데이터 저장

    lectureHallRepo.save(LectureHall.builder().build());

    /// 강연 시작 +8일 후 데이터


  }


  @DisplayName("강연 목록 테스트")
  @ParameterizedTest(name = "{0}/ 원하는 결과: {1}")
  @MethodSource("validParams")
  public void searchTest(String when, String then) {
    // WHEN
    //    SearchCancelFeeRes res = searchCancelFeeService.search(req);
    //    System.out.println(res);


    // THEN
    Assertions.assertDoesNotThrow(() -> {
      List<SearchLectureRes> result = searchLectureService.search();
      result.forEach(System.out::println);
    });
  }


  private static Stream<Arguments> validParams() {
    return Stream.of(
      Arguments.of("목록 검색", "수수료 100%")
    );
  }


}