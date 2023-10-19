import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Car playerCar;
    private List<Car> enemyCars;
    private boolean isGameOver;
    private int score;

    private final int SCREEN_WIDTH = 400;
    private final int SCREEN_HEIGHT = 600;
    private final int CAR_SPEED = 5;
    private final int ENEMY_CAR_SPEED = 3;
    private final int ENEMY_CAR_SPAWN_INTERVAL = 100;
    private final int CAR_WIDTH = 60; // Increased car size
    private final int CAR_HEIGHT = 100; // Increased car size

    public RaceGame() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        initializeGame();
    }

    private void initializeGame() {
        playerCar = new Car(SCREEN_WIDTH / 2 - CAR_WIDTH / 2, SCREEN_HEIGHT - CAR_HEIGHT - 10, Color.BLUE);
        enemyCars = new ArrayList<>();
        isGameOver = false;
        score = 0;

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

            playerCar.draw(g);

            for (Car enemyCar : enemyCars) {
                enemyCar.draw(g);
            }

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Score: " + score, 20, 30);
        } else {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40)); // Increased game over message size
            g.drawString("Game Over", 100, 300);
        }
    }

    private void move() {
        for (Car enemyCar : enemyCars) {
            enemyCar.move();
            if (playerCar.intersects(enemyCar)) {
                isGameOver = true;
            }
        }

        enemyCars.removeIf(car -> car.getY() > SCREEN_HEIGHT);

        if (score % ENEMY_CAR_SPAWN_INTERVAL == 0) {
            int randomX = new Random().nextInt(SCREEN_WIDTH - CAR_WIDTH);
            enemyCars.add(new Car(randomX, 0, Color.RED));
        }

        if (!isGameOver) {
            score++;
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
            playerCar.moveLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            playerCar.moveRight();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Race Game");
        RaceGame game = new RaceGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public class Car {
        private int x;
        private int y;
        private int width = CAR_WIDTH;
        private int height = CAR_HEIGHT;
        private Color color;

        public Car(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }

        public void moveLeft() {
            if (x > 0) {
                x -= CAR_SPEED;
            }
        }

        public void moveRight() {
            if (x + width < SCREEN_WIDTH) {
                x += CAR_SPEED;
            }
        }

        public void move() {
            y += ENEMY_CAR_SPEED;
        }

        public boolean intersects(Car otherCar) {
            return x < otherCar.x + otherCar.width && x + width > otherCar.x
                    && y < otherCar.y + otherCar.height && y + height > otherCar.y;
        }
    }
}
