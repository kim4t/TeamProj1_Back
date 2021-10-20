package bfs.TeamProj.exception.handler;

import bfs.TeamProj.exception.AgeInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value={AgeInvalidException.class})
    public ResponseEntity handlerUserNotFound(AgeInvalidException e){

        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<String> handlerException(Exception e){
        return new ResponseEntity("General Exception", HttpStatus.NOT_FOUND);
    }
}
