package com.hande.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 1-Bu metotta geridönüş tipi tamamen keyfidir,yani responseentity olmak zorunda değil. Ancak buraya kontrol edilebilen
     * ve sınıflandırılmış mesajlar koymak doğru yaklaşım olacaktır.
     * 2-Metot içindeki parametreler de yakalamak istediğimiz
     * istisna türünden olmalı. şu an ExceptionExampleControllerda oluşturduğumuz hata RuntimeException fırlatacağı için
     * parametre olarak da öyle aldık.
     * 3-Springin otomatik olarak yakalayacağı istisnanın türünü @ExceptionHandler anatosyonu ile bildirmeniz gerekir.
     * @param
     * @return
     */
        @ExceptionHandler(RuntimeException.class)
        @ResponseBody
        public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
            return ResponseEntity.ok("Beklenmeyen bir hata oluştu: " +ex.getMessage());
    }
    @ExceptionHandler(AuthManagerException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage>handleMonolitikManagerException(AuthManagerException ex){
        ErrorType errorType = ex.getErrorType();
        HttpStatus httpStatus = errorType.getHttpStatus();
        /**
         *  eğer returnden sonra ResponseEntity.ok().build() yazsaydık bize 200 dönecekti
         */
        return new ResponseEntity<>(createError(errorType,ex),httpStatus);  //burda bir constructor döndüğümüz için new kullandık

    }

    private ErrorMessage createError(ErrorType errorType,Exception exception){
            System.out.println("Hata oluştu: "+exception.getMessage());
            return ErrorMessage.builder()
                    .code(errorType.getCode())
                    .message(errorType.getMessage())
                    .build();
    }
}
