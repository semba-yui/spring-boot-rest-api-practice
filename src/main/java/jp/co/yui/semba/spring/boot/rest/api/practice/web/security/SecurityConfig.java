package jp.co.yui.semba.spring.boot.rest.api.practice.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    /**
     * HSTSポリシーをキャッシュして適用する最大時間(秒数).<br>
     * 1年である365日(= 31536000秒) を秒単位で設定
     */
    private static final long HSTS_MAX_AGE_SECONDS = TimeUnit.DAYS.toSeconds(365);

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz
                        .requestMatchers("/actuator/**").permitAll()
                        .anyRequest().permitAll()
                )
                // CSRF無効
                .csrf(AbstractHttpConfigurer::disable)

                // ステートレス
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 各種ヘッダーの有効化
                .headers(
                        headers ->
                                headers
                                        // CSP設定
                                        .contentSecurityPolicy(csp -> csp.policyDirectives("default-src 'self'"))
                                        // HSTS設定
                                        .httpStrictTransportSecurity(
                                                hsts ->
                                                        hsts.maxAgeInSeconds(HSTS_MAX_AGE_SECONDS).includeSubDomains(true)));
        return http.build();
    }
}
