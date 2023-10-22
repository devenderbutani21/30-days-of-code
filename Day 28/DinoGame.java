import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class DinoGame extends JPanel implements ActionListener, KeyListener {
    private int dinoX, dinoY, dinoWidth, dinoHeight;
    private boolean jumping, gameOver;
    private ArrayList<Pipe> pipes;
    private Timer timer;
    private int groundY;
    private int score;
    private int jumpHeight;
    private int gravity;

    public DinoGame() {
        dinoX = 100;
        dinoY = 300;
        dinoWidth = 50;
        dinoHeight = 50;
        jumping = false;
        gameOver = false;
        pipes = new ArrayList<>();
        groundY = 350;
        score = 0;
        jumpHeight = 100;
        gravity = 2; 

        generatePipes();
        
        timer = new Timer(20, this);
        timer.start();
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.GREEN);
        g.fillRect(0, groundY, 800, 100);        
        g.setColor(Color.RED);
        g.fillRect(dinoX, dinoY, dinoWidth, dinoHeight);

        for (Pipe pipe : pipes) {
            g.setColor(Color.GREEN);
            g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, 20, 30);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", 300, 200);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            
            if (jumping) {
                dinoY -= 5;
                jumpHeight -= 5;
                if (jumpHeight <= 0) {
                    jumping = false;
                }
            } else if (dinoY < groundY - dinoHeight) {
                dinoY += gravity; 
            }

            for (Pipe pipe : pipes) {
                pipe.x -= 5;
            }

            checkCollisions();

            pipes.removeIf(pipe -> pipe.x + pipe.width < 0);

            if (pipes.isEmpty() || pipes.get(pipes.size() - 1).x < 200) {
                generatePipes();
            }

            score++;
        }

        repaint();
    }

    private void generatePipes() {
        Random rand = new Random();
        int pipeHeight = rand.nextInt(100) + 50; 
        Pipe newPipe = new Pipe(1000, groundY - pipeHeight, 50, pipeHeight);
        pipes.add(newPipe);
    }

    private void checkCollisions() {
        for (Pipe pipe : pipes) {
            if (dinoX + dinoWidth > pipe.x && dinoX < pipe.x + pipe.width
                    && dinoY + dinoHeight > pipe.y) {
                gameOver = true;
                timer.stop();
                break;
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !jumping && !gameOver) {
            jumping = true;
            jumpHeight = 100; 
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dino Game");
        DinoGame game = new DinoGame();
        frame.add(game);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Pipe {
    int x, y, width, height;

    public Pipe(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
