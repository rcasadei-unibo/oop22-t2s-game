package it.unibo.t2sgame.game.model.api;

import java.util.List;
import java.util.Optional;

import it.unibo.t2sgame.core.engine.api.GameEngine;
import it.unibo.t2sgame.core.entity.api.Entity;
import it.unibo.t2sgame.game.logics.api.Event;

/**
 * Rapresenting the "World" of T2S game.
 * The World is like a "container" of different entities involved in the game.
 */
public interface World {
    /**
     * 
     * @return the wave of the current round 
     */
    Optional<Wave> getCurrentWave();
    /**
     * 
     * @return a list of entities rappresenting the "players" 
     */
    List<Entity> getPlayers();
    /**
     * 
     * @return a list of entities in the world
     */
    List<Entity> getEntities();
    /**
     * Set the next wave
     */
    void setWave(Wave next);

    /**
     * Add an entity to the World
     * @param e Entity to be added to the world
     */
    void addEntity(Entity e);
    /**
     * Remove an entity from the World
     * @param e Entity to be removed from the world
     */
    void removeEntity(Entity e);
    
    /**
     * Adding a player to the list of players in the world
     * @param e the player to be addeed
     */
    void addPlayer(Entity player);
    /**
     * Update the world instance.
     * This method should be called once in every game loop cycle
     */
    void update();
    /**
     * 
     * @return the engine istance where all the entities are updated
     */
    GameEngine getEngine();
    /**
     * Add the event to the World event queue
     * @param event occurred
     */
    void notifyEvent(Event event);

    /**
     * Handle all the events in the event queue
     */
    void handleEvents();
}
