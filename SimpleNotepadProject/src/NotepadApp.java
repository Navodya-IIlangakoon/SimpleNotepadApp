public class NotepadApp {
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            NotepadUI notepadUI = new NotepadUI();
            notepadUI.setVisible(true);
        });
    }
}
