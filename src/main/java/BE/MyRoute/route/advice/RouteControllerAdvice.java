package BE.MyRoute.route.advice;

import BE.MyRoute.route.exception.MemberNotExistException;
import BE.MyRoute.route.exception.RouteNotExistException;
import BE.MyRoute.route.exception.ShopNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "BE.MyRoute.route.controller")
public class RouteControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> routeNotExistException(RouteNotExistException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("route not found");
    }

    @ExceptionHandler
    public ResponseEntity<String> memberNotExistException(MemberNotExistException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("member not found");
    }

    @ExceptionHandler
    public ResponseEntity<String> shopNotExistException(ShopNotExistException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("shop not found");
    }

    @ExceptionHandler
    public ResponseEntity<String> illegalArgumentException(IllegalArgumentException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("bad request");
    }
}
