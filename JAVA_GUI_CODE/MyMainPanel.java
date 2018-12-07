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

public class MyMainPanel extends JPanel
{
	JFrame newFrame;

	public MyMainPanel(LibrarySystem ourLib)
	{

		this.setSize(400, 430);

		JLabel mainLabel = new JLabel("Welcom to " + ourLib.getName());
		Font myFont = new Font("malgun gotic", Font.BOLD, 20);
		mainLabel.setFont(myFont);

		this.add(mainLabel);

		JButton registerOneBorrowerBtn = new JButton("registerOneBorrower");
		registerOneBorrowerBtn.setPreferredSize(new Dimension(220, 50));
		JButton addOneBookBtn = new JButton("addOneBook");
		addOneBookBtn.setPreferredSize(new Dimension(220, 50));
		JButton displayBooksAvailableForLoanBtn = new JButton("displayBooksAvailableForLoan");
		displayBooksAvailableForLoanBtn.setPreferredSize(new Dimension(220, 50));
		JButton displayBooksOnLoanBtn = new JButton("displayBooksOnLoan");
		displayBooksOnLoanBtn.setPreferredSize(new Dimension(220, 50));
		JButton lendOneBookBtn = new JButton("lendOneBook");
		lendOneBookBtn.setPreferredSize(new Dimension(220, 50));
		JButton returnOneBookBtn = new JButton("returnOneBook");
		returnOneBookBtn.setPreferredSize(new Dimension(220, 50));

		this.add(registerOneBorrowerBtn);
		this.add(addOneBookBtn);
		this.add(displayBooksAvailableForLoanBtn);
		this.add(displayBooksOnLoanBtn);
		this.add(lendOneBookBtn);
		this.add(returnOneBookBtn);

		registerOneBorrowerBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				newFrame = new JFrame("registerOneBorrower");
				newFrame.setSize(400, 220);
				newFrame.add(new MyRegisterOneBorrowerPanel(newFrame, ourLib));

				newFrame.setVisible(true);
			}
		});

		addOneBookBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				newFrame = new JFrame("addOneBook");
				newFrame.setSize(400, 430);
				newFrame.add(new MyAddOneBookPanel(newFrame, ourLib));

				newFrame.setVisible(true);
			}
		});

		displayBooksAvailableForLoanBtn.addActionListener(new Display(ourLib, true));
		displayBooksOnLoanBtn.addActionListener(new Display(ourLib, false));

		lendOneBookBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				newFrame = new JFrame("lendOneBook");
				newFrame.setSize(400, 430);
				newFrame.add(new MyLendOneBookPanel(newFrame, ourLib));

				newFrame.setVisible(true);
			}
		});

		returnOneBookBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				newFrame = new JFrame("returnOneBook");
				newFrame.setSize(400, 220);
				newFrame.add(new MyReturnOneBookPanel(newFrame, ourLib));

				newFrame.setVisible(true);
			}
		});

	}
}
