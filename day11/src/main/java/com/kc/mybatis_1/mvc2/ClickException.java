package com.kc.mybatis_1.mvc2;

/**
 * @author wen
 * @create 2020-05-18 21:15
 */
public class ClickException extends Exception {

    public ClickException() {
    }

    public ClickException(String message) {
        super(message);
    }

    public ClickException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClickException(Throwable cause) {
        super(cause);
    }
}
