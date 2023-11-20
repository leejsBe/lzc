package kr.co.lzc.domain.front.enumeration;

import kr.co.lzc.global.enumeration.ResCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FrontResCode implements ResCode {

  NOT_FOUND_LECTURE("F001", "Not found lecture."),
  NOT_FOUND_EMPLOYEE("F002", "Not found employee.");

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