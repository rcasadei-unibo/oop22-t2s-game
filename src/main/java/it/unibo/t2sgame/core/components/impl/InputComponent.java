package it.unibo.t2sgame.core.components.impl;

import it.unibo.t2sgame.core.components.api.AbstractComponent;
import it.unibo.t2sgame.core.components.api.Message;
import it.unibo.t2sgame.input.api.InputController;

/**
 * This component represents the input of an entity.
 */
public class InputComponent extends AbstractComponent {
    /**
     * The input controller links the input component to a concrete input source.
     */
    private final InputController inputController;

    /**
     * @param inputController the input controller of this input component
     */
    public InputComponent(final InputController inputController) {
        this.inputController = inputController;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void receive(final Message<T> message) {
        // An input component doesn't need to receive messages
    }

    /**
     * @return the input controller
     */
    public InputController getInputController() {
        return this.inputController;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        this.inputController.getCommandsQueue().forEach(c -> c.execute(this.entity));
    }
}
