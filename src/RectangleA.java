
public class RectangleA {
    private int _width;
    private int _height;
    private Point _pointSW;
    private Point _pointNE;
    public RectangleA(int w, int h) {
        this._pointSW = new Point(0, 0);
        this.getPointNE();
        if (w < 0) {
            this._width = 1;
        } else {
            this._width = w;
        }

        if (h < 0) {
            this._height = 1;
        } else {
            this._height = h;
        }

    }

    public RectangleA(Point p, int w, int h) {
        this(w, h);
        if (p != null) {
            this._pointSW = p;
            this.getPointNE();

        }

    }

    public RectangleA(Point sw, Point ne) {
        this._width = ne.getX()-sw.getX();
        this._height = ne.getY()-sw.getY();
        this._pointSW = new Point(sw);
        this._pointNE = new Point(ne);
    }

    public RectangleA(RectangleA r) {
        this._width = r._width;
        this._height = r._height;
        this._pointNE = new Point(r._pointNE);
        this._pointSW = new Point(r._pointSW);
    }

    public int getWidth() {
        return this._width;
    }

    public int getHeight() {
        return this._height;
    }

    public Point getPointSW() {
        return this._pointSW;
    }

    public void setWidth(int w) {
        if (w < 0) {
            System.out.println("Invalid Width");
        } else {
            this._width = w;
        }

    }

    public void setHeight(int h) {
        if (h < 0) {
            System.out.println("Invalid Height");
        } else {
            this._height = h;
        }

    }

    public void setPointSW(Point p) {
        this._pointSW = new Point(p);
    }

    public String toString() {
        return "Width=" + this._width + " Height=" + this._height + " PointSW=" + this._pointSW;
    }

    public int getPerimeter() {
        return 2 * (this._height + this._width);
    }

    public int getArea() {
        return this._height * this._width;
    }

    public void move(int deltaX, int deltaY) {
        this._pointSW.move(deltaX, deltaY);
//        this._pointNE.move(deltaX, deltaY);
    }

    public boolean equals(RectangleA other) {
        return this.toString().equals(other.toString());
    }

    public double getDiagonalLength() {
        return Math.sqrt((double)(this._height * this._height + this._width * this._width));
    }

    public boolean isLarger(RectangleA other) {
        return this.getArea() > other.getArea();
    }

    public Point getPointNE() {
        int neX = this._pointSW.getX() + this._width;
        int neY = this._pointSW.getY() + this._height;
        this._pointNE = new Point(neX,neY);
        return this._pointNE;
    }
    public void changeSides(){
        int originalHeight = this._height;
        this.setHeight(this._width);
        this.setWidth(originalHeight);
    }

    public boolean isIn(RectangleA r) {
        return ( (this._width<=r._width) && (this._height<=r._height) && (r._pointSW.getX()+this._width <=r._pointNE.getX()) && (r._pointSW.getY() + this._height<=r._pointNE.getY()));
    }
}