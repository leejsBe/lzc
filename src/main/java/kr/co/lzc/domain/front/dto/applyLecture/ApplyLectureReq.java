package kr.co.lzc.domain.front.dto.applyLecture;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApplyLectureReq {

  private final String employeeNo;
  private final long lectureId;

}
