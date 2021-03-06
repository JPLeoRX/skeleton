package com.tekleo.webcore.persistence;

import com.tekleo.webcore.converters.AbstractConverterBOtoDO;
import com.tekleo.webcore.converters.AbstractConverterDOtoBO;
import com.tekleo.webcore.entities.BusinessObject;
import com.tekleo.webcore.entities.DatabaseObject;
import com.tekleo.webcore.entities.id.AbstractId;
import com.tekleo.webcore.exceptions.ExceptionManager;
import com.tekleo.webcore.exceptions.tier_exceptions.PersistenceServiceException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * This class will represent a persistence service
 *
 * By default a persistence service must support 4 basic operation (CRUD):
 * 1) Retrieve
 * 2) Add
 * 3) Update
 * 4) Remove
 *
 * We should extend this interface and add more methods if we need any additional operations
 *
 * @param <I> id of this entity
 * @param <D> database object
 * @param <B> business object
 * @param <E> exception manager
 *
 * @author Leo Ertuna
 * @since 17.05.2018 12:19
 */
@Transactional
public interface AbstractPersistenceService<I extends AbstractId, D extends DatabaseObject<I>, B extends BusinessObject<I>, E extends ExceptionManager<? extends PersistenceServiceException>> {
    /**
     * Get entity manager
     * @return entity manager
     */
    EntityManager getEntityManager();

    /**
     * Get class of DO
     * @return class
     */
    Class<D> getDatabaseObjectClass();

    /**
     * Get converter from DO to BO
     * @return converter
     */
    AbstractConverterDOtoBO<D, B> getDOtoBOConverter();

    /**
     * Get converter from BO to DO
     * @return converter
     */
    AbstractConverterBOtoDO<B, D> getBOtoDOConverter();

    /**
     * Get exception manager
     * @return exception manager
     */
    E getExceptionManager();

    /**
     * Get an item from the database by its ID
     * @param id id
     * @return item
     * @throws PersistenceServiceException if some error occurred
     */
    default B get(I id) throws PersistenceServiceException {
        // Check for null arguments
        if (id == null)
            throw getExceptionManager().create("Id is null");

        // Find DO
        D found = getEntityManager().find(getDatabaseObjectClass(), id.getInternalId());

        // If none found
        if (found == null)
            throw getExceptionManager().create("No object found for id=" + id);

        // Convert to BO
        return getDOtoBOConverter().toBO(found);
    }

    /**
     * Get all item from the database that have a given value in them
     * @param columnName name of the column in which we should look for this value
     * @param value value
     * @return list of items
     * @throws PersistenceServiceException if some error occurred
     */
    default List<B> getByProperty(String columnName, String value) throws PersistenceServiceException {
        // Check for null arguments
        if (columnName == null || columnName.isEmpty())
            throw getExceptionManager().create("Column name is null or empty");
        if (value == null || value.isEmpty())
            throw getExceptionManager().create("Column value is null or empty");

        // Create a query
        TypedQuery<D> query = getEntityManager().createQuery("FROM " + getDatabaseObjectClass().getName() + " WHERE " + columnName + " ='" + value + "'", getDatabaseObjectClass());

        // Execute it, store results as DO
        List<D> results = query.getResultList();

        // Convert results to BO
        return getDOtoBOConverter().toBO(results);
    }

    /**
     * Get all items from the database
     * @return list of all items
     * @throws PersistenceServiceException if some error occurred
     */
    default List<B> getAll() throws PersistenceServiceException {
        // Create a query
        TypedQuery<D> query = getEntityManager().createQuery("FROM " + getDatabaseObjectClass().getName(), getDatabaseObjectClass());

        // Execute it, store results as DO
        List<D> results = query.getResultList();

        // Convert results to BO
        return getDOtoBOConverter().toBO(results);
    }

    /**
     * Add item to the database
     * @param newItem item to add
     * @return added item
     * @throws PersistenceServiceException if some error occurred
     */
    default B add(B newItem) throws PersistenceServiceException {
        // Check for null arguments
        if (newItem == null)
            throw getExceptionManager().create("New entity is null");

        // Create DO
        D toAdd = getBOtoDOConverter().toDO(newItem);

        // Write to database
        getEntityManager().persist(toAdd);

        // Convert to BO
        return getDOtoBOConverter().toBO(toAdd);
    }

    /**
     * Save updated item in the database
     * @param updatedItem item to update
     * @return updated item
     * @throws PersistenceServiceException if some error occurred
     */
    default B update(B updatedItem) throws PersistenceServiceException {
        // Check for null arguments
        if (updatedItem == null)
            throw getExceptionManager().create("Updated entity is null");

        // Find DO (we must be sure that it exists at this ID
        D found = getEntityManager().find(getDatabaseObjectClass(), updatedItem.getId().getInternalId());

        // If none found
        if (found == null)
            throw getExceptionManager().create("No object found for id=" + updatedItem.getId());

        // Create DO
        D toUpdate = getBOtoDOConverter().toDO(updatedItem);

        // Update in the database
        getEntityManager().merge(toUpdate);

        // Convert to BO
        return getDOtoBOConverter().toBO(toUpdate);
    }

    /**
     * Remove item from the database
     * @param removedItem item to remove
     * @return removed item
     * @throws PersistenceServiceException if some error occurred
     */
    default B remove(B removedItem) throws PersistenceServiceException {
        // Check for null arguments
        if (removedItem == null)
            throw getExceptionManager().create("Removed entity is null");

        // Find DO
        D toDelete = getEntityManager().find(getDatabaseObjectClass(), removedItem.getId().getInternalId());

        // If none found
        if (toDelete == null)
            throw getExceptionManager().create("No object found for id=" + removedItem.getId());

        // Delete in the database
        getEntityManager().remove(toDelete);

        // Convert to BO
        return getDOtoBOConverter().toBO(toDelete);
    }

    /**
     * Remove all items of this entity from the database
     * @return number of removed items
     * @throws PersistenceServiceException if some error occurred
     */
    default int removeAll() throws PersistenceServiceException {
        // Create a query
        Query query = getEntityManager().createQuery("DELETE FROM " + getDatabaseObjectClass().getName());

        // Execute it, and return the number of deleted items
        return query.executeUpdate();
    }
}