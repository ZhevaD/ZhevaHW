package zheva.com;

public class PointMain {
    public static void main(String arg[]) {

        Point moscow = new Point(40.1231,31.2355, " Moscow");
        Point london = new Point(43.1321, 21.4232, " London");
        int initArg = 42;
        moscow.setArg100(42);
        System.out.println(initArg);
        london.printSelf();

    }
}
