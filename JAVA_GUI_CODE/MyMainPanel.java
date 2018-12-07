/**
 * My main panel class
 */

/**
 * @version 1.0.2
 * @author 2017315005 안시후, 2017315027 최재성, 2017315035 김선혁, 2017315053 후쿠미쓰 치아키
 */

package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Process.LibrarySystem;

public class MyMainPanel extends JPanel {
	JFrame newFrame;

	public MyMainPanel(LibrarySystem ourLib) {

		this.setSize(400, 700);

		JLabel mainLabel = new JLabel("Welcom to " + ourLib.getName());
		Font myFont = new Font("malgun gotic", Font.BOLD, 20);
		mainLabel.setFont(myFont);

		this.add(mainLabel);

		JButton registerOneBorrowerBtn = new JButton("registerOneBorrower");
		registerOneBorrowerBtn.setPreferredSize(new Dimension(220, 50));
		JButton deleteOneBorrowerBtn = new JButton("deleteOneBorrower");
		deleteOneBorrowerBtn.setPreferredSize(new Dimension(220, 50));
		JButton addOneBookBtn = new JButton("addOneBook");
		addOneBookBtn.setPreferredSize(new Dimension(220, 50));
		JButton deleteOneBookBtn = new JButton("deleteOneBook");
		deleteOneBookBtn.setPreferredSize(new Dimension(220, 50));
		JButton searchBorrower = new JButton("searchBorrower");
		searchBorrower.setPreferredSize(new Dimension(220, 50));
		JButton searchBooks = new JButton("searchBooks");
		searchBooks.setPreferredSize(new Dimension(220, 50));
		JButton displayBooksAvailableForLoanBtn = new JButton("displayBooksAvailableForLoan");
		displayBooksAvailableForLoanBtn.setPreferredSize(new Dimension(220, 50));
		JButton displayBooksOnLoanBtn = new JButton("displayBooksOnLoan");
		displayBooksOnLoanBtn.setPreferredSize(new Dimension(220, 50));
		JButton lendOneBookBtn = new JButton("lendOneBook");
		lendOneBookBtn.setPreferredSize(new Dimension(220, 50));
		JButton returnOneBookBtn = new JButton("returnOneBook");
		returnOneBookBtn.setPreferredSize(new Dimension(220, 50));

		this.add(registerOneBorrowerBtn);
		this.add(deleteOneBorrowerBtn);
		this.add(addOneBookBtn);
		this.add(deleteOneBookBtn);
		this.add(searchBorrower);
		this.add(searchBooks);
		this.add(displayBooksAvailableForLoanBtn);
		this.add(displayBooksOnLoanBtn);
		this.add(lendOneBookBtn);
		this.add(returnOneBookBtn);

		registerOneBorrowerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newFrame = new JFrame("registerOneBorrower");
				newFrame.setSize(400, 220);
				newFrame.add(new MyRegisterOneBorrowerPanel(newFrame, ourLib));

				newFrame.setVisible(true);
			}
		});
		deleteOneBorrowerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newFrame = new JFrame("registerOneBorrower");
				newFrame.setSize(400, 220);
				newFrame.add(new MyDeleteBorrowerInformationPanel(ourLib));

				newFrame.setVisible(true);
				
			}
		});
		addOneBookBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newFrame = new JFrame("addOneBook");
				newFrame.setSize(400, 430);
				newFrame.add(new MyAddOneBookPanel(newFrame, ourLib));

				newFrame.setVisible(true);
			}
		});
		deleteOneBookBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newFrame = new JFrame("deleteOneBook");
				newFrame.setSize(400, 220);
				newFrame.add(new MyDeleteOneBookPanel(ourLib));

				newFrame.setVisible(true);
				
			}
		});
		displayBooksAvailableForLoanBtn.addActionListener(new Display(ourLib, true));
		displayBooksOnLoanBtn.addActionListener(new Display(ourLib, false));
		searchBorrower.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.setTitle("SearchBorrower");
				frame.setSize(700, 595);
				SearchMain display = new SearchMain(ourLib, true);
				frame.add(display);
				frame.setVisible(true);
			}
		});
		searchBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.setTitle("SerachBooks");
				frame.setSize(700, 595);
				SearchMain display = new SearchMain(ourLib, false);
				frame.add(display);
				frame.setVisible(true);
			}
		});
		lendOneBookBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newFrame = new JFrame("lendOneBook");
				newFrame.setSize(400, 430);
				newFrame.add(new MyLendOneBookPanel(newFrame, ourLib));

				newFrame.setVisible(true);
			}
		});

		returnOneBookBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newFrame = new JFrame("returnOneBook");
				newFrame.setSize(400, 220);
				newFrame.add(new MyReturnOneBookPanel(newFrame, ourLib));

				newFrame.setVisible(true);
			}
		});

	}
}
