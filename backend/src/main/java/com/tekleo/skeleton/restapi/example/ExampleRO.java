package com.tekleo.skeleton.restapi.example;

import com.tekleo.skeleton.shared.id.ExampleId;
import com.tekleo.webcore.entities.RestApiObject;

/**
 * Sample Rest Object
 *
 * It is used to transfer data from backend to frontend via REST api
 *
 * @author Leo Ertuna
 * @since 24.03.2018 15:53
 */
public class ExampleRO implements RestApiObject<ExampleId> {
    private String exampleId;
    private String text;
    private long createdAt;



    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleRO() {

    }
    //------------------------------------------------------------------------------------------------------------------


    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public String getId() {
        return exampleId;
    }

    public String getText() {
        return text;
    }

    public long getCreatedAt() {
        return createdAt;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Setters
    //------------------------------------------------------------------------------------------------------------------
    public void setId(String exampleId) {
        this.exampleId = exampleId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
    //------------------------------------------------------------------------------------------------------------------
}