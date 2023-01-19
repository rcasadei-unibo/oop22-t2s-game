package it.unibo.t2sgame.common;

public class Vector2D {
    
    private final double x;
    private final double y;

    /**
     * 
     * @param x coordinate of the vector in x axis
     * @param y coordinate of the vector in y axis
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
     * @param x coordinate of the vector in x axis
     * @param y coordinate of the vector in y axis
     * @return the resulting vector
     */
    public Vector2D sum(final double x, final double y) {
        return new Vector2D(this.x+x, this.y+y);
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
    public Vector2D mul(final double scalar) {
        return new Vector2D(this.x*scalar, this.y*scalar);
    }

    /**
     * This method returns the distance between the current point and the given point.
     * @param x coordinate of the point in x axis
     * @param y coordinate of the point in y axis
     * @return the resulting distance
     */
    public double distance(final double x, final double y) {
        return Math.sqrt(Math.pow(x-this.x, 2)+Math.pow(y-this.y, 2));
    }

    /**
     * This method returns the distance between the current point and the given point.
     * @param point the point
     * @return the resulting distance
     */
    public double distance(final Vector2D point) {
        return Math.sqrt(Math.pow(point.x-this.x, 2)+Math.pow(point.y-this.y, 2));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector2D other = (Vector2D) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vector2D [x=" + x + ", y=" + y + "]";
    }

}
