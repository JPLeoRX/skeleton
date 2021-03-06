package com.tekleo.skeleton.persistence.example;

import com.tekleo.webcore.exceptions.ExceptionManager;
import org.springframework.stereotype.Service;

@Service
public class ExamplePersistenceServiceExceptionManager implements ExceptionManager<ExamplePersistenceServiceException> {
    @Override
    public ExamplePersistenceServiceException create() {
        return new ExamplePersistenceServiceException();
    }

    @Override
    public ExamplePersistenceServiceException create(String message) {
        return new ExamplePersistenceServiceException(message);
    }

    @Override
    public ExamplePersistenceServiceException create(Throwable cause) {
        return new ExamplePersistenceServiceException(cause);
    }

    @Override
    public ExamplePersistenceServiceException create(String message, Throwable cause) {
        return new ExamplePersistenceServiceException(message, cause);
    }
}
