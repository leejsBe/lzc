package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.front.dto.popularLecture.PopularLectureRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PopularLectureService {


  /**
   * 3일간 인기가 가장 많은 순서로 강연 리스트 조회
   */
  public List<PopularLectureRes> search() {

    return null;
  }

}
