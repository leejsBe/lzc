package kr.co.lzc.domain.backOffice.dto.searchLecture;

import kr.co.lzc.domain.entity.Lecture;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
public class SearchLectureForBackOfficeRes {

  private final String lectureName;
  private final String lecturer;
  private final int maxApplicant;
  private final LocalDateTime lectureTime;
  private final String contents;
  private final String hallName;
  private final boolean deleted;

  public SearchLectureForBackOfficeRes(Lecture lecture) {
    this.lectureName = lecture.getName();
    this.lecturer = lecture.getLecturer();
    this.maxApplicant = lecture.getMaxApplicant();
    this.lectureTime = lecture.getTime();
    this.contents = lecture.getContents();
    this.hallName = lecture.getLectureHall().getName();
    this.deleted = !Objects.isNull(lecture.getDelAt());
  }

}
