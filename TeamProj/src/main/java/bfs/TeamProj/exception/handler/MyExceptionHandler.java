package bfs.TeamProj.exception.handler;

import bfs.TeamProj.domain.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value={UserNotFoundException.class})
    public ResponseEntity<ErrorMessage> handlerUserNotFound(UserNotFoundException e){
        System.out.println("If UserNotFoundException throws, it will be intercepted by this handler");
        return new ResponseEntity(ErrorMessage.builder().msg(e.getMessage()+" Not Found").build(), HttpStatus.BAD_REQUEST);
    }
}
