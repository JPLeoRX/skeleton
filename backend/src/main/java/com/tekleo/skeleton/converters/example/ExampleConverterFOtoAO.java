package com.tekleo.skeleton.converters.example;

import com.tekleo.skeleton.api.example.ExampleAO;
import com.tekleo.skeleton.restapi.example.ExampleFO;
import com.tekleo.skeleton.shared.id.ExampleId;
import com.tekleo.webcore.converters.AbstractConverterFOtoAO;
import com.tekleo.webcore.utils.Time;
import org.springframework.stereotype.Service;

@Service
public class ExampleConverterFOtoAO implements AbstractConverterFOtoAO<ExampleFO, ExampleAO> {
    /**
     * Convert from FO to AO
     * @param formObject FO
     * @return AO
     */
    @Override
    public ExampleAO toAO(ExampleFO formObject) {
        ExampleAO exampleAO = new ExampleAO();

        exampleAO.setId(new ExampleId());
        exampleAO.setCreatedAt(Time.Current.getAsTimestamp());
        exampleAO.setText(formObject.getText());

        return exampleAO;
    }
}