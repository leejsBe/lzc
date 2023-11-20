package kr.co.lzc.domain.front.service;

import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureReq;
import kr.co.lzc.domain.front.dto.applyLecture.ApplyLectureRes;
import kr.co.lzc.domain.repository.LectureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyLectureService {

  private final LectureRepo lectureRepo;


  public ApplyLectureRes apply(ApplyLectureReq applyLectureReq) {

    return null;
  }

}
