package kr.co.lzc.domain.backOffice.enumeration;

import kr.co.lzc.global.enumeration.ResCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BackOfficeResCode implements ResCode {

  NOT_FOUND_LECTURE_HALL("B001", "Not found lecture hall.");

  private final String code;
  private final String msg;

  @Override
  public String msg() {
    return this.msg;
  }

  @Override
  public String code() {
    return this.code;
  }
}
