package com.tekleo.skeleton.persistence.example;

import com.tekleo.webcore.exceptions.tier_exceptions.PersistenceServiceException;

/**
 * @author Leo Ertuna
 * @since 24.03.2018 14:28
 */
public final class ExamplePersistenceServiceException extends PersistenceServiceException {
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