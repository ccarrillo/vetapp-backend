package com.vetapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.vetapp.service.CustomUserDetailsSService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsSService userService;

    @Autowired
    private JWTTokenHelper jWTTokenHelper;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v3 (OpenAPI)
            "/h2-console/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            // -- Public endpoints of your API
            "/login/token"
    };

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin@123"))
				.authorities("USER", "ADMIN");

		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

	}*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint).and()
                .authorizeRequests((request) -> request
                        .antMatchers(AUTH_WHITELIST).permitAll()
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(new JWTAuthenticationFilter(userService, jWTTokenHelper),
                        UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable().cors().and().headers().frameOptions().disable();

    }
}
