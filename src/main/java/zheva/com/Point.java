package zheva.com;

public class Point {

    public final double pointX;
    public final double pointY;
    private final String pointName;




    public Point(double pointX , double pointY, String pointName) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.pointName = pointName;

    }

    public Point inverse() {
        return new Point(pointY,pointX,pointName);
    }
    public void printSelf() {
        System.out.println("pointX: " + pointX + " PointY " + pointY + pointName);
    }

    public void setArg100 (int arg){
        arg = 100 ;
    }
}