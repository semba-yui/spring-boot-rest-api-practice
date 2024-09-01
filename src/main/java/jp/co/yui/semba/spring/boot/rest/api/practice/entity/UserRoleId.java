package jp.co.yui.semba.spring.boot.rest.api.practice.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class UserRoleId implements Serializable {

    private Long userId;

    private Long roleId;
}
