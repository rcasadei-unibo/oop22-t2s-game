package it.unibo.t2sgame.core.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import it.unibo.t2sgame.components.api.CollisionComponent;
import it.unibo.t2sgame.components.api.Component;
import it.unibo.t2sgame.components.api.GraphicComponent;
import it.unibo.t2sgame.components.api.InputComponent;
import it.unibo.t2sgame.components.api.PhysicsComponent;
import it.unibo.t2sgame.core.api.GameSystem;
import it.unibo.t2sgame.core.api.GameSystemFactory;
import it.unibo.t2sgame.model.api.Entity;

public class GameSystemFactoryImpl implements GameSystemFactory{

    private <T extends Component> GameSystem sytemWith(Class<T> clazz){
        return new GameSystem() {

            private final Set<Component> components = new HashSet<>();
            
            @Override
            public void update() {
                this.components.forEach(Component::update);
            }

            @Override
            public boolean isMember(Entity e) {
                return e.getComponent(clazz).isPresent();
            }

            @Override
            public <S extends Component> boolean checkType(Class<S> type) {
                return clazz.equals(type);
            }

            @Override
            public Class<? extends Component> getType() {
                return clazz;
            }
            
            @Override
            public GameSystem addComponent(Optional<? extends Component> component) {
                component.ifPresent(this.components::add);
                return this;
            }
            
            @Override
            public GameSystem removeComponent(Optional<? extends Component> component){
                component.ifPresent(this.components::remove);
                return this;
            }

            
        };
    }

    @Override
    public GameSystem craeteInputSystem() {
        return sytemWith(InputComponent.class);
    }

    @Override
    public GameSystem createPhysicsSystem() {
        return sytemWith(PhysicsComponent.class);
    }

    @Override
    public GameSystem createCollisionSystem() {
        return sytemWith(CollisionComponent.class);
    }

    @Override
    public GameSystem createGraphicsSystem() {
        return sytemWith(GraphicComponent.class);
    }
    
}
