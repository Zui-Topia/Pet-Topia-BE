package com.zuitopia.petopia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 애플리케이션 보안 설정을 위한 구성 클래스입니다.
 * 비밀번호 암호화를 위한 설정을 제공합니다.
 *
 * @version 1.0
 * @since 2024.06.20
 *
 * <pre>
 * 수정일         수정자              수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.20       임재성               최초 생성
 * </pre>
 */
@Configuration
public class SecurityConfig {

    /**
     * 비밀번호 암호화를 위한 PasswordEncoder 빈을 생성
     *
     * @return PasswordEncoder 비밀번호 암호화를 위한 BCryptPasswordEncoder 객체
     * 메소드
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
