package jp.co.yui.semba.spring.boot.rest.api.practice.service.v1.user;

import jp.co.yui.semba.spring.boot.rest.api.practice.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteUserByIdV1Service {

    /**
     * User repository.
     */
    private final IUserRepository userRepository;

    public void execute(Long userId) {
//        userRepository.deleteById(userId);
    }
}
