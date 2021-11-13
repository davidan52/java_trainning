public class Main {

    public static void main(String[] args) {
        Point pointA = new Point(3,2);
        Point pointB = new Point(3,2);
        pointA.distance(pointB);
//        System.out.println(pointA.isUnder(pointB));
        RectangleA size = new RectangleA(8,2);
        RectangleA num2 = new RectangleA(5,1);
        Point ne =num2.getPointNE();
        System.out.print(ne);
        boolean TEST = num2.isIn(size);
//        this._width<=r._width && this._height<=r._height && r._pointSW.getX()+this._width <=r._pointNE.getX()
        int test1 = num2.getWidth();
        int test0 = size.getWidth();
        int test2 = size.getPointSW().getX()+num2.getWidth();
        int test3 = size.getPointNE().getX();
        System.out.print(test1+"-------------");
        System.out.print(test0+"-------------");
        boolean test5 = test2<=test3;
        System.out.print(test5);
        System.out.print(test2+"-------------");
        System.out.print(test3);
        System.out.print(TEST);
//        int h =size.getHeight();
//        int w = size.getWidth();
//        System.out.println("height is " + h + " width is " + w);

    }

}
