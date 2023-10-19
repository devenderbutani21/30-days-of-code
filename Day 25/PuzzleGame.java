import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PuzzleGame extends JFrame implements KeyListener, ActionListener {
    private JPanel puzzlePanel;
    private JButton[][] buttons;
    private int[][] puzzle;
    private int emptyRow, emptyCol;
    private final int SIZE = 3;
    
    public PuzzleGame() {
        setTitle("Puzzle Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setFocusable(true);
        addKeyListener(this);

        puzzlePanel = new JPanel(new GridLayout(SIZE, SIZE, 2, 2));
        buttons = new JButton[SIZE][SIZE];
        puzzle = new int[SIZE][SIZE];
        int count = 1;
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton("" + count);
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 24));
                buttons[i][j].addActionListener(this);
                puzzlePanel.add(buttons[i][j]);
                puzzle[i][j] = count;
                count++;
            }
        }
        
        buttons[SIZE-1][SIZE-1].setText("");
        puzzle[SIZE-1][SIZE-1] = 0;
        emptyRow = SIZE - 1;
        emptyCol = SIZE - 1;
        
        add(puzzlePanel);
        shuffle();
        setVisible(true);
    }
    
    private void shuffle() {
        int n = SIZE * SIZE * 100;
        for (int i = 0; i < n; i++) {
            int random = (int)(Math.random() * 4);
            int newRow = emptyRow;
            int newCol = emptyCol;
            if (random == 0) newRow--;
            else if (random == 1) newRow++;
            else if (random == 2) newCol--;
            else newCol++;
            
            if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE) {
                buttons[emptyRow][emptyCol].setText(buttons[newRow][newCol].getText());
                buttons[newRow][newCol].setText("");
                puzzle[emptyRow][emptyCol] = puzzle[newRow][newCol];
                puzzle[newRow][newCol] = 0;
                emptyRow = newRow;
                emptyCol = newCol;
            }
        }
    }
    
    private void checkForWin() {
        int count = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (puzzle[i][j] != count && !(i == SIZE - 1 && j == SIZE - 1)) {
                    return;
                }
                count++;
            }
        }
        JOptionPane.showMessageDialog(this, "You win!");
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP && emptyRow < SIZE - 1) {
            buttons[emptyRow][emptyCol].setText(buttons[emptyRow + 1][emptyCol].getText());
            buttons[emptyRow + 1][emptyCol].setText("");
            puzzle[emptyRow][emptyCol] = puzzle[emptyRow + 1][emptyCol];
            puzzle[emptyRow + 1][emptyCol] = 0;
            emptyRow++;
        } else if (key == KeyEvent.VK_DOWN && emptyRow > 0) {
            buttons[emptyRow][emptyCol].setText(buttons[emptyRow - 1][emptyCol].getText());
            buttons[emptyRow - 1][emptyCol].setText("");
            puzzle[emptyRow][emptyCol] = puzzle[emptyRow - 1][emptyCol];
            puzzle[emptyRow - 1][emptyCol] = 0;
            emptyRow--;
        } else if (key == KeyEvent.VK_LEFT && emptyCol < SIZE - 1) {
            buttons[emptyRow][emptyCol].setText(buttons[emptyRow][emptyCol + 1].getText());
            buttons[emptyRow][emptyCol + 1].setText("");
            puzzle[emptyRow][emptyCol] = puzzle[emptyRow][emptyCol + 1];
            puzzle[emptyRow][emptyCol + 1] = 0;
            emptyCol++;
        } else if (key == KeyEvent.VK_RIGHT && emptyCol > 0) {
            buttons[emptyRow][emptyCol].setText(buttons[emptyRow][emptyCol - 1].getText());
            buttons[emptyRow][emptyCol - 1].setText("");
            puzzle[emptyRow][emptyCol] = puzzle[emptyRow][emptyCol - 1];
            puzzle[emptyRow][emptyCol - 1] = 0;
            emptyCol--;
        }
        checkForWin();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            String buttonText = clickedButton.getText();
            int row = 0, col = 0;
            
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (buttons[i][j] == clickedButton) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }
            
            if (row == emptyRow && col == emptyCol - 1) {
                buttons[emptyRow][emptyCol].setText(buttonText);
                buttons[row][col].setText("");
                puzzle[emptyRow][emptyCol] = puzzle[row][col];
                puzzle[row][col] = 0;
                emptyCol = col;
            } else if (row == emptyRow && col == emptyCol + 1) {
                buttons[emptyRow][emptyCol].setText(buttonText);
                buttons[row][col].setText("");
                puzzle[emptyRow][emptyCol] = puzzle[row][col];
                puzzle[row][col] = 0;
                emptyCol = col;
            } else if (col == emptyCol && row == emptyRow - 1) {
                buttons[emptyRow][emptyCol].setText(buttonText);
                buttons[row][col].setText("");
                puzzle[emptyRow][emptyCol] = puzzle[row][col];
                puzzle[row][col] = 0;
                emptyRow = row;
            } else if (col == emptyCol && row == emptyRow + 1) {
                buttons[emptyRow][emptyCol].setText(buttonText);
                buttons[row][col].setText("");
                puzzle[emptyRow][emptyCol] = puzzle[row][col];
                puzzle[row][col] = 0;
                emptyRow = row;
            }
            checkForWin();
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PuzzleGame());
    }
}