package jp.co.yui.semba.spring.boot.rest.api.practice.web.controller.v1;

import jp.co.yui.semba.spring.boot.rest.api.practice.service.v1.user.DeleteUserByIdV1Service;
import jp.co.yui.semba.spring.boot.rest.api.practice.service.v1.user.PostCreateUserV1Service;
import jp.co.yui.semba.spring.boot.rest.api.practice.service.v1.user.UpdateUserV1Service;
import jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.v1.request.user.PutUserRequest;
import jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.v1.request.user.create.post.CreateUserRequest;
import jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.v1.response.user.create.post.CreateUserData;
import jp.co.yui.semba.spring.boot.rest.api.practice.web.view.model.v1.response.user.create.post.CreateUserResponse;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * ユーザーコントローラー.
 */
@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserV1Controller {

    /**
     * ユーザー作成サービス.
     */
    private final PostCreateUserV1Service createUserService;

    /**
     * ユーザー削除サービス.
     */
    private final DeleteUserByIdV1Service deleteUserByIdService;

    /**
     * ユーザー更新サービス.
     */
    private final UpdateUserV1Service updateUserService;

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Validated CreateUserRequest request) {

        val userEntity = createUserService.execute();

        val response = new CreateUserResponse("User created successfully.", new CreateUserData(userEntity.getUserId()));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(("/{userId}"))
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void put(@PathVariable Long userId, @RequestBody @Validated PutUserRequest request) {

        updateUserService.execute(userId);
    }

    @DeleteMapping(("/{userId}"))
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) {

        deleteUserByIdService.execute(userId);
    }
}
