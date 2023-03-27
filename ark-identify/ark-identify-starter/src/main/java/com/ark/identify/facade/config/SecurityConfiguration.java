/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ark.identify.facade.config;

import com.ark.identify.facade.authorization.ArkAuthenticationFailureHandler;
import com.ark.identify.facade.authorization.ArkAuthenticationSucessHandler;
import com.ark.identify.facade.authorization.ArkLogOutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * An example of explicitly configuring Spring Security with the defaults.
 *
 * @author Rob Winch
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private ArkAuthenticationSucessHandler sucessHandler;

    @Autowired
    private ArkAuthenticationFailureHandler failureHandler;
    @Autowired
    private ArkLogOutSuccessHandler logOutSuccessHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(formLogin -> {
                    formLogin
                            .loginProcessingUrl("/login")
                            .successHandler(sucessHandler)
                            .failureHandler(failureHandler);
                })
                .logout(logout -> {
                    logout
                            .logoutUrl("/logout")
                            .logoutSuccessHandler(logOutSuccessHandler)
                            .deleteCookies("JSESSIONID");

                })
                .authorizeHttpRequests(registry -> {
                    registry
                            // 白名单
                            .requestMatchers("/authentication/require").permitAll()
                            // 其余所有请求，都需要认证
                            .anyRequest().authenticated();
                })
                .csrf(csrf -> {
                    csrf.disable();
                });
        return http.build();
    }
}
