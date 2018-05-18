package com.tekleo.skeleton.shared.core.objects;

import com.tekleo.skeleton.shared.core.AbstractId;

/**
 * This is the parent class for all Database Objects
 *
 * @param <I> entity's id
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface AbstractDO<I extends AbstractId> extends Entity<I> {
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