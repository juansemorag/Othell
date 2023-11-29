package presentacion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OthelloBoardPanel extends JPanel {

    private JButton[][] cells;
    private int[][] board;
    private static final Color DARK_GREEN = new Color(0, 128, 0); // RGB para verde oscuro
    private static final Color GRID_COLOR = Color.BLACK;
    private static final ImageIcon BLACK_PIECE_ICON = new ImageIcon("imgnegra.png");
    private static final ImageIcon WHITE_PIECE_ICON = new ImageIcon("imgblanca.png");

    public OthelloBoardPanel() {
        setLayout(new GridLayout(8, 8));
        initializeBoard();
        initializeCells();
    }

    private void initializeBoard() {
        board = new int[8][8];
        // Inicializar el tablero con fichas iniciales
        board[3][3] = board[4][4] = 1; // Fichas negras
        board[3][4] = board[4][3] = -1; // Fichas blancas
    }

    private void initializeCells() {
        cells = new JButton[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                cells[row][col] = new JButton();
                cells[row][col].setBackground(DARK_GREEN);
                cells[row][col].setBorder(new LineBorder(GRID_COLOR, 2)); // 2 es el grosor del borde
                cells[row][col].addActionListener(new CellClickListener(row, col));
                add(cells[row][col]);
                updateCell(row, col);
            }
        }
    }

    private void updateCell(int row, int col) {
        if (board[row][col] == 1) {
            cells[row][col].setIcon(BLACK_PIECE_ICON);
        } else if (board[row][col] == -1) {
            cells[row][col].setIcon(WHITE_PIECE_ICON);
        } else {
            cells[row][col].setIcon(null);
        }
    }

    private class CellClickListener implements ActionListener {
        private int row;
        private int col;

        public CellClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            // Realizar acciones cuando se hace clic en una celda
            // (por ejemplo, cambiar el color)
            if (board[row][col] == 0) {
                // Realizar acciones de Othello, como cambiar el color y actualizar el tablero
                // ...

                // Luego, actualizar la apariencia de la celda
                updateCell(row, col);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Othello");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            OthelloBoardPanel boardPanel = new OthelloBoardPanel();
            frame.getContentPane().add(boardPanel);

            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }
}
