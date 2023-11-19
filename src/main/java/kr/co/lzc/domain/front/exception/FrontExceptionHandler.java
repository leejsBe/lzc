package kr.co.lzc.domain.front.exception;

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
public class FrontExceptionHandler extends ApiExceptionHandler {

  @ExceptionHandler(FrontException.class)
  protected ResponseEntity<Object> handleCancelFeeExceptionHandler(FrontException ex) {
    return buildResponseEntity(
      ApiRes.<Void>builder()
        .result(
          ApiResStatus.builder().success(false).code(ex.getCode()).message(ex.getMessage()).build()
        )
        .build()
    );
  }
}
