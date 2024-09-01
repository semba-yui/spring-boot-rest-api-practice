package jp.co.yui.semba.spring.boot.rest.api.practice.web.controller.v1.advice;

import jp.co.yui.semba.spring.boot.rest.api.practice.application.enums.ErrorCode;
import jp.co.yui.semba.spring.boot.rest.api.practice.application.exception.DemoApplicationException;
import jp.co.yui.semba.spring.boot.rest.api.practice.application.exception.DemoSystemException;
import jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * Handle method argument not valid exception.
     *
     * @param e Exception
     * @return Error response
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        log.error("Method argument not valid error occurred.", e);

        val response = new ErrorResponse(ErrorCode.BAD_REQUEST.name(), ErrorCode.BAD_REQUEST.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle demo application exception.
     *
     * @param e Exception
     * @return Error response
     */
    @ExceptionHandler(DemoApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleDemoApplicationException(DemoApplicationException e) {

        log.error("Demo application error occurred.", e);

        val response = new ErrorResponse(ErrorCode.APPLICATION_ERROR.name(), ErrorCode.APPLICATION_ERROR.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle demo system exception.
     *
     * @param e Exception
     * @return Error response
     */
    @ExceptionHandler(DemoSystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleDemoSystemException(DemoSystemException e) {

        log.error("Demo system error occurred.", e);

        val response = new ErrorResponse(ErrorCode.SYSTEM_ERROR.name(), ErrorCode.SYSTEM_ERROR.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle unknown exception.
     *
     * @param e Exception
     * @return Error response
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {

        log.error("Unknown error occurred.", e);

        val response = new ErrorResponse(ErrorCode.UNEXPECTED_ERROR.name(), ErrorCode.UNEXPECTED_ERROR.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
