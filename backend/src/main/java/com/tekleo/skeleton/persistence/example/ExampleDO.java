package com.tekleo.skeleton.persistence.example;

import com.tekleo.skeleton.shared.id.ExampleId;
import com.tekleo.webcore.entities.DatabaseObject;

import javax.persistence.*;

/**
 * Sample Database Object
 *
 * It is used to interact with the database
 *
 * @author Leo Ertuna
 * @since 24.03.2018 13:59
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "example")
public class ExampleDO implements DatabaseObject<ExampleId> {
    // Due to postgreSQL limitations we have to specify lowercase column names of camel case data fields
    @Id @Column(name = "exampleid") private String exampleId;
    @Column private String text;
    @Column(name = "createdat") private long createdAt;



    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public ExampleDO() {

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