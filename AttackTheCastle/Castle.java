package AttackTheCastle;

import java.awt.*;

public class Castle extends Rectangle {
    int x;
    int y;
    int width;
    int height;
    String type;
    Castle(int x, int y, int width, int height, String type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
        g.setColor(Color.WHITE);
    }
}
