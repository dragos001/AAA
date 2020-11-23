package AttackTheCastle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    ArrayList<Monsters> listaMeaDeMonstrii = new ArrayList<>();
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = 400;
    Castle castle = new Castle(800, 400, 100, -170, "zid");
    Castle castle2 = new Castle(600, 400, 70, -100, "zid");
    Monsters monsters;
    /* = new Monsters(0, GAME_HEIGHT-10, 100, 10, 0.2);
    Monsters monsters2 = new Monsters(15, GAME_HEIGHT-10, 100, 10, 0.5);*/


    GamePanel() {
        listaMeaDeMonstrii.add(monsters);
//        listaMeaDeMonstrii.add(monsters2);
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        for(int i = 0; i< listaMeaDeMonstrii.size(); i++ ) {
            if(listaMeaDeMonstrii.size() > 20) {
                break;
            }
            Monsters m = new Monsters(0, GAME_HEIGHT-10, 100, 10, 0.2);
            run thread = new run();
            Thread t1 = new Thread(thread);
            t1.start();
            listaMeaDeMonstrii.add(m);
        }


//        run numeThread1 = new run();
//        Thread t1 = new Thread(numeThread1);
//        run numeThread2 = new run();
//        Thread t2 = new Thread(numeThread2);
//
//        numeThread1.monsters = monsters;
//        numeThread2.monsters = monsters2;
//        t1.start();
//        t2.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        castle.draw(g);
        castle2.draw(g);
        for(int i = 0; i<listaMeaDeMonstrii.size(); i++) {
            monsters.draw(g);
        }
        repaint();
    }

    public void move() {

    }

    /*public void run() {
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
    }*/



}
