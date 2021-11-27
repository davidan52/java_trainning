/**
 * RectangleA class. Represents a rectangle whose sides are parallel to the axes
 *@author Daniel avidan
 * @version 11/21
 *
 */




public class RectangleA {

    private int _width;         // width attribute
    private int _height;        //rectangle height attribute
    private Point _pointSW;     //point object pointSW
    private final int DEFAULT_VALUE = 1;    //Default value for invalid width or height value
    private final int INVALID_VALUE = 0;    //A number that is not actually positive
    /**
     * Initializes a RectangleA object whose SW  point is at the beginning of the axes
     * @param  w Rectangle width
     * @param h Rectangle height
     */

    public RectangleA(int w, int h) {
        if (w <= INVALID_VALUE) {
            this._width = DEFAULT_VALUE;
        } else {
            this._width = w;
        }
        if (h <= INVALID_VALUE) {
            this._height = DEFAULT_VALUE;
        } else {
            this._height = h;
        }
        this._pointSW = new Point(0, 0);
    }
    /**
     * Initializes a RectangleA object
     * @param p a point object pointSW
     * @param w Rectangle width
     * @param h Rectangle height
     */


    public RectangleA(Point p, int w, int h) {
        this(w, h);
        if (p != null) {
            this._pointSW = new Point(p);

        }

    }
    /**
     * Initializes a RectangleA object
     * @param sw a point object pointSW
     * @param ne a point object pointNE
     */

    public RectangleA(Point sw, Point ne) {
        this._width = ne.getX() - sw.getX();
        this._height = ne.getY() - sw.getY();
        this._pointSW = new Point(sw);
    }
    /**
     * Copy constructor for Initializes a new RectangleA object preventing aliasing
     * @param r a point object pointSW
     */

    public RectangleA(RectangleA r) {
        this._width = r._width;
        this._height = r._height;
        this._pointSW = new Point(r._pointSW);
    }
    /**
     * @return  Rectangle width
     */
    public int getWidth() {
        return this._width;
    }
    /**
     * @return  Rectangle height
     */

    public int getHeight() {
        return this._height;
    }
    /**
     * @return  Point object pointSW of the Rectangle
     */
    public Point getPointSW() {
        return new Point(this._pointSW);
    }
    /**
     * Set a new Rectangle width
     * @param w Rectangle width
     */
    public void setWidth(int w) {
        if (w <= INVALID_VALUE) {
            System.out.println("Invalid Width");
        } else {
            this._width = w;
        }

    }
    /**
     * Set a new Rectangle height
     * @param h Rectangle height
     */

    public void setHeight(int h) {
        if (h <= INVALID_VALUE) {
            System.out.println("Invalid Height");
        } else {
            this._height = h;
        }

    }
    /**
     * Set a new Point pointSW
     * @param p a point object pointSW
     */
    public void setPointSW(Point p) {
        this._pointSW = new Point(p);
    }
    /**
     * @return   Rectangle attributes in a string format
     */
    public String toString() {
        return "Width=" + this._width + " Height=" + this._height + " PointSW=" + this._pointSW;
    }
    /**
     * @return   Rectangle perimeter
     */
    public int getPerimeter() {
        return 2 * (this._height + this._width);
    }
    /**
     * @return   Rectangle area
     */

    public int getArea() {
        return this._height * this._width;
    }
    /**
     * use this function  for moving the pointSW
     * @param deltaX  int  object using for moving the pointSW x value
     * @param deltaY int  object using for moving the pointSW y value
     */
    public void move(int deltaX, int deltaY) {
        this._pointSW.move(deltaX, deltaY);
    }
    /**
     * A function that checks if the rectangles are equal
     * @param other  RectangleA  object for compare to
     */
    public boolean equals(RectangleA other) {
        return this.toString().equals(other.toString());
    }
    /**
     * @return   Rectangle diagonalLength
     */
    public double getDiagonalLength() {
        return getPointNE().distance(_pointSW);
    }
    /**
     * A function that checks if the rectangle is larger
     * @param other  RectangleA  object for compare to
     */
    public boolean isLarger(RectangleA other) {
        return this.getArea() > other.getArea();
    }
    /**
     * @return Point object pointNE
     */
    public Point getPointNE() {
        Point pointNe;
        int neX = this._pointSW.getX() + this._width;
        int neY = this._pointSW.getY() + this._height;
        pointNe = new Point(neX, neY);
        return pointNe;
    }
    /**
     * A function that turns the rectangle
     */

    public void changeSides() {
        int originalHeight = this._height;
        this.setHeight(this._width);
        this.setWidth(originalHeight);
    }
    /**
     * A function that checks if a rectangle is contained in another rectangle
     * @param r  RectangleA  object to check with
     */
    public boolean isIn(RectangleA r) {
        return (this._width <= r._width && this._height <= r._height
                && this._pointSW.getX() >= r._pointSW.getX() && this.getPointNE().getX() <= r.getPointNE().getX()
                && this._pointSW.getY() >= r._pointSW.getY() && this.getPointNE().getY() <= r.getPointNE().getY());
    }

    /**
     * A function that checks the overlap of rectangles
     * @param r  RectangleA  object to check with
     */

    public boolean overlap(RectangleA r) {
        if (this.getPointNE().isUnder(r._pointSW)
                || this._pointSW.isAbove(r.getPointNE())) {
            return false;
        }
        else if (this.getPointNE().isLeft(r._pointSW)
                || this._pointSW.isRight(r.getPointNE())) {
            return false;
        } else {
            return true;
        }
    }
}


