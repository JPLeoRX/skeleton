package com.tekleo.skeleton.api.example;

import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.shared.id.ExampleId;
import com.tekleo.webcore.api.AbstractApi;

/**
 * Sample API interface
 *
 * Plain old java interface
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:37
 */
public interface ExampleAPI extends AbstractApi<ExampleId, ExampleBO, ExampleAO, ExampleApiExceptionManager> {

}