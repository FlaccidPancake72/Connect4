import javax.swing.*;      


/*A. grid layout --> 7 x 7 as squares, each square is a place u can put
	I. Top row to drop things in then it shows where it goes at the bottom
	II. Need isRed --> true if it is red, false then it's black 
	III. Want 3 things: top is where drop, middle is our 2d array, bottom is reset and win counter 
		i. COPY BOARD FROM CHESS
B. Rules
	I. Start as red
	II. Turns: red --> black
		i. need var to count what turn it is on 
	III. win condition: 
		i. four diagonal, vertical, horizontal
		iv. isWin function: 
			a. check this when you place it 
			b. what it does: 
				i. 3 if statements to check d, v, h
					I. d: i+ , j+ and i-, j- and the opp direction --> turns false immediately if it hits another color 
					II. and etc 
	IV. Legal moves: 
		i. literally verything BUT when column is filled
			i. can have is filled Boolean, turns true when someone puts it at the spot where i = total row 
				a. you know this bc when u click the drop at the top of the row ur i++
C. */


public class HelloWorldSwing {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
