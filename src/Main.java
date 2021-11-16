public class Main {

    public static void main(String[] args) {
        Point pointA = new Point(3,4);
       Point pointB = new Point(2,1);
//        pointA.distance(pointB);
////        System.out.println(pointA.isUnder(pointB));
        RectangleA r = new RectangleA(pointB,5,4);
//        System.out.print(r.getPointSW());
        RectangleA num2 = new RectangleA(pointA,2,5);
//        num2.getPointNE();
        Point TEST=num2.getPointSW();
        TEST.setY(2);
        System.out.print(num2.getPointSW());
        System.out.print(TEST);
//        Point ne =new Point(num2.getPointNE());
//        System.out.print(ne);
        boolean x = num2.isIn(r);
//        this._width<=r._width && this._height<=r._height && r._pointSW.getX()+this._width <=r._pointNE.getX()
//        int test1 = num2.getWidth();
//        int test0 = r.getWidth();
//        int test2 = r.getPointSW().getX()+num2.getWidth();
//        int test3 = r.getPointNE().getX();
//        System.out.print(test1+"-------------");
//        System.out.print(test0+"-------------");
//        boolean test5 = test2<=test3;
//        System.out.print(test5);
//        System.out.print(test2+"-------------");
//        System.out.print(test3);
//        System.out.print(x);
////        int h =size.getHeight();
////        int w = size.getWidth();
////        System.out.println("height is " + h + " width is " + w);
//
    }

}
