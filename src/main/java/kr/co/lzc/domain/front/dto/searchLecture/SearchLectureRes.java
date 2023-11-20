package kr.co.lzc.domain.front.dto.searchLecture;

import kr.co.lzc.domain.entity.Lecture;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class SearchLectureRes {


  private final String lectureName;
  private final String lecturer;
  private final int maxApplicant;
  private final String time;
  private final String contents;

  private final String lectureHallName;


  public SearchLectureRes(Lecture lecture) {
    this.lectureName = lecture.getName();
    this.lecturer = lecture.getLecturer();
    this.maxApplicant = lecture.getMaxApplicant();
    this.time = lecture.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    this.contents = lecture.getContents();
    this.lectureHallName = lecture.getLectureHall().getName();
  }

}
