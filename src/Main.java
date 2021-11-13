public class Main {

    public static void main(String[] args) {
        Point pointA = new Point(3,2);
        Point pointB = new Point(3,2);
        pointA.distance(pointB);
//        System.out.println(pointA.isUnder(pointB));
        RectangleA size = new RectangleA(8,2);

        Point ne = size.getPointNE();
        System.out.print(ne);
//        int h =size.getHeight();
//        int w = size.getWidth();
//        System.out.println("height is " + h + " width is " + w);

    }

}
