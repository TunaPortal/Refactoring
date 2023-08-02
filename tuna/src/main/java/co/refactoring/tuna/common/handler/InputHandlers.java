package co.refactoring.tuna.common.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class InputHandlers extends RequestBodyAdviceAdapter {

    private final HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
                                Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

        String logString = String.format("[P][%s][%s] %s", httpServletRequest.getRequestURI(), httpServletRequest.getRemoteAddr(), body.toString());
        log.info(logString);
        return body;
    }
}
