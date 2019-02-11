/*
 * This class encapsulates the main frame of the BooleanTableView
 */

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    private static final int SQUARE_SIZE = 20;  // size of a square in the table
    private Square[][] cells;

    public MainFrame(int maxCols, int maxRows) {
        super("Table Viewer");
        setLayout(new GridBagLayout());
        setSize(SQUARE_SIZE * (maxCols + 2), SQUARE_SIZE * (maxRows + 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createButtons(maxCols, maxRows);
        setVisible(true);
    }

    /* Initializes a the MainFrame with the values of a table of booleans
     * colxrows.
     * The table must be complete in the sense that every column must have the
     * same ammount of rows and match the reserved amount. */
    public void initialize(boolean[][] values) {
        for (int col=0; col < values.length; col++) {
            for (int row=0; row < values[col].length; row++) {
                cells[col][row].setValue(values[col][row]);
            }
        }
    }


    /* sets the value for the (col, row) element
     * It assumes the element exists
     */
    public void setValue(int col, int row, boolean value) {
        cells[col][row].setValue(value);
    }

    /* Unsets all the positions */
    public void clear() {
        for (int col=0; col < cells.length; col++) {
            for (int row=0; row < cells[col].length; row++) {
                cells[col][row].setValue(false);
            }
        }
    }

    /* closes this frame */
    public void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }


    // Fills the frame with buttons
    private void createButtons(int maxCols, int maxRows) {
        GridBagConstraints constraints = new GridBagConstraints();
        Dimension dimension = new Dimension(SQUARE_SIZE, SQUARE_SIZE);
        this.cells = new Square[maxCols][maxRows];
        for (int col = 0; col < maxCols; col++) {
            for (int row = 0; row < maxRows; row++) {
                Square current = new Square(dimension, col, row);
                cells[col][row] = current;
                constraints.gridx = col;
                constraints.gridy = row;
                add(current, constraints);
            }
        }
    }




}
