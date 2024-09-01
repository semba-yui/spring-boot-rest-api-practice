package jp.co.yui.semba.spring.boot.rest.api.practice.application.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    BAD_REQUEST("リクエストが不正です。"),
    AUTHENTICATION_ERROR("認証エラーが発生しました。"),
    UNAUTHORIZED("認可エラーが発生しました。"),
    NOT_FOUND("リソースが見つかりません。"),
    CONFLICT("リクエストが競合しています。"),
    ALREADY_EXISTS("リソースが既に存在します。"),
    APPLICATION_ERROR("アプリケーションエラーが発生しました。"),
    SYSTEM_ERROR("システムエラーが発生しました。"),
    UNEXPECTED_ERROR("予期せぬエラーが発生しました。");

    private final String message;
}
