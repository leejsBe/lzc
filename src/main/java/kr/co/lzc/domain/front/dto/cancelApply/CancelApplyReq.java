package kr.co.lzc.domain.front.dto.cancelApply;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CancelApplyReq {

  private final long bookNo;
}
