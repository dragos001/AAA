package AttackTheCastle;

import javax.swing.*;

public class run extends JPanel implements Runnable {
    Monsters monsters;
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1) {
                monsters.move();
//                checkCollisions();
                repaint();
                delta--;
            }
        }
    }
}
