package kr.co.lzc.domain.backOffice.service;

import kr.co.lzc.domain.backOffice.dto.searchLecture.SearchLectureForBackOfficeRes;
import kr.co.lzc.domain.repository.LectureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchLectureForBackOfficeService {


  private final LectureRepo lectureRepo;


  @Transactional
  public List<SearchLectureForBackOfficeRes> search() {
    return lectureRepo.findAll().stream().map(SearchLectureForBackOfficeRes::new).toList();
  }


}
