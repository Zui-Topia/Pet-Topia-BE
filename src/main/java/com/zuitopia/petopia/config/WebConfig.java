package com.zuitopia.petopia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 웹 애플리케이션의 CORS(Cross-Origin Resource Sharing) 설정을 위한 구성 클래스입니다.
 * 특정 출처에서의 요청을 허용하는 설정을 제공합니다.
 *
 * @author 최유경
 * @author 임재성
 * @since 2024.06.18
 *
 * <pre>
 * 수정일             수정자                      수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21       임재성                  모든 헤더 허용 설정 추가
 * 2024.06.18       최유경                      최초 생성
 * </pre>
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /**
     * @apiNote CORS 매핑을 추가하는 메소드
     *          모든 경로에 대해 모든 출처에서의 GET, POST, DELETE, PUT 메소드를 허용
     * @param registry CorsRegistry 객체
     *
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*") // 모든 헤더를 허용하도록 설정 추가
                .allowCredentials(false);
    }
}
