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
    
    public static void main(String [] args){
        new GameWindow("blarg", "blorg");
    }


    public GameWindow(String redName, String blackName) {
        gameWindow = new JFrame("THE SIGMA Connect 4");
        gameWindow.setLocation(100, 100);
        gameWindow.setLayout(new BorderLayout(20,20));
        this.board = new Board();
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
                int n = JOptionPane.showConfirmDialog(
                        gameWindow,
                        "Are you sure you want to quit?",
                        "Confirm quit", JOptionPane.YES_NO_OPTION);
                
                if (n == JOptionPane.YES_OPTION) {
                    //if (timer != null) timer.stop();
                    gameWindow.dispose();
                }
            }
          });
        
        final JButton nGame = new JButton("New game");
        
        nGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(
                        gameWindow,
                        "Are you sure you want to begin a new game?",
                        "Confirm new game", JOptionPane.YES_NO_OPTION);
                
                if (n == JOptionPane.YES_OPTION) {
                    //SwingUtilities.invokeLater(new StartMenu());
                    gameWindow.dispose();
                }
            }
        }); 
          
        
        buttons.add(nGame);
        buttons.add(quit);
        
        buttons.setPreferredSize(buttons.getMinimumSize());
        
        return buttons;
    }
    
    // public void checkmateOccurred (boolean whiteWins) {
       
    // }
}
