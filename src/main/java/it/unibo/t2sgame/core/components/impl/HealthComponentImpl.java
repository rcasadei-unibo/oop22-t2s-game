package it.unibo.t2sgame.core.components.impl;

import it.unibo.t2sgame.core.components.api.HealthComponent;
import it.unibo.t2sgame.core.components.api.Message;
import it.unibo.t2sgame.core.entity.api.Entity;

public class HealthComponentImpl implements HealthComponent{

    private int health;
    private Entity entity;
    public HealthComponentImpl(final int health){
        this.health = health;
    }

    @Override
    public void update() {
    
    }

    @Override
    public <T> void receive(Message<T> message) {
        try {
            var dmg = (int)message.getMessage();
            this.health = this.health - dmg >= 0 ? this.health - dmg : 0;
        } catch (ClassCastException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public Entity getEntity() {
        return this.entity;
    }

    @Override
    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}