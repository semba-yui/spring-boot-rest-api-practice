package jp.co.yui.semba.spring.boot.rest.api.practice.application.exception;

import jp.co.yui.semba.spring.boot.rest.api.practice.application.enums.ErrorCode;

public class DemoApplicationException extends RuntimeException {

    public DemoApplicationException(Throwable e, ErrorCode errorCode) {
        super(errorCode.getMessage(), e);
    }

    public DemoApplicationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
