import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class BrickBreakerGame extends JPanel implements ActionListener, KeyListener {
    private int ballX = 200; 
    private int ballY = 450;
    private int ballSpeedX = 2; 
    private int ballSpeedY = 2;
    private int paddleX = 300; 
    private int score = 0;
    private List<Brick> bricks = new ArrayList<>();

    private boolean leftPressed = false;
    private boolean rightPressed = false;

    public BrickBreakerGame() {
        initializeGame();
    }

    private void initializeGame() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                Brick brick = new Brick(50 + i * 80, 50 + j * 30);
                bricks.add(brick);
            }
        }

        Timer timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.fillRect(paddleX, 550, 100, 8);

        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 20, 20);

        for (Brick brick : bricks) {
            if (brick.isVisible()) {
                g.setColor(Color.BLUE);
                g.fillRect(brick.getX(), brick.getY(), 75, 20);
            }
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, 20, 20);

        if (isGameOver()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", 250, 300);
        }
    }

    private boolean isGameOver() {
        for (Brick brick : bricks) {
            if (brick.isVisible()) {
                return false;
            }
        }
        return true;
    }

    private void move() {
        
        ballX += ballSpeedX;
        ballY += ballSpeedY;
        
        if (ballX <= 0 || ballX >= getWidth() - 20) {
            ballSpeedX = -ballSpeedX;
        }
        if (ballY <= 0) {
            ballSpeedY = -ballSpeedY;
        }

        if (ballY >= 540 && ballX >= paddleX && ballX <= paddleX + 100) {
            ballSpeedY = -ballSpeedY;
        }

        for (Brick brick : bricks) {
            if (brick.isVisible()) {
                if (ballY >= brick.getY() && ballY <= brick.getY() + 20 && ballX >= brick.getX() && ballX <= brick.getX() + 75) {
                    brick.setVisible(false);
                    ballSpeedY = -ballSpeedY;
                    score += 10;
                }
            }
        }
 
        if (ballY >= 580) {
            ballSpeedY = 0;
            ballSpeedX = 0;
        }

        if (leftPressed && paddleX > 0) {
            paddleX -= 5;
        }
        if (rightPressed && paddleX < getWidth() - 100) {
            paddleX += 5;
        }
    }

    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker Game");
        BrickBreakerGame game = new BrickBreakerGame();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(game);
    }

    public static class Brick {
        private int x;
        private int y;
        private boolean visible;

        public Brick(int x, int y) {
            this.x = x;
            this.y = y;
            this.visible = true;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isVisible() {
            return visible;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
        }
    }
}
