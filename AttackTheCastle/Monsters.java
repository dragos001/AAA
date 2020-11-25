package AttackTheCastle;

import java.awt.*;

public class Monsters {
    int type;
    boolean condition;
    double x;
    int y;
    int hp;
    int power;
    double speed;
    Monsters(int type, boolean condition, double x, int y, int hp, int power, double speed) {
        this.type = type;
        this.condition = condition;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.power = power;
        this.speed = speed;
    }

    public void setXDirection(double xDirection) {
        speed = xDirection;
    }

    public void move() {
        setXDirection(speed);
        x = x + speed;
    }

    public void draw(Graphics g) {
        if(condition && type == 1)
        {
            g.setColor(Color.red);
            g.fillRect((int)x,y,10,10);
        }
        if(condition && type == 2)
        {
            g.setColor(Color.blue);
            g.fillRect((int)x,y,10,20);
        }
        if(condition && type == 3)
        {
            g.setColor(Color.green);
            g.fillRect((int)x,y,10,25);
        }
    }
}
