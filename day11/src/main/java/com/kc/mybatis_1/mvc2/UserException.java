package com.kc.mybatis_1.mvc2;

/**
 * @author wen
 * @create 2020-05-18 21:14
 */
public class UserException extends Exception {

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
