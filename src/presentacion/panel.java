package presentacion;

import javax.swing.*;

public class panel extends JFrame {

    public panel() {
        setTitle("Othello");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        OthelloBoardPanel boardPanel = new OthelloBoardPanel();
        getContentPane().add(boardPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new panel();
        });
    }
}
