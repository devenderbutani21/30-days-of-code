import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PongGame extends JPanel implements ActionListener, KeyListener {
    private int ballX, ballY;
    private double ballSpeedX, ballSpeedY;
    private int paddle1Y, paddle2Y;
    private int paddleSpeed;
    private int score1, score2;
    private Timer timer;

    public PongGame() {
        ballX = 300;
        ballY = 200;
        ballSpeedX = 2.0;
        ballSpeedY = 1.0;
        paddle1Y = 150;
        paddle2Y = 150;
        paddleSpeed = 5;
        score1 = 0;
        score2 = 0;

        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(20, paddle1Y, 10, 60);
        g.fillRect(570, paddle2Y, 10, 60);
        g.fillOval((int) ballX, (int) ballY, 20, 20);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Player 1: " + score1, 50, 50);
        g.drawString("Player 2: " + score2, 450, 50);
    }

    public void actionPerformed(ActionEvent e) {
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        if (ballY <= 0 || ballY >= 380) {
            ballSpeedY = -ballSpeedY;
        }

        if (ballX <= 30 && ballY >= paddle1Y && ballY <= paddle1Y + 60) {
            ballSpeedX = -ballSpeedX;
            score1++;
        }

        if (ballX >= 550 && ballY >= paddle2Y && ballY <= paddle2Y + 60) {
            ballSpeedX = -ballSpeedX;
            score2++;
        }

        if (ballX <= 0 || ballX >= 580) {
            ballX = 300;
            ballY = 200;
            ballSpeedX = (new Random().nextBoolean() ? 1 : -1) * (1.0 + Math.random() * 2);
            ballSpeedY = (new Random().nextBoolean() ? 1 : -1) * (0.5 + Math.random() * 1.5);
        }

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W && paddle1Y > 0) {
            paddle1Y -= paddleSpeed;
        }
        if (key == KeyEvent.VK_S && paddle1Y < 340) {
            paddle1Y += paddleSpeed;
        }
        if (key == KeyEvent.VK_UP && paddle2Y > 0) {
            paddle2Y -= paddleSpeed;
        }
        if (key == KeyEvent.VK_DOWN && paddle2Y < 340) {
            paddle2Y += paddleSpeed;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        PongGame game = new PongGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
