package com.hande.config.security;

import com.hande.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    public UserDetails loadUserByUserId(Long authId) throws UsernameNotFoundException {

        /**
         * Id si verilen kullanıcının var olup olmadığına bakılmalıdır
         */
        boolean isUserExist = authService.findById(authId).getId() != null;
        if(isUserExist) {
            /**
             * Burada oluşturulan kullanıcı, hangi sayfalara giriş yapabileceğinin anlaşılabilmesi
             * kontrol edilebilmesi için bir yetki listesinin olmasına gerek avrdır.
             * bu nedenle burada USER,ADMİN gibi listeyi burda belirtmelyiz
             */
            return User.builder()
                    .username(authId.toString())
                    .password("")
                    .accountExpired(false)
                    .accountLocked(false)
                    .authorities("USER")
                    .build();

        }
        return null;
    }
}
