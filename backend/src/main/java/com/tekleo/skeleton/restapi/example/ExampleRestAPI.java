package com.tekleo.skeleton.restapi.example;

import com.tekleo.skeleton.api.example.ExampleAO;
import com.tekleo.skeleton.api.example.ExampleAPI;
import com.tekleo.skeleton.converters.example.ExampleConverterAOtoRO;
import com.tekleo.skeleton.converters.example.ExampleConverterFOtoAO;
import com.tekleo.skeleton.converters.example.ExampleConverterROtoAO;

import com.tekleo.skeleton.shared.id.ExampleId;
import com.tekleo.webcore.converters.AbstractConverterROtoAO;
import com.tekleo.webcore.exceptions.tier_exceptions.RestApiException;
import com.tekleo.webcore.rest_api.AbstractRestApi;
import com.tekleo.webcore.rest_api.ReplyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Sample REST api implementation
 *
 * This class is a Spring rest controller {@link RestController}
 * To manage the data we access the API layer here, which should be {@link Autowired} to work correctly
 *
 * @author Leo Ertuna
 * @since 24.03.2018 19:50
 */
@RestController
@RequestMapping("/api/example")
public class ExampleRestAPI implements AbstractRestApi<ExampleId, ExampleAO, ExampleRO, ExampleFO, ExampleRestApiExceptionManager> {
    @Autowired
    private ExampleAPI api;

    @Autowired
    private ExampleRestApiExceptionManager exceptionManager;

    @Override
    public ExampleAPI getApi() {
        return api;
    }

    @Override
    public ExampleConverterAOtoRO getAOtoROConverter() {
        return new ExampleConverterAOtoRO();
    }

    @Override
    public ExampleConverterFOtoAO getFOtoAOConverter() {
        return new ExampleConverterFOtoAO();
    }

    @Override
    public AbstractConverterROtoAO<ExampleRO, ExampleAO> getROtoAOConverter() {
        return new ExampleConverterROtoAO();
    }

    @Override
    public ExampleRestApiExceptionManager getExceptionManager() {
        return exceptionManager;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ReplyObject getExample(@PathVariable(value = "id") String id) {
        try {
            return ReplyObject.Builder.success("example", get(new ExampleId(id))).build();
        } catch (RestApiException e) {
            e.printStackTrace();
            return ReplyObject.Builder.error("REST API Exception").build();
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ReplyObject getAllExamples() {
        try {
            return ReplyObject.Builder.success("examples", getAll()).build();
        } catch (RestApiException e) {
            e.printStackTrace();
            return ReplyObject.Builder.error("REST API Exception").build();
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ReplyObject addExample(@Valid @RequestBody ExampleFO form) {
        try {
            return ReplyObject.Builder.success("example", add(form)).build();
        } catch (RestApiException e) {
            e.printStackTrace();
            return ReplyObject.Builder.error("REST API Exception").build();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ReplyObject deleteExample(@PathVariable(value = "id") String id) {
        try {
            return ReplyObject.Builder.success("example", remove(new ExampleId(id))).build();
        } catch (RestApiException e) {
            e.printStackTrace();
            return ReplyObject.Builder.error("API Exception").build();
        }
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ReplyObject deleteAllExamples() {
        try {
            return ReplyObject.Builder.success("example", removeAll()).build();
        } catch (RestApiException e) {
            e.printStackTrace();
            return ReplyObject.Builder.error("API Exception").build();
        }
    }
}