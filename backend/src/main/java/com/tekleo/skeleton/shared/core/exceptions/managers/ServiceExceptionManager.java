package com.tekleo.skeleton.shared.core.exceptions.managers;

import com.tekleo.skeleton.shared.core.exceptions.ServiceException;

/**
 * Default exception manager for {@link ServiceException}
 *
 * If you don't want to specify your own exceptions and their manager - feel free to use this default implementation.
 * It will be more than sufficient for most projects.
 *
 * @author Leo Ertuna
 * @since 23.05.2018 23:39
 */
public class ServiceExceptionManager implements ExceptionManager<ServiceException> {
    @Override
    public ServiceException create() {
        return new ServiceException();
    }

    @Override
    public ServiceException create(String message) {
        return new ServiceException(message);
    }

    @Override
    public ServiceException create(Throwable cause) {
        return new ServiceException(cause);
    }

    @Override
    public ServiceException create(String message, Throwable cause) {
        return new ServiceException(message, cause);
    }
}