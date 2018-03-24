package com.tekleo.recipes.biz.example;

import com.tekleo.recipes.shared.id.ExampleId;

import java.util.List;

/**
 * @author Leo Ertuna
 * @since 24.03.2018 15:01
 */
public interface ExampleService {
    ExampleBO getExample(ExampleId exampleId) throws ExampleServiceException;

    List<ExampleBO> getAllExamples() throws ExampleServiceException;

    ExampleBO addExample(ExampleBO newEntity) throws ExampleServiceException;

    ExampleBO updateExample(ExampleBO updatedEntity) throws ExampleServiceException;

    ExampleBO deleteExample(ExampleId exampleId) throws ExampleServiceException;
}