package week04;

/**
 * Created by Owner on 4/9/2015.
 */
public class FlipEvent {
    private int startX, startY, xValue, yValue, xIncr, yIncr;
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getxIncr() {
        return xIncr;
    }

    public int getyIncr() {
        return yIncr;
    }

    public int getxValue() {
        return xValue;

    }

    public int getyValue() {
        return yValue;
    }

    public FlipEvent(int startX, int startY, int xValue, int yValue, int xIncr, int yIncr, Player player) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.xIncr = xIncr;
        this.yIncr = yIncr;
        this.startX = startX;
        this.startY = startY;
        this.player = player;
    }
}
