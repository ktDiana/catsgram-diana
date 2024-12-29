package com.practice.catsgram.controller;

import com.practice.catsgram.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePostNotFound(PostNotFoundException e) {
        return new ErrorResponse(e.getMessage());       // "Ошибка поиска записи"
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFound(UserNotFoundException e) {
        return new ErrorResponse(e.getMessage());       // "Ошибка поиска пользователя
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUserAlreadyExist(UserAlreadyExistsException e) {
        return new ErrorResponse(e.getMessage());       // "Пользователь с данным email уже существует"
    }

    @ExceptionHandler(InvalidEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidEmail(InvalidEmailException e) {
        return new ErrorResponse(e.getMessage());       // "Какие-то проблемы при указании почты"
    }

    @ExceptionHandler(IncorrectParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIncorrectParameter(IncorrectParameterException e) {
        return new ErrorResponse(e.getMessage());       // "Пользователь с данным email уже существует"
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleServerError(Throwable e) {
        return new ErrorResponse("Произошла непредвиденная ошибка");
    }

}