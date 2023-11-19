package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.front.dto.searchLecture.SearchLectureRes;
import kr.co.lzc.domain.repository.LectureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLectureService {

  private final LectureRepo lectureRepo;


  /**
   * 강연 목록 조회
   */
  public List<SearchLectureRes> search() {
    List<Lecture> lectures = lectureRepo.findAll();
    

    return null;
  }

}
