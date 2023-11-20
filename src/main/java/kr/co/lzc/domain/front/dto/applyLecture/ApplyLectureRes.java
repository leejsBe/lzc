package kr.co.lzc.domain.front.dto.applyLecture;

import kr.co.lzc.domain.entity.Registration;
import lombok.Getter;

@Getter
public class ApplyLectureRes {

  private final long bookNo;


  public ApplyLectureRes(Registration registration) {
    this.bookNo = registration.getId();
  }
}
