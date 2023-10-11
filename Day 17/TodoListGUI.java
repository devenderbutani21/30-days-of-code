import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class TodoListGUI extends JFrame {
    private final DefaultListModel<String> todoListModel = new DefaultListModel<>();
    private final JList<String> todoList = new JList<>(todoListModel);
    private final JTextField taskInput = new JTextField(20);

    public TodoListGUI() {
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create components
        JScrollPane scrollPane = new JScrollPane(todoList);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        // Load tasks from a file if it exists
        loadTasksFromFile();

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        // Add task
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText().trim();
                if (!task.isEmpty()) {
                    todoListModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        // Remove selected task
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    todoListModel.remove(selectedIndex);
                }
            }
        });

        // Save tasks to a file
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTasksToFile();
            }
        });

        // Load tasks from a file
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadTasksFromFile();
            }
        });
    }

    private void saveTasksToFile() {
        try (PrintWriter writer = new PrintWriter("todolist.txt")) {
            for (int i = 0; i < todoListModel.getSize(); i++) {
                writer.println(todoListModel.getElementAt(i));
            }
            System.out.println("Tasks saved to file.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadTasksFromFile() {
        todoListModel.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("todolist.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                todoListModel.addElement(line);
            }
            System.out.println("Tasks loaded from file.");
        } catch (IOException e) {
            System.out.println("No existing task file found. Starting with an empty list.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TodoListGUI().setVisible(true);
            }
        });
    }
}
