package AttackTheCastle;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.awt.*;
import java.util.ArrayList;

public class Monsters {
    double x;
    int y;
    int hp;
    int power;
    double speed;
    Monsters(double x, int y, int hp, int power, double speed) {
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
        g.setColor(Color.red);
        g.fillRect((int)x,y,10,10);
    }

    /*public void spawnMonsters(int x, int y, int hp, int power, int speed) {
        Monsters monster = new Monsters(x,y,hp,power,speed);
        monster.listaMeaDeMonstrii.add(monster);
    }*/
}
