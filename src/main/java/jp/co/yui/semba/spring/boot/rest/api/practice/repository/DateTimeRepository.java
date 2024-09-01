package jp.co.yui.semba.spring.boot.rest.api.practice.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Repository
@AllArgsConstructor
public class DateTimeRepository {

    public LocalDateTime getLocalDateTimeNow() {
        return LocalDateTime.now();
    }

    public OffsetDateTime getOffsetDateTimeNow() {
        return OffsetDateTime.now();
    }
}
