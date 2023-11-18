package kr.co.lzc.domain.backOffice.exception;

import kr.co.lzc.global.enumeration.ResCode;
import kr.co.lzc.global.exception.BasicException;

public class BackOfficeException extends BasicException {

  public BackOfficeException(ResCode resCode) {
    super(resCode);
  }

  public BackOfficeException(ResCode resCode, String mesg) {
    super(resCode, mesg);
  }
}
