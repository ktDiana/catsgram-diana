package com.practice.catsgram.exceptions;

import lombok.Getter;

@Getter
public class IncorrectParameterException extends RuntimeException {
    private final String parameter;

    public IncorrectParameterException(String parameter) {
        super("Ошибка с полем: " + parameter);
        this.parameter = parameter;
    }
}
