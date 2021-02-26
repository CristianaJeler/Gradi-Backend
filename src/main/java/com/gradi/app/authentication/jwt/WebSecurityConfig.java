package com.gradi.app.authentication.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("userDetailServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtValues jwtValues;


    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                    .and()
                .csrf()
                    .disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                // handle unauthorized attempts
                .exceptionHandling()
                    .authenticationEntryPoint((req, rsp, e)
                            -> {
                        rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
                        System.out.println(e.getMessage());
                    })
                    .and()
                // Add a filter to validate user credentials and add token in the response header

                .authorizeRequests()
                // allow all POST requests
                .antMatchers("/",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html")
                .permitAll()
                .antMatchers("/gradi/authentication/login")
                    .permitAll()
                .antMatchers("/gradi/authentication/signup")
                    .permitAll()

                // any other requests must be authenticated
                .anyRequest()
                .authenticated();
        http.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    // Spring has UserDetailsService interface, which can be overriden to provide our implementation for fetching user from database (or any other source).
    // The UserDetailsService object is used by the auth manager to load the user from database.
    // In addition, we need to define the password encoder also. So, auth manager can compare and verify passwords.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCrypt());
    }

    @Bean
    public PasswordEncoder bCrypt(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthFilter jwtFilter() {
        return new JwtAuthFilter();
    }

}
