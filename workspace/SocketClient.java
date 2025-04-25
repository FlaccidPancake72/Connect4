import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//client
public class SocketClient {
/*
* Modify this example so that it opens a dialogue window using java swing, 
* takes in a user message and sends it
* to the server. The server should output the message back to all connected clients
* (you should see your own message pop up in your client as well when you send it!).
*  We will build on this project in the future to make a full fledged server based game,
*  so make sure you can read your code later! Use good programming practices.
*  ****HINT**** you may wish to have a thread be in charge of sending information 
*  and another thread in charge of receiving information.
*/
public static void SocketClient() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
	//get the localhost IP address, if server is running on some other IP, you need to use that
	InetAddress host = InetAddress.getLocalHost();
	final Socket socket = new Socket(host.getHostName(), 9876);
	System.out.println("client connected");
	final ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

	// write to socket using ObjectOutputStream
	ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

	Thread thread = new Thread() {
		public void run() {
			while (true) {
				try {
					String input = (String) ois.readObject(); //t0
					System.out.println("message received");
					//System.out.println("received " + input);
					if (input != null) {

						//the y value for each row 
						int[] rows = new int[6]
						for(int i = 0; i < rows.length; i++)
						{
							rows[i] = 0;
						}

						String str = input.substring(1);
						int strNum = (int) str;
							
						r = rows[strNum];
						r++;
						rows[strNum] = r;

						
						if(input.substring(0,1).equals("t")) {
							//this stuff is red.... 
							this.Board[strNum][r].setColor("red"); 
					
						} else { 
							this.Board[strNum][r].setColor("black");
							//is black 
						}
						//oos.writeObject(input);
						//message.setText(message.getText() + "\n" + input);
						//frame.repaint();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

	thread.start();
	/*input.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = input.getText();
			try {
				oos.writeObject(text);
				System.out.println("sent "+text);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			input.setText(""); 
		}
	});*/
	
	// closes the window when you exit.
	/*frame.addWindowListener((WindowListener) new WindowAdapter()
	{
	   public void windowClosing(WindowEvent e)
	   {
		  if(socket.isConnected())
			try {
				oos.writeObject("exit");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  try {
			   Thread.sleep(1000); // Time for DisconnectMessage to actually be sent.
		   }
		   catch (InterruptedException e1) {
		   } 
		 //close resources
		 System.exit(0); 
	   }
	});*/
   // System.out.println((String)ois.readObject());
	
}
}