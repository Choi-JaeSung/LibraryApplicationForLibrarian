package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Process.LibrarySystem;

public class Display implements ActionListener {
	LibrarySystem library;
	boolean loan;

	public Display(LibrarySystem library, boolean loan) {
		// TODO Auto-generated constructor stub
		this.library = library;
		this.loan = loan;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (loan == true) {
			JFrame frame = new JFrame();
			frame.setTitle("DisplayBooksAvailableForLoanBtn");
			frame.setSize(700, 595);
			MyDisplayBooksPanel display = new MyDisplayBooksPanel(library, true);
			frame.add(display);
			frame.setVisible(true);
		} else {
			JFrame frame = new JFrame();
			frame.setTitle("DisplayBooksOnLoanBtn");
			frame.setSize(700, 595);
			MyDisplayBooksPanel display = new MyDisplayBooksPanel(library, false);
			frame.add(display);
			frame.setVisible(true);
		}
	}

}
