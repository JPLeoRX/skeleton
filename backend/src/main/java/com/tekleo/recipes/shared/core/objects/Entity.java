package com.tekleo.recipes.shared.core.objects;

import com.tekleo.recipes.shared.core.AbstractId;

import java.io.Serializable;

/**
 * Entity is our one logical object that is split into database object, business object, api object, rest api object, form object
 *
 * Entity is defined by it's ID
 *
 * This object stays at highest level of abstraction
 *
 * @param <I> entity's id
 *
 * @author Leo Ertuna
 * @since 17.05.2018 14:44
 */
public interface Entity<I extends AbstractId> extends Serializable {

}