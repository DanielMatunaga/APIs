package com.daniel.transactions.dao;

import java.util.List;

import com.daniel.transactions.entity.Entity;

/**
 * Generic data access class to do interface between the database and the application.
 */
public interface GenericDAO<T extends Entity>
{
    /**
     * Create an entity in the database.
     *
     * @return {@link Entity} The created entity.
     */
    T create();

    /**
     * Get a list of entities in the database.
     *
     * @return List<{@link Entity}> Returns a list of entities.
     */
    List<T> get(int id, int month, int year);

    /**
     * Update an entity in the database.
     *
     * @return {@link Entity} Returns the updated entity.
     */
    T update();

    /**
     * Delete an entity in the database.
     */
    void delete();
}
