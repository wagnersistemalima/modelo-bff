package br.com.sistemalima.app.modelo.core.errors;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomExceptionHandlerTest {

    @InjectMocks
    private CustomExceptionHandler customExceptionHandler;

    @Mock
    private HttpServletRequest request;

    @Test
    void testHandleSummerException() {
        when(request.getServletPath()).thenReturn("/test-path");

        SummerException exception = new SummerException("Erro de validação");
        ErroView erroView = customExceptionHandler.SummerException(exception, request);

        assertEquals(HttpStatus.BAD_REQUEST.value(), erroView.getStatus());
        assertEquals(HttpStatus.BAD_REQUEST.name(), "BAD_REQUEST");
        assertEquals("Erro de validação", erroView.getMessage());
        assertEquals("/test-path", erroView.getPath());
    }

    @Test
    void testHandleSummerParseException() {
        when(request.getServletPath()).thenReturn("/test-path");

        SummerParseException exception = new SummerParseException("Erro de parsing");
        ErroView erroView = customExceptionHandler.SummerParseException(exception, request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), erroView.getStatus());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.name(), "INTERNAL_SERVER_ERROR");
        assertEquals("Erro de parsing", erroView.getMessage());
        assertEquals("/test-path", erroView.getPath());
    }

}