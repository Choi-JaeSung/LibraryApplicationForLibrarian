/**
 * My frame class
 */

/**
 * @version 1.0.1
 * @author 2017315005 안시후, 201731502 최재성, 2017315035 김선혁, 2017315053 후쿠미쓰 치아키
 */

package GUI;

import javax.swing.JFrame;

import Process.LibrarySystem;

public class MyFrame extends JFrame
{

	public MyFrame()
	{
		this.setTitle("App for Librarian");
		this.setSize(400, 430);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		LibrarySystem ourLib = new LibrarySystem("Team 1");
		try
		{
			ourLib.loadFile();
		} catch (NullPointerException e)
		{

		}
		this.add(new MyMainPanel(ourLib));

		this.setVisible(true);
	}
}
