package it.unibo.t2sgame.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import it.unibo.t2sgame.model.api.Component;
import it.unibo.t2sgame.model.api.Entity;
import it.unibo.t2sgame.model.impl.EntityImpl;
import it.unibo.t2sgame.physic.api.PhysicComponent;
import it.unibo.t2sgame.view.api.Graphic;
import it.unibo.t2sgame.view.api.GraphicComponent;
import it.unibo.t2sgame.input.api.InputComponent;;

public class EntityTest {
    
    @Test void testGetEntityComponent() {
        var entity = new EntityImpl();
        entity.addComponent(new PhysicComponent() {
            @Override
            public void update(Entity entity) { 
            }
            @Override
            public void receive() {
            }
        });
        var componentOptional = entity.getComponent(PhysicComponent.class);
        assertTrue(componentOptional.isPresent());
        assertTrue(PhysicComponent.class.isAssignableFrom(componentOptional.get().getClass()));
        componentOptional = entity.getComponent(InputComponent.class);
        assertFalse(componentOptional.isPresent());
        componentOptional = entity.getComponent(GraphicComponent.class);
        assertFalse(componentOptional.isPresent());
    }

}