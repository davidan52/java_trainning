/**
 * Point class. Represents a point on the Cartesian coordinate system
 *
 * @author Daniel avidan
 * @version 11/21
 */

public class Point {
    private int _x;         //x-coordinate
    private int _y;         //y-coordinate

    /**
     * Initializes a Point object
     *
     * @param x Point x-coordinate
     * @param y Point y-coordinate
     */
    public Point(int x, int y) {
        this._x = x;
        this._y = y;
    }

    /**
     * Copy constructor for Initializes a new Point object preventing aliasing
     *
     * @param other a point object pointSW
     */
    public Point(Point other) {
        this._x = other._x;
        this._y = other._y;
    }

    /**
     * @return Point x-coordinate
     */
    public int getX() {
        return this._x;
    }

    /**
     * @return Point y-coordinate
     */
    public int getY() {
        return this._y;
    }

    /**
     * Set a new Point x-coordinate
     *
     * @param num int
     */
    public void setX(int num) {
        this._x = num;
    }

    /**
     * Set a new Point y-coordinate
     *
     * @param num int
     */
    public void setY(int num) {
        this._y = num;
    }

    /**
     * @return Point attributes in a string format
     */
    public String toString() {
        return "(" + this._x + "," + this._y + ")";
    }

    /**
     * A function that checks if the Points are equals
     *
     * @param other Point  object for compare to
     * @return boolean true or false
     */
    public boolean equals(Point other) {
        return other._x == this._x && other._y == this._y;
    }

    /**
     * A function that checks if the Point is above to other point
     *
     * @param other Point  object for compare to
     * @return boolean true or false
     */
    public boolean isAbove(Point other) {
        return this._y > other._y;
    }

    /**
     * A function that checks if the Point is under to other point
     *
     * @param other Point  object for compare to
     * @return boolean true or false
     */
    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    /**
     * A function that checks if the Point is left to other point
     *
     * @param other Point  object for compare to
     * @return boolean true or false
     */
    public boolean isLeft(Point other) {
        return this._x < other._x;
    }

    /**
     * A function that checks if the Point is right to other point
     *
     * @param other Point  object for compare to
     * @return boolean true or false
     */
    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    /**
     * use this function  to move the point
     *
     * @param deltaX int  object using for moving the point x value
     * @param deltaY int  object using for moving the point y value
     */
    public void move(int deltaX, int deltaY) {
        this._x += deltaX;
        this._y += deltaY;
    }

    /**
     * @param p Point  object for distance check
     * @return the distance between two points
     */
    public double distance(Point p) {
        double calculate = (double) ((p._x - this._x) * (p._x - this._x) + (p._y - this._y) * (p._y - this._y)); // distance formula
        return Math.sqrt(calculate);
    }
}
