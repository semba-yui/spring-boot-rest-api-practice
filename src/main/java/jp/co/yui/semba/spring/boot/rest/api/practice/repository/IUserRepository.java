package jp.co.yui.semba.spring.boot.rest.api.practice.repository;

import jp.co.yui.semba.spring.boot.rest.api.practice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
