package kr.co.lzc.domain.front.dto.popularLecture;

import lombok.Getter;

@Getter
public class PopularLectureRes {


  private String lectureName;
  private String lecturer;
  private String lectureHallName;
  private String lectureTime;

  private int reservedCount;

  public PopularLectureRes() {

  }

}
