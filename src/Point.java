//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Point {
    private int _x;
    private int _y;
    private final int DEFAULT_VALUE = 0;

    public Point(int x, int y) {
//        if (x >= 0 && y >= 0) {
            this._x = x;
            this._y = y;
//        } else if (x < 0) {
//            this._x = 0;
//        } else {
//            this._y = 0;
//        }

    }

    public Point(Point other) {
        this._x = other._x;
        this._y = other._y;
    }

    public int getX() {
        return this._x;
    }

    public int getY() {
        return this._y;
    }

    public void setX(int num) {
        if (num >= 0) {
            this._x = num;
        }

    }

    public void setY(int num) {
        if (num >= 0) {
            this._y = num;
        }

    }

    public String toString() {
        return "(" + this._x + "," + this._y + ")";
    }

    public boolean equals(Point other)  {
        return other._x == this._x && other._y == this._y;
    }

    public boolean isAbove(Point other) {
        return this._y > other._y;
    }

    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    public boolean isLeft(Point other) {
        return this._x < other._x;
    }

    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    public void move(int deltaX, int deltaY) {
//        if (deltaX >= 0 && deltaY >= 0) {
            this._x += deltaX;
            this._y += deltaY;
//        } else {
//            System.out.println("Exceeds the limits of the first quarter");
//        }

    }

    public double distance(Point p) {
        double calculate = (double)((p._x - this._x) * (p._x - this._x) + (p._y - this._y) * (p._y - this._y));
        return Math.sqrt(calculate);
    }
}
