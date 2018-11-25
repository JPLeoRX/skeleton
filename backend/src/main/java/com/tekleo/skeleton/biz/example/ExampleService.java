package com.tekleo.skeleton.biz.example;

import com.tekleo.skeleton.shared.id.ExampleId;
import com.tekleo.webcore.biz.AbstractService;

/**
 * Sample service interface
 *
 * Plain old java interface
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:01
 */
public interface ExampleService extends AbstractService<ExampleId, ExampleBO, ExampleServiceExceptionManager> {

}