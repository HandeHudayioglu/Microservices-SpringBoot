package com.hande.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.bouncycastle.math.ec.rfc8032.Ed25519;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {

  /*
  1-Create JWT
  2- Validate JWT
   */

    public Optional<String> createToken(Long id){
        String token = null;
        String sifreAnahtari = "1234"; //"<11p2YA&hY}gH3c=+]WLeDn!2*QRO/N0UBO-cvCz>|:fv(9.E0~Aw(;$]'9p'XR"


        try { //JWT içerisine hassas bilgilerinizi koymayınız. Örneğin şifre gibi.
            token = JWT.create()
                    .withAudience()
                    .withClaim("id",id)
                    .withIssuer("eda")                                                                                                                                //ihtiyacımız olan parametreyi koyduk, id ye göre token vereceğiz withIssuer("hande") de diyebilirdik
                    .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*5))                                                                  //bu tokenın geçerli olduğu zaman
                    .withIssuedAt(new Date()) //oluşturulduğu zaman
                    .sign(Algorithm.HMAC256(sifreAnahtari));                                                                                                        //şifrenin kolay kırılmaması için zor bişey girilmeli yukarıda yorum satırında yazılan gibi
            return Optional.of(token);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
