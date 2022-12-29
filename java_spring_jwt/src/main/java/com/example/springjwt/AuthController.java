package com.example.springjwt;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
record AuthController(AuthService service) {

    @PostMapping("/login")
    public AuthResponse login(final HttpServletResponse httpServletResponse, @RequestBody final AuthRequest request) {
        final String token = service.getToken(request.getId());
        log.info("token:{}", token);
        final Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(1200);
        httpServletResponse.addCookie(cookie);

        final AuthResponse response = new AuthResponse();
        response.setStatus(HttpStatus.OK.value());
        return response;
    }

    @GetMapping("/verify")
    public AuthResponse verify(@CookieValue(name = "token", defaultValue = "") final String token) {
        log.info("token:{}", token);
        final String requestId = service.verify(token);
        log.info("requestId:{}", requestId);

        final AuthResponse response = new AuthResponse();
        if (requestId.isEmpty()) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        } else {
            response.setStatus(HttpStatus.OK.value());
            response.setData(Map.of("id", requestId));
        }
        return response;
    }

    @GetMapping("/logout")
    public AuthResponse logout(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) {
        final Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                cookie.setMaxAge(0);
                httpServletResponse.addCookie(cookie);
            }
        }

        final AuthResponse response = new AuthResponse();
        response.setStatus(HttpStatus.OK.value());
        return response;
    }

}
