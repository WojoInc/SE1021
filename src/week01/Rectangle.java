package week01;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/25/2015 at 8:08 PM.
 */
public class Rectangle {
    Point topLeft;
    Point bottomRight;

    public double shiftRight(double shiftAmount){
        topLeft.shiftRight(shiftAmount);
        bottomRight.shiftRight(shiftAmount);
        return shiftAmount;
    }
    public double shiftUp(double shiftAmount){
        topLeft.shiftUp(shiftAmount);
        bottomRight.shiftUp(shiftAmount);
        return shiftAmount;
    }
    public void printCenter(){
        Point center = new Point((bottomRight.getX() + topLeft.getX())/2,(bottomRight.getY() + topLeft.getY())/2);
        System.out.println(center.getX()+","+ center.getY());
    }
    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
}