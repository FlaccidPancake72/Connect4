import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

//Please read the following class carefully! It represents a single chess board square and is what you'll be using
//to represent the chessboard.
@SuppressWarnings("serial")
public class Square extends JComponent {
	//a reference back to the board that stores this square.
    private Board b;
    
    //0: empty, 1: red, 2: black 
    private int color; 
        
    //the coordinates of the square.
    private int xNum;
    private int yNum;
    
    public Square(Board b, int color, int xNum, int yNum) {
        this.color = 0; 
        this.b = b;
        this.xNum = xNum;
        this.yNum = yNum;
        
        this.setBorder(BorderFactory.createEmptyBorder());
    }

    public void setColor(int color) { 
        this.color = color; 
    }

    public int getColor() { 
        return color; 
    }
    public int getXNum() {
        return this.xNum;
    }
    
    public int getYNum() {
        return this.yNum;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (this.color == 0) {
            g.setColor(new Color(255,255,255));
        } else if (this.color == 1) {
            g.setColor(new Color(255, 0, 0));
        } else { 
            g.setColor(new Color(0,0,0));
        }
        
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
    
    
}
