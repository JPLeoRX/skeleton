package com.tekleo.skeleton.shared.core.exceptions.managers;

import com.tekleo.skeleton.shared.core.exceptions.RestApiException;

/**
 * Default exception manager for {@link RestApiException}
 *
 * If you don't want to specify your own exceptions and their manager - feel free to use this default implementation.
 * It will be more than sufficient for most projects.
 *
 * @author Leo Ertuna
 * @since 23.05.2018 23:39
 */
public class RestApiExceptionManager implements ExceptionManager<RestApiException> {
    @Override
    public RestApiException create() {
        return new RestApiException();
    }

    @Override
    public RestApiException create(String message) {
        return new RestApiException(message);
    }

    @Override
    public RestApiException create(Throwable cause) {
        return new RestApiException(cause);
    }

    @Override
    public RestApiException create(String message, Throwable cause) {
        return new RestApiException(message, cause);
    }
}