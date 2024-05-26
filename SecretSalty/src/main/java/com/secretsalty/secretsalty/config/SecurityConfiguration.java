package com.secretsalty.secretsalty.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class SecurityConfiguration {

  // TODO: add to cfg file
  private static final List<String> ALLOWED_ORIGINS =
      List.of(
          "http://localhost:4200",
          "http://localhost:8080",
          "http://saltybots.xyz",
          "https://saltybots.xyz");
  private static final List<String> ALLOW_ALL = List.of(CorsConfiguration.ALL);

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors(
            httpSecurityCorsConfigurer ->
                httpSecurityCorsConfigurer.configurationSource(
                    request -> {
                      final var corsConfiguration = new CorsConfiguration();
                      corsConfiguration.setAllowedMethods(ALLOW_ALL);
                      corsConfiguration.setAllowedHeaders(ALLOW_ALL);
                      corsConfiguration.setAllowedOrigins(ALLOWED_ORIGINS);
                      return corsConfiguration;
                    }))
        .authorizeHttpRequests(
            authz ->
                authz
                    .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
        .csrf(AbstractHttpConfigurer::disable);

    return http.build();
  }
}
