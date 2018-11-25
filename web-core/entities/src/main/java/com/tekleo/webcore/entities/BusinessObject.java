package com.tekleo.webcore.entities;

import com.tekleo.webcore.entities.id.AbstractId;
import com.tekleo.webcore.entities.properties.HasId;

/**
 * This is the parent class for all Business Objects
 *
 * @param <I> entity's id
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface BusinessObject<I extends AbstractId> extends Entity<I>, HasId<I> {
    /**
     * Getter for id
     * @return
     */
    I getId();

    /**
     * Setter for id
     * @param newId
     */
    void setId(I newId);
}