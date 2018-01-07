package com.ecommerce.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String pageNotFoundException(Model model, Exception ex) {

        model.addAttribute("errorDescription","REQUESTED WEBSITE IS NOT FOUND");
        model.addAttribute("errorTitle"," PAGE IS UNAVAILABLE");

        return "error404";
    }

}
