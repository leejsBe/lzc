package kr.co.lzc.domain.backOffice.exception;

import kr.co.lzc.global.dto.ApiRes;
import kr.co.lzc.global.dto.ApiResStatus;
import kr.co.lzc.global.exception.ApiExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BackOfficeExceptionHandler extends ApiExceptionHandler {

  @ExceptionHandler(BackOfficeException.class)
  protected ResponseEntity<Object> handleCancelFeeExceptionHandler(BackOfficeException ex) {
    return buildResponseEntity(
      ApiRes.<Void>builder()
        .result(
          ApiResStatus.builder().success(false).code(ex.getCode()).message(ex.getMessage()).build()
        )
        .build()
    );
  }
}
