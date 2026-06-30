package com.devfullstack_david.sendbox_server.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.devfullstack_david.sendbox_server.service.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TokenInterceptor extends OncePerRequestFilter {
  private final TokenService tokenService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.equals("/api/administrators/login")
          || (requestURI.equals("/api/administrators") && request.getMethod().equals("POST"))) {
          filterChain.doFilter(request, response);
          return;
        }

        String token = recoverToken(request);

        if (token != null) {
            String username = tokenService.validateToken(token);

            if (!username.isEmpty()) {
                request.setAttribute("user", username);
                filterChain.doFilter(request, response);
                return;
            }
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"error\": \"Invalid token\"}");
    }

    private String recoverToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
