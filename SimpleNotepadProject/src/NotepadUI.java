import javax.swing.*;
import java.awt.*;

public class NotepadUI extends JFrame {
    public JTextArea textArea;
    public JFileChooser fileChooser;

    // Menu items
    public JMenuItem openItem, saveItem, exitItem;
    public JMenuItem cutItem, copyItem, pasteItem;
    public JMenuItem aboutItem;
    public JMenuItem fontItem, colorItem;

    private NotepadActions actions;

    public NotepadUI() {
        setTitle("Simple Notepad");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Text area with scroll pane
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        fileChooser = new JFileChooser();

        // Build menus
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Edit menu
        JMenu editMenu = new JMenu("Edit");
        cutItem = new JMenuItem("Cut");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Help menu
        JMenu helpMenu = new JMenu("Help");
        aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        // Format menu (optional)
        JMenu formatMenu = new JMenu("Format");
        fontItem = new JMenuItem("Choose Font");
        colorItem = new JMenuItem("Choose Color");
        formatMenu.add(fontItem);
        formatMenu.add(colorItem);

        // Add all menus to bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        menuBar.add(formatMenu);
        setJMenuBar(menuBar);

        // Hook up actions
        actions = new NotepadActions(this);
        addActionListeners();
    }

    private void addActionListeners() {
        openItem.addActionListener(actions);
        saveItem.addActionListener(actions);
        exitItem.addActionListener(actions);

        cutItem.addActionListener(actions);
        copyItem.addActionListener(actions);
        pasteItem.addActionListener(actions);

        aboutItem.addActionListener(actions);
        fontItem.addActionListener(actions);
        colorItem.addActionListener(actions);
    }
}
