package com.tekleo.webcore.entities;

import com.tekleo.webcore.entities.id.AbstractId;

/**
 * This is the parent class for all Database Objects
 *
 * @param <I> entity's id (although in this object it will be used as string, we need this field just to allow proper class matching)
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface DatabaseObject<I extends AbstractId> extends Entity<I> {
    /**
     * Getter for id
     * @return
     */
    String getId();

    /**
     * Setter for id
     * @param newId
     */
    void setId(String newId);
}