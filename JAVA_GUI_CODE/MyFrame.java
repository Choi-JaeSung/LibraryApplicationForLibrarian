package GUI;

/**
 * 
 */

import javax.swing.JFrame;

import Process.LibrarySystem;

public class MyFrame extends JFrame {

	public MyFrame() {
		this.setTitle("App for Librarian");
		this.setSize(400, 430);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		LibrarySystem ourLib = new LibrarySystem("Team 1");
		try{
			ourLib.loadFile();
		}catch(NullPointerException e){
		
		}
		this.add(new MyMainPanel(ourLib));

		this.setVisible(true);
	}
}
