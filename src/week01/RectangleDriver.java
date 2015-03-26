package week01;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/25/2015 at 8:22 PM.
 */
public class RectangleDriver {
    public static void main(String[] args) {
        Point topLeft = new Point(-3,1);
        Point bottomRight = new Point(3,-1);
        Rectangle rectangle = new Rectangle(topLeft,bottomRight);
        rectangle.printCenter();
        rectangle.shiftUp(rectangle.shiftRight(1));
        rectangle.printCenter();
    }
}
