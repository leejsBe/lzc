package kr.co.lzc.global.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResStatus {
  @Schema(description = "요청에 대한 성공/실패 여부")
  private boolean success;

  @Builder.Default
  @Schema(description = "응담 메세지(에러 발생 시)")
  private String message = "OK";

  @Builder.Default
  @Schema(description = "응답 코드(성공 시 00000)")
  private String code = "00000";
}
