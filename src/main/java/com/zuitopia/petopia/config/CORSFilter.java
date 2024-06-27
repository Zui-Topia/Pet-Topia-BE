package com.zuitopia.petopia.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * CORS(Cross-Origin Resource Sharing) 설정을 위한 필터 클래스입니다.
 * 모든 도메인에 대해 CORS를 허용하며, 다양한 HTTP 메소드와 헤더를 지원합니다.
 *
 * @version 1.0
 * @since 2024.06.18
 *
 * <pre>
 * 수정일         수정자              수정내용
 * ----------  ----------------    ---------------------------------
 * 2024.06.21       임재성               Header 권한 허용
 * 2024.06.18       최유경               최초 생성
 * </pre>
 */
public class CORSFilter implements Filter {

    /**
     * CORS 설정을 위한 필터 메소드
     * 요청과 응답을 처리하며, 필요한 CORS 헤더를 설정
     *
     * @param req 서블릿 요청 객체
     * @param res 서블릿 응답 객체
     * @param chain 필터 체인 객체
     * @throws IOException 입출력 예외
     * @throws ServletException 서블릿 예외
     * 메소드
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept, Authorization");
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        chain.doFilter(req, res);
    }

    /**
     * 필터 초기화 메소드
     *
     * @param filterConfig 필터 설정 객체
     * 메소드
     */
    @Override
    public void init(FilterConfig filterConfig) {}

    /**
     * 필터 종료 메소드
     * 메소드
     */
    @Override
    public void destroy() {}
}
