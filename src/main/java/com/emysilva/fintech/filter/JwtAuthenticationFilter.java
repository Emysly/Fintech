//package com.emysilva.fintech.filter;
//
//import com.emysilva.fintech.service.util.JwtUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtUtils jwtUtils;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String jwt = getJwtFromRequest(request);
//
//        if (jwt != null && )
//        filterChain.doFilter(request, response);
//    }
//
//    private String getJwtFromRequest(HttpServletRequest httpServletRequest) {
//        String authorization = httpServletRequest.getHeader("Authorization");
//
//        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
//            return authorization.substring(7);
//        }
//        return null;
//    }
//}
