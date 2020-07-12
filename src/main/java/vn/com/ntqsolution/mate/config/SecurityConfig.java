package vn.com.ntqsolution.mate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;
import vn.com.ntqsolution.mate.security.jwt.JWTConfigurer;
import vn.com.ntqsolution.mate.security.jwt.TokenProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final CorsFilter corsFilter;

  private final TokenProvider tokenProvider;

  public SecurityConfig(CorsFilter corsFilter, TokenProvider tokenProvider) {
    this.corsFilter = corsFilter;
    this.tokenProvider = tokenProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
      .csrf()
      .disable()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeRequests()
      .antMatchers("/swagger-resources/**", "/v2/api-docs").permitAll()
      .antMatchers(HttpMethod.OPTIONS).permitAll()
      .antMatchers("/mate-api/authenticate").permitAll()
      .antMatchers("/mate-api/logout").permitAll()
      .antMatchers("/mate-api/register").permitAll()
//      .antMatchers("/mate-api/user/**").hasAnyRole(AuthoritiesConstants.ROLE_USER)
      .antMatchers("/mate-api/**").authenticated()
      .and()
      .httpBasic()
      .and()
      .apply(securityConfigurerAdapter())
      .and()
      .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
      .exceptionHandling()
      .accessDeniedPage("/403");
  }

  private JWTConfigurer securityConfigurerAdapter() {
    return new JWTConfigurer(tokenProvider);
  }

}
