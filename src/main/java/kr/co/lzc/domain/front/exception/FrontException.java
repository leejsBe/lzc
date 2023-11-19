package kr.co.lzc.domain.front.exception;

import kr.co.lzc.global.enumeration.ResCode;
import kr.co.lzc.global.exception.BasicException;

public class FrontException extends BasicException {

  public FrontException(ResCode resCode) {
    super(resCode);
  }

  public FrontException(ResCode resCode, String mesg) {
    super(resCode, mesg);
  }
}
