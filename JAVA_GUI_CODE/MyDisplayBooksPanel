package GUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Process.LibrarySystem;

/**
 * 
 * @Author ()
 * @Version ()
 */
public class MyDisplayBooksPanel extends JPanel {
	public JTextArea text;
	JScrollPane sp;
	JLabel title;

	public MyDisplayBooksPanel(LibrarySystem library, boolean loan) {
		this.setLayout(null);
		this.setSize(700, 595);

		if (loan == true) {
			DisplayBooksAvailableForLoan(library);
		} else {
			DisplayBooksOnLoan(library);
		}

	}

	public void DisplayBooksAvailableForLoan(LibrarySystem library) {
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

	public void DisplayBooksOnLoan(LibrarySystem library) {
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
