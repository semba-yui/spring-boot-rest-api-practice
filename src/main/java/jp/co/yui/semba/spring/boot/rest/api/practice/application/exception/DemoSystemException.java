package jp.co.yui.semba.spring.boot.rest.api.practice.application.exception;

import jp.co.yui.semba.spring.boot.rest.api.practice.application.enums.ErrorCode;

public class DemoSystemException extends RuntimeException {

    public DemoSystemException(Throwable e, ErrorCode errorCode) {
        super(errorCode.getMessage(), e);
    }

    public DemoSystemException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
