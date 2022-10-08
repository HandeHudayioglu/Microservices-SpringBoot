package com.hande.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthServiceSecurityConfig {
    /**
      Sunucunuza gelen tüm isteklerin konfigurasyonlarını burada yapıyorsunuz
     */

    @Bean
    JwtTokenFilter getJwtTokenFilter(){
        return new JwtTokenFilter();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        /**
         * olmasını istediğimiz tüm ayarlamaları burada yapıp
         */
        /**
         * 1-tüm isteklerde csrf() disable olsun
         */
        http.csrf().disable();
        /**
         * 1-anyRequest--> gelen tüm istekler
         * 2- authenticated --> kimlik doğrulaması yapılsın
         * 3-pernitAll --> kimlik doğrulamasına tabi tutma
         */
        http.authorizeRequests()
                .antMatchers("/v3/api-docs/**","/swagger-ui/**","/v1/api/auth/doLogin","/v1/api/auth/register").permitAll()
                .anyRequest().authenticated();

        /**
         * 1-eğer kimlik doğrulaması gerekiyor ise bunu springin login formu üzerinden yap
         */
        //http.formLogin();
        /**
         * JWT ile gelen isteklerin doğrulamasının yapılmasını talep ettiğimiz kısım burada
         * gelen isteğin cevabı verilmeden önce filter araya sokularak doğrulama
         * mekanizması buraya işlenmelidir
         */

        http.addFilterBefore(getJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        /**
         *gelen isteği yeni kurguladığımız hali ile springe iletiyoruz
         */

        return http.build();
    }
}
