package kr.co.lzc.domain.backOffice.service;

import kr.co.lzc.domain.backOffice.dto.searchLecture.SearchLectureForBackOfficeRes;
import kr.co.lzc.domain.repository.LectureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLectureForBackOfficeService {


  private final LectureRepo lectureRepo;


  public List<SearchLectureForBackOfficeRes> search() {

    return null;
  }


}
