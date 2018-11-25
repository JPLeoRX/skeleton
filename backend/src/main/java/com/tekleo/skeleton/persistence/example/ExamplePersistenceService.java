package com.tekleo.skeleton.persistence.example;

import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.shared.id.ExampleId;
import com.tekleo.webcore.persistence.AbstractPersistenceService;

/**
 * Sample persistence service interface
 *
 * Plain old java interface
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:28
 */
public interface ExamplePersistenceService extends AbstractPersistenceService<ExampleId, ExampleDO, ExampleBO, ExamplePersistenceServiceExceptionManager> {

}