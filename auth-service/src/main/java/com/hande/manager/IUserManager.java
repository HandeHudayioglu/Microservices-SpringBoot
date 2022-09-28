package com.hande.manager;

import com.hande.dto.request.NewUserCreateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


// başka bir microservisteki end pointleri çağırmak için kullanılır.
// ULAŞMAK İSTEDİĞİNİZ CONTROLLERIN URL bilgisini vermelisiniz
//tüm feign işlemlerine benzersiz adlandırmalar(name) yapılmalıdır

             //userprofilecontroller ın url si
@FeignClient(url = "http://localhost:9091/v1/api/user", name = "user-service-userprofile", decode404 = true)
public interface IUserManager {

    //userprofilecontrollerdaki newUserCreate metodu
    @PostMapping("/newcreateuser")
    ResponseEntity<Boolean>newUserCreate(NewUserCreateDto dto);


}
