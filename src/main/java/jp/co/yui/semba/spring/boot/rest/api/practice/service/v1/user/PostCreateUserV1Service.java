package jp.co.yui.semba.spring.boot.rest.api.practice.service.v1.user;

import jp.co.yui.semba.spring.boot.rest.api.practice.entity.UserEntity;
import jp.co.yui.semba.spring.boot.rest.api.practice.repository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

/**
 * Create user service.
 */
@Service
@AllArgsConstructor
public class PostCreateUserV1Service {

    /**
     * User repository.
     */
    private final IUserRepository userRepository;

    /**
     * Create a user.
     *
     * @return User entity.
     */
    public UserEntity execute() {

        val user = new UserEntity();
        user.setUserId(1L);

        return user;
    }
}
