package com.tekleo.webcore.biz;

import com.tekleo.webcore.entities.BusinessObject;
import com.tekleo.webcore.entities.id.AbstractId;
import com.tekleo.webcore.exceptions.ExceptionManager;
import com.tekleo.webcore.exceptions.tier_exceptions.PersistenceServiceException;
import com.tekleo.webcore.exceptions.tier_exceptions.ServiceException;
import com.tekleo.webcore.persistence.AbstractPersistenceService;

import java.util.List;

/**
 * This class will represent a service
 *
 * All default operations from {@link AbstractPersistenceService} are implemented here
 *
 * We should extend this interface and add more methods if we need any additional operations on top of default {@link AbstractPersistenceService} scope
 *
 * @param <I> id of this entity
 * @param <B> business object
 * @param <E> exception manager
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:31
 */
public interface AbstractService<I extends AbstractId, B extends BusinessObject<I>, E extends ExceptionManager<? extends ServiceException>> {
    /**
     * Get a pointer to the persistence service
     * @return persistence service
     */
    AbstractPersistenceService<I, ?, B, ?> getPersistenceService();

    /**
     * Get exception manager
     * @return exception manager
     */
    E getExceptionManager();

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B get(I id) throws ServiceException {
        try {
            return getPersistenceService().get(id);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getByProperty(String columnName, String value) throws ServiceException {
        try {
            return getPersistenceService().getByProperty(columnName, value);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getByProperty(String columnName, Object value) throws ServiceException {
        return this.getByProperty(columnName, String.valueOf(value));
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getByProperty(String columnName, long value) throws ServiceException {
        return this.getByProperty(columnName, Long.valueOf(value));
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getByProperty(String columnName, double value) throws ServiceException {
        return this.getByProperty(columnName, Double.valueOf(value));
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getByProperty(String columnName, boolean value) throws ServiceException {
        return this.getByProperty(columnName, Boolean.valueOf(value));
    }

    /**
     * Get all items from the database
     * @return list of all items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default List<B> getAll() throws ServiceException {
        try {
            return getPersistenceService().getAll();
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Add item to the database
     * @param newItem item to add
     * @return added item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B add(B newItem) throws ServiceException {
        try {
            return getPersistenceService().add(newItem);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Save updated item in the database
     * @param updatedItem item to update
     * @return updated item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B update(B updatedItem) throws ServiceException {
        try {
            return getPersistenceService().update(updatedItem);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Remove item from the database
     * @param removedItem item to remove
     * @return removed item
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default B remove(B removedItem) throws ServiceException {
        try {
            return getPersistenceService().remove(removedItem);
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }

    /**
     * Remove all items of this entity from the database
     * @return number of removed items
     * @throws ServiceException if {@link PersistenceServiceException} occurred
     */
    default int removeAll() throws ServiceException {
        try {
            return getPersistenceService().removeAll();
        } catch (PersistenceServiceException e) {
            throw getExceptionManager().create(e);
        }
    }
}