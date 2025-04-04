import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;


//Warning* Mess with this file at your own peril. You do not need to modify anything in here other than the 
//messages that pop up (see below). Everything else should already work.
public class GameWindow {
    private JFrame gameWindow;    
    private Board board;
    
    public GameWindow(String redName, String blackName) {
        gameWindow = new JFrame("THE SIGMA Connect 4");
        gameWindow.setLocation(100, 100);
        gameWindow.setLayout(new BorderLayout(20,20));
        this.board = new Board(this);
        gameWindow.add(board, BorderLayout.CENTER);
        gameWindow.add(buttons(), BorderLayout.SOUTH);
        gameWindow.setMinimumSize(gameWindow.getPreferredSize());
        gameWindow.setSize(gameWindow.getPreferredSize());
        gameWindow.setResizable(false);
        gameWindow.pack();
        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
// Helper function to create data panel

    private JPanel buttons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3, 10, 0));
        
        final JButton quit = new JButton("Quit");
        
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
          });
        
        final JButton nGame = new JButton("New game");
        
        nGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
          });
        
        final JButton instr = new JButton("How to play");
        
        instr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(gameWindow,
                		
                		
                		
                		
                		// this is the only section you really need to modify (although you're certainly welcome to mess
                		//with the rest of the file, but do so at your own peril)
                        " <<<<<<<<<<<<<<<Your instructions go here>>>>>>>>>",
                        
                        
                        
                        
                        
                        
                        "How to play",
                        JOptionPane.PLAIN_MESSAGE);
            }
          });
        
        buttons.add(instr);
        buttons.add(nGame);
        buttons.add(quit);
        
        buttons.setPreferredSize(buttons.getMinimumSize());
        
        return buttons;
    }
    
    public void checkmateOccurred (boolean whiteWins) {
       
    }
}
