package com.security.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity(debug = true)
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

//    configure security

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        configurations
//        httpSecurity.authorizeHttpRequests(
//                request -> {
//
//                    //api/route2-->public
//                    request.requestMatchers("/api/route2", "/register").permitAll();
//                    request.requestMatchers("/users/**").permitAll();
//                    request.requestMatchers(HttpMethod.POST, "/products");
//                    //baki ko authenticated
//                    request.anyRequest().authenticated();
//
//                }
//        );

//        httpSecurity.authorizeHttpRequests(r -> r.requestMatchers("/api/route2").permitAll()
//                .requestMatchers("/users/**").permitAll()
//                .requestMatchers(HttpMethod.POST, "/products").authenticated()
//                .anyRequest().authenticated()
//        );

        httpSecurity.authorizeHttpRequests(
                request -> request.requestMatchers("/api/route3", "/api/route4").hasRole("GUEST")
                        .requestMatchers("/api/route1", "/api/route2").hasRole("ADMIN")
                        .anyRequest().permitAll()
        );

        //form based login
//        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }


//
//    @Bean
//    public UserDetailsService userDetailsService() {
////        database nhi user kar:
//
////        creating users
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("durgesh")
//                .password("durgesh")
//                .roles("ADMIN", "GUEST")
//                .build();
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("ankit")
//                .password("ankit123")
//                .roles("ADMIN")
//                .build();
//
////        creating in memory userdetaimanager: that  is user  detail service implementation
////        providing user1 and user2 to userdetaildetail service.
//        InMemoryUserDetailsManager inMemoryUserDetailService = new InMemoryUserDetailsManager(user1, user2);
//
//        return inMemoryUserDetailService;
//
//    }


    //  we will use password encoder in future in project:
    // we will going to skip password encoder for this usecase


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
