package kr.co.lzc.global.exception;

import kr.co.lzc.global.dto.ApiErrorRes;
import kr.co.lzc.global.dto.ApiRes;
import kr.co.lzc.global.enumeration.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  protected ResponseEntity<Object> buildResponseEntity(ApiRes<Void> resultDto) {
    return ResponseEntity.ok(resultDto);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    return new ResponseEntity<>(ApiErrorRes.builder()
      .status(status)
      .message(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage())
      .code(ErrorCode.VALID_ERROR.getCode()).build(), status);
  }


  @ExceptionHandler(BasicException.class)
  protected ResponseEntity<Object> handleBasicException(BasicException ex) {
    log.info("-- BasicException 발생..!!", ex);
    return new ResponseEntity<>(ApiErrorRes.builder()
      .status(HttpStatus.BAD_REQUEST)
      .message(ex.getMessage())
      .code(ErrorCode.VALID_ERROR.getCode()).build(), HttpStatus.BAD_REQUEST);
  }

}
