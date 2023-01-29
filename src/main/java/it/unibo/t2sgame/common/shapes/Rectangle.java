package it.unibo.t2sgame.common.shapes;

import it.unibo.t2sgame.common.Shape;
import it.unibo.t2sgame.common.Vector2D;

public class Rectangle implements Shape{
    private Vector2D center;
    private double width;
    private double height;

    /**
     * 
     * @param center the center of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(final Vector2D center, final double width, final double height){
        this.center = center;
        this.width = width;
        this.height = height;
    }

    @Override
    public Vector2D getCenter() {
        return this.center;
    }

    @Override
    public void setCenter(final Vector2D center) {
        this.center = center;
    }

    /**
     * 
     * @return width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * 
     * @param width the new width of the rectangle
     */
    public void setWidth(final double width) {
        this.width = width;
    }

    /**
     * 
     * @return height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * 
     * @param height the new height of the rectangle
     */
    public void setHeight(final double height) {
        this.height = height;
    }

    @Override
    public boolean isColliding(final Shape shape) {
        return shape.isColliding(this);
    }

    @Override
    public boolean isColliding(final Circle circle) {
        return circle.isColliding(this);
    }

    @Override
    public boolean isColliding(final Rectangle rectangle) {
        return Math.abs(this.center.getX()-rectangle.getCenter().getX()) < (this.width + rectangle.getWidth())/2 
            && Math.abs(this.center.getY()-rectangle.getCenter().getY()) < (this.height + rectangle.getHeight())/2;
    }
    
}
