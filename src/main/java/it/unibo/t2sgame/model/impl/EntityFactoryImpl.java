package it.unibo.t2sgame.model.impl;

import it.unibo.t2sgame.common.Vector2D;
import it.unibo.t2sgame.components.api.CollisionComponentFactory;
import it.unibo.t2sgame.components.api.GraphicComponentFactory;
import it.unibo.t2sgame.components.api.InputComponentFactory;
import it.unibo.t2sgame.components.impl.CollisionComponentFactoryImpl;
import it.unibo.t2sgame.components.impl.DamageComponentImpl;
import it.unibo.t2sgame.components.impl.GraphicComponentFactoryImpl;
import it.unibo.t2sgame.components.impl.HealthComponentImpl;
import it.unibo.t2sgame.components.impl.InputComponentFactoryImpl;
import it.unibo.t2sgame.components.impl.PhysicsComponentImpl;
import it.unibo.t2sgame.input.api.Directions;
import it.unibo.t2sgame.model.api.Entity;
import it.unibo.t2sgame.model.api.EntityFactory;
import it.unibo.t2sgame.physics.impl.Rectangle;

public class EntityFactoryImpl implements EntityFactory {

    private final InputComponentFactory inputFactory = new InputComponentFactoryImpl();
    private final CollisionComponentFactory collisionFactory = new CollisionComponentFactoryImpl();
    private final GraphicComponentFactory graphicFactory = new GraphicComponentFactoryImpl();

    @Override
    public Entity createPlayer(final Vector2D position) {
        return new EntityImpl(position)
            .addComponent(this.inputFactory.createKeyboardInputComponent())
            .addComponent(new PhysicsComponentImpl(1))
            .addComponent(this.collisionFactory.collisionWithRectangleShape(new Rectangle(60, 80)))
            .addComponent(this.graphicFactory.getPlayerGraphicComponent())
            .addComponent(new HealthComponentImpl(3));
    }

    @Override
    public Entity createProjectile(final Vector2D position, final Directions direction) {
        return new EntityImpl(position)
            .addComponent(new PhysicsComponentImpl(1.5, direction))
            .addComponent(this.graphicFactory.getProjectileGraphicComponent());
    }

    @Override
    public Entity createBaseEnemy(final Vector2D position) {
        return new EntityImpl(position)
            .addComponent(this.inputFactory.createBasicEnemyAIInputComponent())
            .addComponent(new PhysicsComponentImpl(0.25))
            .addComponent(this.collisionFactory.collisionWithRectangleShape(new Rectangle(60, 80)))
            .addComponent(new DamageComponentImpl(1, 1))
            .addComponent(this.graphicFactory.getBaseEnemyGraphicComponent());
    }
    
}
