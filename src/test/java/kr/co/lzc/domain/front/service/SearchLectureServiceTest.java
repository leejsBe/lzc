package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.entity.LectureHall;
import kr.co.lzc.domain.front.dto.searchLecture.SearchLectureRes;
import kr.co.lzc.domain.repository.LectureHallRepo;
import kr.co.lzc.domain.repository.LectureRepo;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
  void ready() {
    /// 테스트 데이터 저장
    LectureHall lectureHall = lectureHallRepo.save(LectureHall.builder()
      .name("테스트 강연장55")
      .createAt(LocalDateTime.now())
      .build());

    /// 강연 시작 +8일 후 데이터
    Lecture lecture = lectureRepo.save(Lecture.builder()
      .name("8일 후 강연")
      .lecturer("테스트 강연자 55")
      .maxApplicant(3)
      .time(LocalDateTime.now().plusDays(8))
      .contents("테스트 강연 내용 55")
      .lectureHall(lectureHall)
      .createAt(LocalDateTime.now())
      .build());

  }


  @DisplayName("강연 목록 테스트")
  @ParameterizedTest(name = "{0}/ 원하는 결과: {1}")
  @MethodSource("validParams")
  void searchTest(String when, String then) {
    // WHEN
    //    SearchCancelFeeRes res = searchCancelFeeService.search(req);
    //    System.out.println(res);


    // THEN
    Assertions.assertDoesNotThrow(() -> {
      List<SearchLectureRes> result = searchLectureService.search();
      result.forEach(System.out::println);

      result.stream().filter(lecture -> StringUtils.equals(then, lecture.getName()));
      if (result.size() != 0) {
        throw new Exception();
      }
    });
  }


  private static Stream<Arguments> validParams() {
    return Stream.of(
      Arguments.of("목록 검색", "8일 후 강연은 노출 X")
    );
  }


}