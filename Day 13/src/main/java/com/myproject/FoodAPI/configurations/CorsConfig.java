package com.myproject.FoodAPI.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

//    @Bean
//    public UserDetailsManager userDetailManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/api/beverageoptions").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/api/beverageoptions/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/api/beverageoptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/api/beverageoptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/api/beverageoptions/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/bowloptions").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/api/bowloptions/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/api/bowloptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/api/bowloptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/api/bowloptions/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/desertoptions").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/api/desertoptions/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/api/desertoptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/api/desertoptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/api/desertoptions/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/pastaoptions").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/api/pastaoptions/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/api/pastaoptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/api/pastaoptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/api/pastaoptions/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/pizzaoptions").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET, "/api/pizzaoptions/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST, "/api/pizzaoptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT, "/api/pizzaoptions").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE, "/api/pizzaoptions/**").hasRole("ADMIN"));
//        // use HTTP Basic authentication
//        http.httpBasic(Customizer.withDefaults());
//        // disable Cross Site Request Forgery (CSRF)
//        http.csrf(csrf -> csrf.disable());
//        return http.build();
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
