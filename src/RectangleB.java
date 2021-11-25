import javax.naming.NamingEnumeration;

public class RectangleB {

    private Point _pointSW ;
    private Point _pointNE;
    private final int DEFAULT_VALUE = 1;
    private final int INVALID_VALUE = 0;



    public RectangleB(int w, int h){
        this._pointSW = new Point(0,0);

        this._pointNE = new Point(this._pointSW.getX()+w,this._pointSW.getY()+h);
        }

    public RectangleB(Point p, int w, int h) {
        if (w <= INVALID_VALUE) {
            w = DEFAULT_VALUE;
        }
        if (h <= INVALID_VALUE) {
            h =DEFAULT_VALUE;
        }
        this._pointSW = new Point(p);
        this._pointNE = new Point(p.getX()+w,p.getY()+h);
    }

    public RectangleB(Point sw, Point ne){
        this._pointSW = new Point(sw);
        this._pointNE = new Point(ne);
        }

    public RectangleB(RectangleB r){
        this._pointSW = new Point(r._pointSW);
        this._pointNE = new Point(r._pointNE);
    }

    public  int getWidth() {
        return this._pointNE.getX()-this._pointSW.getX();
    }

    public int getHeight() {
        return this._pointNE.getY()-this._pointSW.getY();
    }

    public Point getPointSW() {
        return new Point(this._pointSW);
    }

    public void setWidth(int w) {
        if (w <= INVALID_VALUE) {
            System.out.println("Invalid Width");
        } else {
            this._pointNE.setX(this._pointSW.getX()+w);
        }

    }

    public void setHeight(int h) {
        if (h <= INVALID_VALUE) {
            System.out.println("Invalid Height");
        } else {
            this._pointNE.setY(this._pointSW.getY()+h);;
        }

    }

    public void setPointSW(Point p) {
        this._pointNE.move(p.getX()-this._pointSW.getX(),p.getY()-this._pointSW.getY());
        this._pointSW = new Point(p);
    }

    public String toString() {
        return "Width=" + this.getWidth() + " Height=" + this.getHeight() + " PointSW=" + this.getPointSW();
    }

    public int getPerimeter() {
        return 2 * (this.getHeight() + this.getWidth());
    }

    public int getArea() {
        return this.getHeight() * this.getWidth();
    }

    public void move(int deltaX, int deltaY) {
        this._pointSW.move(deltaX, deltaY);
        this._pointNE.move(deltaX,deltaY);

    }

    public boolean equals(RectangleB other) {
        return this.toString().equals(other.toString());
    }

    public double getDiagonalLength() {
        return getPointNE().distance(getPointSW());
    }

    public boolean isLarger(RectangleB other) {
        return this.getArea() > other.getArea();
    }

    public Point getPointNE() {
        return new Point(this._pointSW.getX()+this.getWidth(),this._pointSW.getY()+this.getHeight());
    }

    public void changeSides() {
        int originalHeight = this._pointNE.getY()-this._pointSW.getY();
        this.setHeight(this._pointNE.getX()-this._pointSW.getX());
        this.setWidth(originalHeight);
    }

    public boolean isIn(RectangleB r) {
        return (this.getWidth() <= r.getWidth() && this.getHeight() <= r.getHeight()
                && this._pointSW.getX() >= r._pointSW.getX() && this.getPointNE().getX() <= r.getPointNE().getX()
                && this._pointSW.getY() >= r._pointSW.getY() && this.getPointNE().getY() <= r.getPointNE().getY());
    }

    public boolean overlap(RectangleB r) {
        if (this.getPointNE().isUnder(r.getPointSW())
                || this.getPointSW().isAbove(r.getPointNE())) {
            return false;
        }
        else if (this.getPointNE().isLeft(r._pointSW)
                || this.getPointSW().isRight(r.getPointNE())) {
            return false;
        } else {
            return true;
        }
    }
}
