package kr.co.lzc.domain.backOffice.service;

import kr.co.lzc.domain.backOffice.dto.registrationLecture.RegistrationLectureForBackOfficeReq;
import kr.co.lzc.domain.backOffice.enumeration.BackOfficeResCode;
import kr.co.lzc.domain.backOffice.exception.BackOfficeException;
import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.entity.LectureHall;
import kr.co.lzc.domain.repository.LectureHallRepo;
import kr.co.lzc.domain.repository.LectureRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class RegistrationLectureForBackOfficeService {

  private final LectureHallRepo lectureHallRepo;
  private final LectureRepo lectureRepo;


  @Transactional
  public void save(RegistrationLectureForBackOfficeReq registrationLectureForBackOfficeReq) {
    LectureHall lectureHall = lectureHallRepo.findById(registrationLectureForBackOfficeReq.getLectureHallId())
      .orElseThrow(() -> new BackOfficeException(BackOfficeResCode.NOT_FOUND_LECTURE_HALL));


    lectureRepo.save(Lecture.builder()
      .lectureHall(lectureHall)
      .lecturer(registrationLectureForBackOfficeReq.getLecturerName())
      .maxApplicant(registrationLectureForBackOfficeReq.getMaxApplicant())
      .time(LocalDateTime.parse(registrationLectureForBackOfficeReq.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
      .contents(registrationLectureForBackOfficeReq.getContents())
      .build());
  }
}
