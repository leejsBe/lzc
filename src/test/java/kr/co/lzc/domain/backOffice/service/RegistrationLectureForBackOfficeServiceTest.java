package kr.co.lzc.domain.backOffice.service;

import kr.co.lzc.domain.backOffice.dto.registrationLecture.RegistrationLectureForBackOfficeReq;
import kr.co.lzc.domain.entity.Lecture;
import kr.co.lzc.domain.repository.LectureRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegistrationLectureForBackOfficeServiceTest {

  @Autowired
  public RegistrationLectureForBackOfficeService registrationLectureForBackOfficeService;

  @Autowired
  public LectureRepo lectureRepo;

  @Test
  @DisplayName("강연 정상 등록")
  void success() {
    String lecturer = "홍길동";
    int maxApplicant = 45;
    String time = "2023-12-12 14:40";
    String contents = "테스트 강의 입니다.";

    RegistrationLectureForBackOfficeReq req = RegistrationLectureForBackOfficeReq.builder()
      .lectureHallId(1)
      .lecturerName(lecturer)
      .maxApplicant(maxApplicant)
      .time(time)
      .contents(contents)
      .build();


    Lecture savedLecture = registrationLectureForBackOfficeService.save(req);

    Lecture lecture = lectureRepo.findById(savedLecture.getId()).get();

    assertEquals(lecturer, lecture.getLecturer());
    assertEquals(maxApplicant, lecture.getMaxApplicant());
    assertEquals(LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), lecture.getTime());

    System.out.println(lecturer);
  }


}