package kr.co.lzc.domain.backOffice.dto.registrationLecture;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegistrationLectureForBackOfficeReq {

  private long lectureHallId;
  private String lecturerName;
  private int maxApplicant;
  private String time;
  private String contents;

}
