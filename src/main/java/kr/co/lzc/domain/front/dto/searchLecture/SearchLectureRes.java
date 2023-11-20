package kr.co.lzc.domain.front.dto.searchLecture;

import kr.co.lzc.domain.entity.Lecture;
import lombok.Getter;

@Getter
public class SearchLectureRes {


  private final String name;
  private final String lecturer;


  public SearchLectureRes(Lecture lecture) {
    this.name = lecture.getName();
    this.lecturer = lecture.getLecturer();
  }

}
