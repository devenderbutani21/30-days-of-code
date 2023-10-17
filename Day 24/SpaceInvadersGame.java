import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Spaceship spaceship;
    private List<Alien> aliens;
    private List<Bullet> bullets;
    private boolean isGameOver;
    private int score;

    private final int SCREEN_WIDTH = 800;
    private final int SCREEN_HEIGHT = 600;
    private final int SPACESHIP_SPEED = 5;
    private final int ALIEN_SPEED = 2;
    private final int BULLET_SPEED = 5;
    private final int ALIEN_ROWS = 4;
    private final int ALIEN_COLS = 10;

    public SpaceInvadersGame() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        initializeGame();
    }

    private void initializeGame() {
        spaceship = new Spaceship();
        aliens = new ArrayList<>();
        bullets = new ArrayList();
        isGameOver = false;
        score = 0;

        for (int i = 0; i < ALIEN_ROWS; i++) {
            for (int j = 0; j < ALIEN_COLS; j++) {
                aliens.add(new Alien(50 + j * 70, 50 + i * 50));
            }
        }

        timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        if (!isGameOver) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

            spaceship.draw(g);

            for (Alien alien : aliens) {
                alien.draw(g);
            }

            for (Bullet bullet : bullets) {
                bullet.draw(g);
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Score: " + score, 20, 30);
        } else {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", 300, 300);
        }
    }

    private void move() {
        spaceship.move();

        for (Alien alien : aliens) {
            alien.move();
            if (alien.intersects(spaceship)) {
                isGameOver = true;
            }
        }

        List<Bullet> bulletsToRemove = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.move();
            if (bullet.getY() < 0) {
                bulletsToRemove.add(bullet);
            } else {
                for (Alien alien : aliens) {
                    if (bullet.intersects(alien)) {
                        bulletsToRemove.add(bullet);
                        aliens.remove(alien);
                        score += 10;
                        break;
                    }
                }
            }
        }
        bullets.removeAll(bulletsToRemove);

        if (aliens.isEmpty()) {
            isGameOver = true;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            move();
            repaint();
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            spaceship.moveLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            spaceship.moveRight();
        }
        if (key == KeyEvent.VK_SPACE) {
            bullets.add(new Bullet(spaceship.getX() + 20, spaceship.getY()));
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Invaders Game");
        SpaceInvadersGame game = new SpaceInvadersGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public class Spaceship {
        private int x;
        private int y;
        private int width = 50;
        private int height = 30;
    
        public Spaceship() {
            x = SCREEN_WIDTH / 2 - width / 2;
            y = SCREEN_HEIGHT - 50 - height / 2;
        }
    
        public int getX() {
            return x;
        }
    
        public int getY() {
            return y;
        }
    
        public void draw(Graphics g) {
            int[] xPoints = { x + width / 2, x, x + width };
            int[] yPoints = { y, y + height, y + height };
            int nPoints = 3;
    
            g.setColor(Color.BLUE);
            g.fillPolygon(xPoints, yPoints, nPoints);
        }
    
        public void moveLeft() {
            if (x > 0) {
                x -= SPACESHIP_SPEED;
            }
        }
    
        public void moveRight() {
            if (x < SCREEN_WIDTH - width) {
                x += SPACESHIP_SPEED;
            }
        }
    
        public void move() {
        }
        
        public int getTopPointX() {
            return x + width / 2;
        }
        
        public int getTopPointY() {
            return y;
        }
    }
        

    public class Alien {
        private int x;
        private int y;
        private int direction;

        public Alien(int x, int y) {
            this.x = x;
            this.y = y;
            direction = 1;
        }

        public void draw(Graphics g) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 50, 30);
        }

        public void move() {
            x += direction * ALIEN_SPEED;

            if (x <= 0 || x >= SCREEN_WIDTH - 50) {
                y += 20;
                direction = -direction;
            }

            if (y >= SCREEN_HEIGHT - 50) {
                isGameOver = true;
            }
        }

        public boolean intersects(Spaceship spaceship) {
            return x < spaceship.getX() + 50 && x + 50 > spaceship.getX()
                    && y < spaceship.getY() + 30 && y + 30 > spaceship.getY();
        }
    }

    public class Bullet {
        private int x;
        private int y;

        public Bullet(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getY() {
            return y;
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x, y, 5, 10);
        }

        public void move() {
            y -= BULLET_SPEED;
        }

        public boolean intersects(Alien alien) {
            return x < alien.x + 50 && x + 5 > alien.x
                    && y < alien.y + 30 && y + 10 > alien.y;
        }
    }
}
