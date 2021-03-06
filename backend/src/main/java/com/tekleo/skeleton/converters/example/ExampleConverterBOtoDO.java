package com.tekleo.skeleton.converters.example;

import com.tekleo.skeleton.biz.example.ExampleBO;
import com.tekleo.skeleton.persistence.example.ExampleDO;
import com.tekleo.webcore.converters.AbstractConverterBOtoDO;
import org.springframework.stereotype.Service;

/**
 * Simple converter to switch from BO to DO objects
 *
 * @author Leo Ertuna
 * @since 24.03.2018 14:20
 */
@Service
public class ExampleConverterBOtoDO implements AbstractConverterBOtoDO<ExampleBO, ExampleDO> {
    /**
     * Convert from BO to DO
     * @param exampleBO BO
     * @return DO
     */
    @Override
    public ExampleDO toDO(ExampleBO exampleBO) {
        ExampleDO exampleDO = new ExampleDO();

        exampleDO.setId(exampleBO.getId().getInternalId());
        exampleDO.setText(exampleBO.getText());
        exampleDO.setCreatedAt(exampleBO.getCreatedAt().getTime());

        return exampleDO;
    }
}
