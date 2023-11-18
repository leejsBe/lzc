package kr.co.lzc.global.dto;

import kr.co.lzc.global.enumeration.ResCode;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiRes<T> {

  private ApiResStatus result;

  private T data;

  public ApiRes(boolean success, T data) {
    this.result = ApiResStatus.builder().success(success).build();
    this.data = data;
  }


  public ApiRes(ResCode resCode) {
    this.result = ApiResStatus.builder()
      .success(false)
      .code(resCode.code())
      .message(resCode.msg())
      .build();
  }
}
