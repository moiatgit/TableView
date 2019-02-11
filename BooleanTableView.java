/*
 * This class implements a viewer of a bidimensional matrix
 */
import javax.swing.SwingUtilities;

public class BooleanTableView {
    private MainFrame mainFrame;
    private final int maxRows;
    private final int maxCols;

    /* Creates a BooleanTableView of maxColumns x maxRows, with all the values
     * unset.
     * The resulting table view should represent at least a 1x1 table
     */
    public BooleanTableView(int maxColumns, int maxRows) {
        if (maxColumns < 1 || maxRows < 1) {
            throw new RuntimeException("Max columns and rows must be at least 1");
        }
        this.maxCols = maxColumns;
        this.maxRows = maxRows;
        createFrame();
    }

    /* Creates a BooleanTableView with the values defined in the values table of
     * booleans (col x row).
     * Each column of values must have the same length.
     * The table must be, at least 1x1
     */
    public BooleanTableView(boolean[][] values) {
        // check consistency
        int cols = values.length;
        if (cols < 1) {
            throw new RuntimeException("Minimum number of columns expected: 1");
        }
        int rows = values[0].length;
        if (rows < 1) {
            throw new RuntimeException("Rows must be at least 1");
        }
        for (int col=1; col < values.length; col++) {
            if (rows != values[col].length) {
                throw new RuntimeException("All rows must have the same length");
            }
        }

        // create and initialize the frame
        this.maxCols = cols;
        this.maxRows = rows;
        createFrame();
        setValues(values);
    }

    // launches the frame in its own thread
    private void createFrame() {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                mainFrame = new MainFrame(maxCols, maxRows);
            }
        });
    }

    // runs runnable on the Event Dispatcher Thread and waits until completion
    private void runOnEDT(Runnable runnable) {
        SwingUtilities.invokeLater(runnable);
    }

    /* Sets the value of the (column, row) position */
    public void setValue(int column, int row, boolean value) {
        if (column < 0 || column > maxCols) {
            new RuntimeException("Column value " + column + " is out of range");
        }
        if (row < 0 || row > maxRows) {
            new RuntimeException("Row value " + row + " is out of range");
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainFrame.setValue(column, row, value);
            }
        });
    }

    /* Sets the values defined in the values table of
     * booleans (col x row).
     * Each column of values must have the same length.
     * The table must be, at least 1x1
     */
    public void setValues(boolean[][] values) {
        // check consistency
        if (values.length != this.maxCols) {
            throw new RuntimeException("Number of columns expected: " + this.maxCols);
        }
        for (int col=1; col < values.length; col++) {
            if (this.maxRows != values[col].length) {
                throw new RuntimeException("All rows must have the same length. Expected " + this.maxRows);
            }
        }
        // change frame values
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                mainFrame.initialize(values);
            }
        });
    }


    /* Unsets all the positions */
    public void clear() {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                mainFrame.clear();
            }
        });
    }

    /* closes the view. Once closed, the view cannot be reopened */
    public void close() {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                mainFrame.close();
            }
        });
    }

    /* Waits the required milliseconds */
    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

}
