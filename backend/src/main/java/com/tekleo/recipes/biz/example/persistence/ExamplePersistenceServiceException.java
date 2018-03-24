package com.tekleo.recipes.biz.example.persistence;

/**
 * @author Leo Ertuna
 * @since 24.03.2018 14:28
 */
public final class ExamplePersistenceServiceException extends Exception {
    public ExamplePersistenceServiceException() {

    }

    public ExamplePersistenceServiceException(String message) {
        super(message);
    }

    public ExamplePersistenceServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExamplePersistenceServiceException(Throwable cause) {
        super(cause);
    }

    public ExamplePersistenceServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}