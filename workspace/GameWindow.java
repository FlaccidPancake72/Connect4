import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*; 
import java.net.*;
import java.util.ArrayList;


//Warning* Mess with this file at your own peril. You do not need to modify anything in here other than the 
//messages that pop up (see below). Everything else should already work.
public class GameWindow {
    private JFrame gameWindow;    
    private Board board;
    private final int WIDTH= 525;
    
    public static final int LISTENING_PORT = 9876;
    private static ArrayList<ConnectionHandler> connections= new ArrayList();      // For communication with the connecting program.
    
    public static void main(String [] args){
        new GameWindow("blarg", "blorg");

        int num = 0; 
        ServerSocket listener;  // Listens for incoming connections.
       
        /* Accept and process connections forever, or until some error occurs. */
        try {
            listener = new ServerSocket(LISTENING_PORT);
            System.out.println("Listening on port " + LISTENING_PORT);
            while (true) {
                Socket s = listener.accept();
                ConnectionHandler handler = new ConnectionHandler(s);
                handler.start();
                connections.add(handler);
            }
        }
        catch (Exception e) {
            System.out.println("Sorry, the server has shut down.");
            System.out.println("Error:  " + e);
            return;
        }
    }  // end main()
    /**
     *  Defines a thread that handles the connection with one
     *  client.
     */
    private static class ConnectionHandler extends Thread {
        Socket client;
        private ObjectOutputStream os;
        private ObjectInputStream is;
        
        ConnectionHandler(Socket socket) {
            client = socket;           
            try {
            //set up your streams, make sure this order is reversed on the client side!
                os = new ObjectOutputStream(socket.getOutputStream());
                is = new ObjectInputStream(socket.getInputStream());
                System.out.println("someone connected yapee");
                } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                }
        }
        
        //method to help us send information!
        public void send(String input) {
        try {
                os.writeObject(input);
                } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();                
                }
        }
        
        
        public void run() {
            while(client.isConnected()) {
            try {
                String red;
                if(isRed) {
                    red = "t"; 
                } else { 
                    red = "f";
                }
            String input = ;
            //your code to send messages goes here.
            if(input!= null) {
            for(ConnectionHandler handler: connections) {
            //make sure you don't try to access the handler from two different threads simultainously
            synchronized(handler) {
            handler.send(input);
            }
            }
            }
            }
            catch (Exception e){
                System.out.println("Error on connection " 
                        + ": " + e);
            }
            }
            connections.remove(client);
            
        }
    }

    public GameWindow(String redName, String blackName) {
        gameWindow = new JFrame("THE SIGMA Connect 4");
        gameWindow.setLocation(100, 100);
        gameWindow.setLayout(new BorderLayout(20,20));
        this.board = new Board(this);
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(null);
        boardPanel.setPreferredSize(board.getPreferredSize());
        boardPanel.add(board);
        gameWindow.add(boardPanel, BorderLayout.CENTER);

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

        /* 
         *         this.board = new Board(this);
            JPanel boardPanel = new JPanel();
        boardPanel.setLayout(null);
        boardPanel.setPreferredSize(board.getPreferredSize());
        boardPanel.add(board);
        gameWindow.add(boardPanel, BorderLayout.CENTER);
         */

         JPanel bottomPanel = new JPanel(); 
         bottomPanel.setSize(new Dimension(100,50)); 
         bottomPanel.add(quit); 
         bottomPanel.add(nGame); 
    
         gameWindow.add(bottomPanel, BorderLayout.SOUTH); 

         JPanel topPanel = new JPanel(); 
         topPanel.setSize(new Dimension(300,50)); 
         JPanel buttons = buttons();
       
         buttons.setPreferredSize(new Dimension(WIDTH, 40));
         topPanel.add(buttons);
         topPanel.setVisible(true); 

         gameWindow.add(topPanel, BorderLayout.NORTH); 

        //gameWindow.add(buttons(), BorderLayout.NORTH);
        gameWindow.setMinimumSize(gameWindow.getPreferredSize());
        gameWindow.setResizable(false);
        gameWindow.pack();
        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private static int xLoc = 0; 
    private static boolean isRed = true; 
    // Helper function to create data panel
        private JPanel buttons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3, WIDTH/7, 0));

         final JButton d1 = new JButton("Drop here");
         final JButton d2 = new JButton("Drop here");
         final JButton d3 = new JButton("Drop here");
         final JButton d4 = new JButton("Drop here");
         final JButton d5 = new JButton("Drop here");
         final JButton d6 = new JButton("Drop here");
         final JButton d7 = new JButton("Drop here");

        buttons.add(d1); 
        buttons.add(d2); 
        buttons.add(d3); 
        buttons.add(d4); 
        buttons.add(d5); 
        buttons.add(d6); 
        buttons.add(d7); 
        
        buttons.setPreferredSize(buttons.getMinimumSize());

        d1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) { 
                xLoc = 1; 
                isRed = !isRed; 
                System.out.println("button 1 clicked");
			}
		}); 

        d2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) { 
                xLoc = 2; 
                isRed = !isRed;
                System.out.println("button 2 clicked"); 
			}
		}); 

        d3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) { 
                xLoc = 3;
                isRed = !isRed; 
                System.out.println("button 3 clicked");
			}
		}); 
        
        d4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) { 
                xLoc = 4; 
                isRed = !isRed; 
                System.out.println("button 4 clicked");
			}
		}); 
        
        d5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) { 
                xLoc = 5; 
                isRed = !isRed; 
                System.out.println("button 5 clicked");
			}
		}); 

        d6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) { 
                xLoc = 6; 
                isRed = !isRed; 
                System.out.println("button 6 clicked");
			}
		}); 

        d7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) { 
                xLoc = 7; 
                isRed = !isRed; 
                System.out.println("button 7 clicked");
			}
		}); 

        System.out.println(xLoc);
        System.out.println(isRed);


        
        return buttons;
    }
}
