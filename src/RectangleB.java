/**
 * RectangleB class. Represents a rectangle whose sides are parallel to the axes
 *
 * @author Daniel avidan
 * @version 11/21
 */

public class RectangleB {

    private Point _pointSW;    // Attribute point object pointSW
    private Point _pointNE;     //Attribute point object pointNE
    private final int DEFAULT_VALUE = 1;       //Default value for invalid width or height value
    private final int INVALID_VALUE = 0;       //A number that is not actually positive

    /**
     * Initializes a RectangleB object whose SW  point is at the beginning of the axes
     *
     * @param w Rectangle width
     * @param h Rectangle height
     */

    public RectangleB(int w, int h) {
        int height = checkHeightValue(h);
        int width = checkWidthValue(w);
        this._pointSW = new Point(0, 0);
        this._pointNE = new Point(this._pointSW.getX() + width, this._pointSW.getY() + height);
    }

    /**
     * Initializes a RectangleB object
     *
     * @param p a point object pointSW
     * @param w Rectangle width
     * @param h Rectangle height
     */

    public RectangleB(Point p, int w, int h) {
        int height = checkHeightValue(h);
        int width = checkWidthValue(w);
        this._pointSW = new Point(p);
        this._pointNE = new Point(p.getX() + width, p.getY() + height);
    }

    /**
     * Initializes a RectangleB object
     *
     * @param sw a point object pointSW
     * @param ne a point object pointNE
     */

    public RectangleB(Point sw, Point ne) {
        this._pointSW = new Point(sw);
        this._pointNE = new Point(ne);
    }

    /**
     * Copy constructor for Initializes a new RectangleB object preventing aliasing
     *
     * @param r a point object pointSW
     */

    public RectangleB(RectangleB r) {
        this._pointSW = new Point(r._pointSW);
        this._pointNE = new Point(r._pointNE);
    }

    /**
     * return rectangle width
     *
     * @return Rectangle width
     */
    public int getWidth() {
        return this._pointNE.getX() - this._pointSW.getX();
    }

    /**
     * return rectangle height
     *
     * @return Rectangle height
     */
    public int getHeight() {
        return this._pointNE.getY() - this._pointSW.getY();
    }

    /**
     * return pointNE value
     *
     * @return Point object pointSW of the Rectangle
     */
    public Point getPointSW() {
        return new Point(this._pointSW);
    }

    /**
     * Set a new Rectangle width
     *
     * @param w Rectangle width
     */
    public void setWidth(int w) {
        if (w <= INVALID_VALUE) {
            System.out.println("Invalid Width");
        } else {
            this._pointNE.setX(this._pointSW.getX() + w);
        }
    }

    /**
     * Set a new Rectangle height
     *
     * @param h Rectangle height
     */
    public void setHeight(int h) {
        if (h <= INVALID_VALUE) {
            System.out.println("Invalid Height");
        } else {
            this._pointNE.setY(this._pointSW.getY() + h);
        }

    }

    /**
     * Set a new Point pointSW
     *
     * @param p a point object pointSW
     */
    public void setPointSW(Point p) {
        this._pointNE.move(p.getX() - this._pointSW.getX(), p.getY() - this._pointSW.getY());
        this._pointSW = new Point(p);
    }

    /**
     * Rectangle attributes in a string format
     *
     * @return Rectangle attributes in a string format
     */
    public String toString() {
        return "Width=" + this.getWidth() + " Height=" + this.getHeight() + " PointSW=" + this.getPointSW();
    }

    /**
     * return Rectangle perimeter
     *
     * @return Rectangle perimeter
     */
    public int getPerimeter() {
        return 2 * (this.getHeight() + this.getWidth());    //perimeter of a rectangle formula
    }

    /**
     * return Rectangle area
     *
     * @return Rectangle area
     */
    public int getArea() {
        return this.getHeight() * this.getWidth();          //area of rectangle formula
    }

    /**
     * use this function  for moving the pointSW
     *
     * @param deltaX int  object using for moving the pointSW x value
     * @param deltaY int  object using for moving the pointSW y value
     */
    public void move(int deltaX, int deltaY) {
        this._pointSW.move(deltaX, deltaY);
        this._pointNE.move(deltaX, deltaY);
    }

    /**
     * A function that checks if the rectangles are equal
     *
     * @param other RectangleA  object for compare to
     * @return boolean value true/false
     */
    public boolean equals(RectangleB other) {
        return this.toString().equals(other.toString());
    }

    /**
     * return diagonal length between the sw point to the ne point
     *
     * @return Rectangle diagonalLength
     */
    public double getDiagonalLength() {                     //calculate diagonal using the distance function
        return getPointNE().distance(getPointSW());
    }

    /**
     * A function that checks if the rectangle is larger
     *
     * @param other RectangleA  object for compare to
     * @return boolean value true/false
     */
    public boolean isLarger(RectangleB other) {
        return this.getArea() > other.getArea();
    }

    /**
     * returns pointNE value
     *
     * @return Point object pointNE
     */
    public Point getPointNE() {
        return new Point(this._pointSW.getX() + this.getWidth(), this._pointSW.getY() + this.getHeight());
    }

    /**
     * A function that turns the rectangle
     */
    public void changeSides() {
        int originalHeight = this._pointNE.getY() - this._pointSW.getY();      //using auxiliary variable
        this.setHeight(this._pointNE.getX() - this._pointSW.getX());
        this.setWidth(originalHeight);
    }

    /**
     * A function that checks if a rectangle is contained in another rectangle
     *
     * @param r RectangleA  object to check with
     * @return boolean value true/false
     */
    public boolean isIn(RectangleB r) {
        return (this.getWidth() <= r.getWidth() && this.getHeight() <= r.getHeight()            //first  the width and height must be smaller or equals
                && this._pointSW.getX() >= r._pointSW.getX() && this.getPointNE().getX() <= r.getPointNE().getX()       //check the x value of each point and verify it's between the sw to ne points
                && this._pointSW.getY() >= r._pointSW.getY() && this.getPointNE().getY() <= r.getPointNE().getY());     //check the y value of each point and verify it's between the sw to ne points
    }

    /**
     * A function that checks the overlap of rectangles
     *
     * @param r RectangleA  object to check with
     * @return boolean value true/false
     */
    public boolean overlap(RectangleB r) {
        if (this.getPointNE().isUnder(r.getPointSW())           //if  the ne point under the r sw point or the sw point above the r ne point return false
                || this.getPointSW().isAbove(r.getPointNE())) {
            return false;
        } else if (this.getPointNE().isLeft(r._pointSW)         //if  the ne point is left from the r sw point or the sw point is right from r ne point return false
                || this.getPointSW().isRight(r.getPointNE())) {
            return false;
        } else {
            return true;
        }
    }

    private int checkWidthValue(int w) {        //using private function for repeat code prevention
        if (w <= INVALID_VALUE) {               //ensure the width parameter actually positive
            w = DEFAULT_VALUE;
        }
        return w;
    }

    private int checkHeightValue(int h) {        //using private function for repeat code prevention
        if (h <= INVALID_VALUE) {               //ensure the height parameter actually positive
            h = DEFAULT_VALUE;
        }
        return h;
    }
}
