/*
 * Implements a Square for the table
 */
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Dimension;
import java.awt.Color;

public class Square extends JButton{

    private static final Color selectedColor = Color.RED;
    private static final Color unselectedColor = Color.WHITE;
    private final int col, row;
    private boolean value;

    public Square(Dimension dimension, int col, int row){
        this.col = col;
        this.row = row;
        setPreferredSize(dimension);
        setBackground(unselectedColor);
        setToolTipText(String.format("(%s, %s)", col, row));
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    public void setValue(boolean value) {
        this.value = value;
        setBackground(value ? selectedColor: unselectedColor);
    }

}
