package jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Success response.
 *
 * @param <T> Data type
 */
@Getter
@ToString
public non-sealed class SuccessResponse<T> extends BaseResponse {

    private static final String SUCCESS_CODE = "SUCCESS";

    /**
     * Data.
     */
    private final T data;

    /**
     * Constructor.
     *
     * @param data Data
     */
    @Builder
    public SuccessResponse(String message, T data) {
        super(SUCCESS_CODE, message);
        this.data = data;
    }
}
