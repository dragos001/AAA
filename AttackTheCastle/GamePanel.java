package AttackTheCastle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel implements ActionListener {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = 400;
    static final int DELAY = 50;
    static int NR_MOBS = 1;
    Timer timer;
    Timer mobTimer;
    Random random;
    boolean running = false;
    Castle castle = new Castle(800, 400, 100, -170, "zid");
    Castle castle2 = new Castle(600, 400, 70, -100, "zid");
    Monsters[] m = new Monsters[50];


    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        int nr = 1+ random.nextInt(10);
        for(int i = 0; i < m.length; i++) {
            m[i] = new Monsters(1, true, nr, GAME_HEIGHT-10, random.nextInt(50), 10, 5);
        }
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
        final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleWithFixedDelay(() -> addMonster(NR_MOBS), 0, 1, TimeUnit.SECONDS);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        castle.draw(g);
        castle2.draw(g);
        for (Monsters monsters : m) {
            monsters.draw(g);
        }
    }

    public void addMonster(int nrMonstru) {
        int nr = 1+ random.nextInt(10);
        if(NR_MOBS == m.length-1) {
            NR_MOBS = 0;
        }
        m[nrMonstru] = new Monsters(1+random.nextInt(3), true, nr, GAME_HEIGHT-10, random.nextInt(50), 10, 5);
        NR_MOBS++;
    }

    public void checkCollisions() {
        try {
            for (Monsters monsters : m) {
                if (monsters.x > castle.x - 10) {
                    monsters.condition = false;
                }
            }
        } catch(NullPointerException z) {
            System.out.println("Null pointer found");
        }
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                addMonster(NR_MOBS);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            try {
                for (Monsters monsters : m) {
                    if (monsters != null) {
                        monsters.move();
                    }
                }
            }
            catch(NullPointerException d)
            {
                System.out.println("NullPointer");
            }

            checkCollisions();
        }
        repaint();
    }
}
