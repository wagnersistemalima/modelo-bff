package br.com.sistemalima.app.modelo.core.errors;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(SummerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroView SummerException(SummerException exception, HttpServletRequest request) {
        return new ErroView(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                exception.getMessage(),
                request.getServletPath()
        );
    }

    @ExceptionHandler(SummerParseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroView SummerParseException(SummerParseException exception, HttpServletRequest request) {
        return new ErroView(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                exception.getMessage(),
                request.getServletPath()
        );
    }
}
