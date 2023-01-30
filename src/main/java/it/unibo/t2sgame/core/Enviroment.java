package it.unibo.t2sgame.core;

import it.unibo.t2sgame.core.engine.api.GameEngine;
import it.unibo.t2sgame.core.entity.api.Entity;
import it.unibo.t2sgame.game.logics.api.Event;

/**
 * An Enviroment is a entity's container.
 * Every update of the enviroment will update all entities inside it.
 * The enviroment's update has to be called once during the game loop
 */
public interface Enviroment {
    /**
     * Update the enviroment
     */
    public void update();
    /**
     * 
     * @return the game engine contained in the enviroment
     */
    public GameEngine getEngine();
    /**
     * Add the entity {@link entity} to the enviroment.
     * The entity will automatically added to the related GameSystems
     * @param entity the entity to add the enviroment
     */
    void addEntity(Entity entity);
    /**
     * Remove the entity {@link entity} to the enviroment.
     * The entity will automatically removed to the related GameSystems
     * @param entity the entity to remove from the enviroment
     */
    void removeEntity(Entity entity);
    /**
     * Notify the event {@link event} generated by some component
     */
    void notifyEvent(Event event); 
    /**
     * Handle all events generated from components
     */
    void handleEvents();
}
