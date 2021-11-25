public class RectangleB {

    private Point _pointSW;
    private Point _pointNE;
    private final int DEFAULT_VALUE = 1;
    private final int INVALID_VALUE = 0;



    public RectangleB(int w, int h){
        this._pointSW = new Point(0,0);
        this._pointNE = new Point(0,0);
        if (w <= INVALID_VALUE) {
            w = DEFAULT_VALUE;
        } else {
            _pointNE.setX(w);
        }
        if (h <= INVALID_VALUE) {
            h= DEFAULT_VALUE;
        } else {
            _pointNE.setY(h);
        }

//    }
//    public RectangleB(Point p, int w, int h){
//
//    }
//    public RectangleB(Point sw, Point ne){
//
//    }
//    public RectangleB(RectangleB r){
//
    }

}
