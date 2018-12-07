import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * 
 * @Author ()
 * @Version ()
 */
public class Display implements ActionListener {
	LibrarySystem library;
	boolean loan;

	public Display(LibrarySystem library, boolean loan) {
		this.loan = loan;
		this.library = library;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (loan == true) {
			JFrame frame = new JFrame();
			frame.setTitle("DisplayBooksAvailableForLoanBtn");
			frame.setSize(700, 595);
			DisplayBooks display = new DisplayBooks(library, true);
			frame.add(display);
			frame.setVisible(true);
		} else {
			JFrame frame = new JFrame();
			frame.setTitle("DisplayBooksOnLoanBtn");
			frame.setSize(700, 595);
			DisplayBooks display = new DisplayBooks(library, false);
			frame.add(display);
			frame.setVisible(true);
		}
	}
}
