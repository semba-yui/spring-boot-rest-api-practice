package jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Base response.
 */
@Getter
@ToString
@AllArgsConstructor
public abstract sealed class BaseResponse implements Serializable permits SuccessResponse, ErrorResponse {

    /**
     * Status code.
     */
    private final String code;

    /**
     * Message.
     */
    private final String message;
}
