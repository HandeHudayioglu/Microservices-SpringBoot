package com.hande.repository;

import com.hande.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {

    /*
    Kullanıcı adı büyük küçük harfe duyarlı olmamalı
     */

    Optional<Auth> findOptionalByUserNameIgnoreCaseAndPassword(String userName, String password);

    @Query("select COUNT(a)>0 from Auth a where UPPER(a.userName)=UPPER(?1) and a.password =?2")
    Boolean isExist(String userName, String password);




}
