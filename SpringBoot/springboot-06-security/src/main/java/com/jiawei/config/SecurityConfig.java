package com.jiawei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/","/userlogin").permitAll()
                .requestMatchers("/level1/**").hasRole("vip1")
                .requestMatchers("/level2/**").hasRole("vip2")
                .requestMatchers("/level3/**").hasRole("vip3");
        http.formLogin().loginPage("/userlogin").loginProcessingUrl("/loginUrl").successForwardUrl("/");
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");

        http.rememberMe().rememberMeParameter("remember");
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        // ensure the passwords are encoded properly
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("jiawei").password("123456").roles("vip2","vip3").build());
        manager.createUser(users.username("root").password("123456").roles("vip1","vip2","vip3").build());
        manager.createUser(users.username("guest").password("123456").roles("vip1").build());
        return manager;
    }

}