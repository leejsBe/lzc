package kr.co.lzc.domain.front.dto.popularLecture;

import kr.co.lzc.domain.entity.Lecture;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class PopularLectureRes {


  private final String lectureName;
  private final String lecturer;
  private final String lectureHallName;
  private final String lectureTime;

  private final long reservedCount;

  public PopularLectureRes(Lecture lecture, long count) {
    this.lectureName = lecture.getName();
    this.lecturer = lecture.getLecturer();
    this.lectureHallName = lecture.getLectureHall().getName();
    this.lectureTime = lecture.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    this.reservedCount = count;
  }

}
