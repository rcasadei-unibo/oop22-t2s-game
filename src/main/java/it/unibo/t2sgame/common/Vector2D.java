package it.unibo.t2sgame.common;

public class Vector2D {
    
    private final double x;
    private final double y;

    /**
     * 
     * @param x coordinate of the point in x axis
     * @param y coordinate of the point in y axis
     */
    public Vector2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @return coordinate of the vector in x axis
     */
    public double getX() {
        return this.x;
    }

    /**
     * 
     * @return coordinate of the vector in y axis
     */
    public double getY() {
        return this.y;
    }

    /**
     * This method sums the current vector with the given vector and returns the new vector.
     * @param vector the vector to sum
     * @return the resulting vector
     */
    public Vector2D sum(final Vector2D vector) {
        return new Vector2D(this.x+vector.x, this.y+vector.y);
    }

    /**
     * This method multiply the current vector with the given value and returns the new vector.
     * @param scalar the value to multiply
     * @return the resulting vector
     */
    public Vector2D mul(double scalar) {
        return new Vector2D(this.x*scalar, this.y*scalar);
    }

    /**
     * This method returns the distance between the current point and the given point.
     * @param point the point to sum
     * @return the resulting distance
     */
    public double distance(final Vector2D vector) {
        return Math.sqrt(Math.pow(vector.x-this.x, 2)+Math.pow(vector.y-this.y, 2));
    }

}
