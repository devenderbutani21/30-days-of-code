import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FlappyBirdGame extends JPanel implements ActionListener, KeyListener {
    private int birdY;
    private int birdVelocity;
    private int gravity;
    private boolean isGameOver;
    private int pipeX;
    private int pipeY;
    private int pipeWidth;
    private int pipeHeight;
    private int gap;
    private Timer timer;

    public FlappyBirdGame() {
        birdY = 150;
        birdVelocity = 0;
        gravity = 2;
        isGameOver = false;
        pipeX = 300;
        pipeY = 0;
        pipeWidth = 50;
        pipeHeight = 200;
        gap = 100;

        timer = new Timer(20, this);
        timer.start();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isGameOver) {
            // Draw bird
            g.setColor(Color.BLUE);
            g.fillRect(100, birdY, 30, 30);

            // Draw pipes
            g.setColor(Color.GREEN);
            g.fillRect(pipeX, pipeY, pipeWidth, pipeHeight);
            g.fillRect(pipeX, pipeHeight + gap, pipeWidth, 600 - pipeHeight - gap);
        } else {
            g.setColor(Color.RED);
            g.drawString("Game Over!", 150, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        birdY += birdVelocity;
        birdVelocity += gravity;

        if (birdY > 600) {
            isGameOver = true;
        }

        if (pipeX > -pipeWidth) {
            pipeX -= 5;
        } else {
            pipeX = 400;
        }

        // Collision detection
        if ((birdY < pipeHeight || birdY + 30 > pipeHeight + gap) && (pipeX < 130 && pipeX + pipeWidth > 100)) {
            isGameOver = true;
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !isGameOver) {
            birdVelocity = -20;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        FlappyBirdGame game = new FlappyBirdGame();
        frame.add(game);
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
