package week01;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/25/2015 at 7:48 PM.
 */
public class Point {
    private double x;
    private double y;

    public double shiftRight(double shiftAmount){
        x+=shiftAmount;
        return x;
    }
    public double shiftUp(double shiftAmount){
        y+=shiftAmount;
        return y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
