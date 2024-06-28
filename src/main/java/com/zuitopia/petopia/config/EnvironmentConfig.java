package com.zuitopia.petopia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * 애플리케이션 환경 설정을 위한 구성 클래스
 * 프로퍼티 파일의 플레이스홀더를 지원하는 설정을 제공합니다.
 *
 * @version 1.0
 * @since 2024.06.27
 *
 * <pre>
 * 수정일         수정자              수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21       최유경               최초 생성
 * </pre>
 */
@Configuration
public class EnvironmentConfig {

    /**
     * 프로퍼티 파일의 플레이스홀더를 지원하는 빈을 생성
     *
     * @return PropertySourcesPlaceholderConfigurer 프로퍼티 소스를 위한 플레이스홀더 설정 객체
     * 메소드
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
