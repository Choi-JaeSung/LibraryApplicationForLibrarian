/**
 *  Display books panel class
 */

/**
 * @version 1.0.1
 * @author 2017315005 안시후, 2017315027 최재성, 2017315035 김선혁, 2017315053 후쿠미쓰 치아키
 */

package GUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Process.LibrarySystem;

public class MyDisplayBooksPanel extends JPanel
{
	public JTextArea text;
	JScrollPane sp;
	JLabel title;

	public MyDisplayBooksPanel(LibrarySystem library, boolean loan)
	{
		this.setLayout(null);
		this.setSize(700, 595);

		if (loan == true)
		{
			DisplayBooksAvailableForLoan(library);
		} else
		{
			DisplayBooksOnLoan(library);
		}

	}

	public void DisplayBooksAvailableForLoan(LibrarySystem library)
	{
		title = new JLabel("Books Available For Loan");
		title.setBounds(220, 13, 300, 50);
		title.setFont(new Font("malgun gothic", Font.BOLD, 20));
		this.add(title);

		text = new JTextArea();
		text.setEditable(false);
		library.displayBooksAvailableForLoan(this);

		sp = new JScrollPane(text);
		sp.setBounds(5, 70, 675, 480);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(sp);
	}

	public void DisplayBooksOnLoan(LibrarySystem library)
	{
		title = new JLabel("Books On Loan");
		title.setBounds(260, 13, 300, 50);
		title.setFont(new Font("malgun gothic", Font.BOLD, 20));
		this.add(title);

		text = new JTextArea();
		text.setEditable(false);
		library.displayBooksOnLoan(this);

		sp = new JScrollPane(text);
		sp.setBounds(5, 70, 675, 480);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(sp);
	}
}
