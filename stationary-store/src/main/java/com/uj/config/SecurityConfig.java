package com.uj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.uj.entity.UsersMaster;
import com.uj.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
    private JwtAuthFilter authFilter;


	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails user1 = User
//				.withUsername("pinsu")
//				.password(passwordEncoder().encode("pinsu"))
//				.roles("ADMIN")
//				.build();
//		UserDetails user2 = User
//				.withUsername("niraj")
//				.password(passwordEncoder().encode("niraj"))
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);
		
		return new UserInfoUserDetailService();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.csrf().disable()
//		.authorizeHttpRequests()
//        .requestMatchers("/admin/getAll","/admin/get/**").permitAll()
//        .and()
//        .authorizeHttpRequests()
//        .requestMatchers("/admin/**")
//        .authenticated()
//        .and()
//        .formLogin()
//        .and()
//        .build();
		
		return http.csrf((crf)-> crf.disable())
		.authorizeHttpRequests((requests) -> requests
			.requestMatchers("/admin/token","/user/register").permitAll()
//			.requestMatchers("/admin/create","/admin/update/{id}","/admin/delete/**",
//					"/admin/get/{id}","/admin/getAll","/admin/categories",
//					"admin/create_p","/admin/update_p/**",
//					"/admin/delete_p/**","/admin/get_p/**",
//					"/admin/fetch/**","/admin/stock/**","/admin/update_qty/**",
//					"/admin/qty/**","/order/**",
//					"/user/**").hasRole("ADMIN")
//			.requestMatchers("admin/getAll_p","/admin/fetch/**","/admin/stock/**","/admin/qty/**","/order/place").hasRole("USER")
			.requestMatchers("/admin/**","/user/**","/order/**").hasAnyRole("ADMIN","USER")
			.anyRequest().authenticated()
		).sessionManagement((ses)->{
			ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}).authenticationProvider(authenticationProvider())
		.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
		.build();
		
		
//		return http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/admin/token").permitAll()
//                .and()
//                .authorizeHttpRequests().requestMatchers("/admin"
//                		+ "/**")
//                .authenticated().and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
