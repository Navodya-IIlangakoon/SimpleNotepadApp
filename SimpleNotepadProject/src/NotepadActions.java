import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotepadActions implements ActionListener {

    private NotepadUI ui;

    public NotepadActions(NotepadUI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // File operations
        if (source == ui.openItem) {
            int option = ui.fileChooser.showOpenDialog(ui);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = ui.fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    ui.textArea.read(reader, null);
                } catch (IOException ex) {
                    showError("Error opening file.");
                }
            }

        } else if (source == ui.saveItem) {
            int option = ui.fileChooser.showSaveDialog(ui);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = ui.fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    ui.textArea.write(writer);
                } catch (IOException ex) {
                    showError("Error saving file.");
                }
            }

        } else if (source == ui.exitItem) {
            System.exit(0);

        // Edit actions
        } else if (source == ui.cutItem) {
            ui.textArea.cut();

        } else if (source == ui.copyItem) {
            ui.textArea.copy();

        } else if (source == ui.pasteItem) {
            ui.textArea.paste();

        // About dialog
        } else if (source == ui.aboutItem) {
            JOptionPane.showMessageDialog(ui,
                "Simple Notepad\nCreated by: Your Name\nID: 123456",
                "About",
                JOptionPane.INFORMATION_MESSAGE);

        // Font selection
        } else if (source == ui.fontItem) {
            // Set to a default font for simplicity
            Font newFont = new Font("Serif", Font.PLAIN, 18);
            ui.textArea.setFont(newFont);

        // Color chooser
        } else if (source == ui.colorItem) {
            Color color = JColorChooser.showDialog(ui, "Choose Text Color", Color.BLACK);
            if (color != null) {
                ui.textArea.setForeground(color);
            }
        }
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(ui, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
