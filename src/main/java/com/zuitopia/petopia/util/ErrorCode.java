package com.zuitopia.petopia.util;

import javax.lang.model.type.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorCode {
    private ErrorType errorType;
    private String message;
}
