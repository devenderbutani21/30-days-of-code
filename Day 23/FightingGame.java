import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FightingGame extends JPanel implements ActionListener {
    private int player1X, player1Y;
    private int player2X, player2Y;
    private Timer timer;

    public FightingGame() {
        player1X = 50;
        player1Y = 200;
        player2X = 400;
        player2Y = 200;

        timer = new Timer(10, this);
        timer.start();

        addKeyListener(new KeyInput());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        // Draw players
        g.setColor(Color.RED);
        g.fillRect(player1X, player1Y, 50, 50);

        g.setColor(Color.BLUE);
        g.fillRect(player2X, player2Y, 50, 50);
    }

    public void actionPerformed(ActionEvent e) {
        // Update game logic here
        repaint();
    }

    private class KeyInput extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_A) {
                // Move player 1 left
                player1X -= 5;
            }
            if (key == KeyEvent.VK_D) {
                // Move player 1 right
                player1X += 5;
            }
            if (key == KeyEvent.VK_LEFT) {
                // Move player 2 left
                player2X -= 5;
            }
            if (key == KeyEvent.VK_RIGHT) {
                // Move player 2 right
                player2X += 5;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fighting Game");
        FightingGame game = new FightingGame();
        frame.add(game);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
