package jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.v1.response.user.create.post;

import jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.common.response.SuccessResponse;
import lombok.Getter;
import lombok.ToString;

/**
 * Response for creating a user.
 */
@Getter
@ToString
public final class CreateUserResponse extends SuccessResponse<CreateUserData> {

    public CreateUserResponse(String message, CreateUserData data) {
        super(message, data);
    }
}
