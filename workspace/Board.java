import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
@SuppressWarnings("serial")
public class Board extends JPanel { 

	// Logical and graphical representations of board
	private final Square[][] board;
    private final int row = 6;
	private	final int col = 7;
	private final GameWindow g;


	public Board(GameWindow g) {
		this.g = g;
		board = new Square[row][col];
	
		setLayout(new GridLayout(6, 7, 0, 0));

		
		int count = 0;
        //TO DO on 4/9/2025 
		for (int r = 0; r < row; r++) {

			for (int c = 0; c < col; c++) {

                //    public Square(Board b, int color, int xNum, int yNum) {

				board[r][c] = new Square(this, 0, c, r);
				this.add(board[r][c]);
				// isWhite = !isWhite;
			}
			// isWhite = !isWhite;

		}



		this.setPreferredSize(new Dimension(525 , 450));
		this.setMaximumSize(new Dimension(525, 450));
		this.setMinimumSize(this.getPreferredSize());
		this.setSize(new Dimension(525, 450));

		// whiteTurn = true;

	}

    @Override
	public void paintComponent(Graphics g) {
		// super.paintComponent(g);

		for (int y = 0; y < row; y++) {
			for (int x = 0; x < col; x++) {
				Square sq = board[y][x];
				sq.paintComponent(g);
                sq.setBorder(BorderFactory.createLineBorder(Color.black));
			}
		}
    }

    // @Override
    // public void mouseClicked(MouseEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    // }

    // @Override
    // public void mousePressed(MouseEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    // }

    // @Override
    // public void mouseReleased(MouseEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    // }

    // @Override
    // public void mouseEntered(MouseEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    // }

    // @Override
    // public void mouseExited(MouseEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    // }
}