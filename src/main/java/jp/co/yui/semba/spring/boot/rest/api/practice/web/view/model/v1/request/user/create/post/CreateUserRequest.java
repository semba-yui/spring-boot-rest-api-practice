package jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.v1.request.user.create.post;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CreateUserRequest implements Serializable {

    /**
     * ユーザー名.
     */
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    /**
     * ユーザーアドレス.
     */
    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    /**
     * パスワード.
     */
    @NotBlank
    @Size(min = 8, max = 100)
    private String password;
}
