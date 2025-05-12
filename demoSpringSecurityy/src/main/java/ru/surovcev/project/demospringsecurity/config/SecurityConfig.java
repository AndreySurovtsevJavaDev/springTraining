package ru.surovcev.project.demospringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * В данном классе определяются правила доступа к различным URL и ресурсам,
 * а также настраиваются механизмы аутентификации и авторизации.
 */

@Configuration
/**
 *  @EnableWebSecurity нужна для включения поддержки безопасности веб-приложения.
 *  Это позволяет создать экземпляр фильтра безопасности и зарегистрировать его в контейнере сервлетов
 */
@EnableWebSecurity
public class SecurityConfig {

    /**
     * SecurityFilterChain - главный бин безопасности
     * Spring Security ищет бин типа SecurityFilterChain для настройки всей цепочки фильтров безопасности
     * Без этого бина безопасность не будет работать вообще
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults()); // или httpBasic()
        return http.build();
    }

    /**
     * UserDetailsService - сервис пользователей
     * Spring Security требует бин типа UserDetailsService для работы механизма аутентификации
     * Без него система не будет знать, как искать пользователей
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    /**
     * PasswordEncoder - кодировщик паролей
     * Spring Security требует бин PasswordEncoder для безопасного хранения паролей
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
