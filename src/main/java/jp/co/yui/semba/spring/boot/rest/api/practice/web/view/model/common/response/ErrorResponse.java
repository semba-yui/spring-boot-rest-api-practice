package jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.common.response;

import lombok.Getter;
import lombok.ToString;

/**
 * Error response.
 */
@Getter
@ToString
public final class ErrorResponse extends BaseResponse {

    /**
     * Constructor.
     *
     * @param code    Status code
     * @param message Message
     */
    public ErrorResponse(String code, String message) {
        super(code, message);
    }
}
