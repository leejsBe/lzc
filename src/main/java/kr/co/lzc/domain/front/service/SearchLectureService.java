package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.front.dto.searchLecture.SearchLectureRes;
import kr.co.lzc.domain.repository.LectureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLectureService {

  private final LectureRepo lectureRepo;


  /**
   * 강연 목록 조회
   * 신청 가능한 시점부터 강연시작시간 1일 후 까지 노출
   */
  public List<SearchLectureRes> search() {
    List<Lecture> lectures = lectureRepo.findAllByTime(
      LocalDateTime.now().plusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
      LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    return lectures.stream().map(SearchLectureRes::new).toList();
  }

}
