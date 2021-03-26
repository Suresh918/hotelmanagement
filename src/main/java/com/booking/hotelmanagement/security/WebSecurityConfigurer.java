package com.booking.hotelmanagement.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/h2-console/**", "/actuator/**").permitAll()
                .anyRequest().authenticated()
                /* .and()
                 .formLogin()
                 .loginPage("/login")
                 .permitAll()*/
                .and().headers().frameOptions().sameOrigin()
                .and()
                .logout()
                .permitAll();

        http.formLogin();
        http.httpBasic();
    }

    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/
}
