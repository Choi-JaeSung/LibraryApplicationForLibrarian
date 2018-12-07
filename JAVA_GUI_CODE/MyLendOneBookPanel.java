/**
 * Lend one book panel class
 */

/**
 * @version 1.0.1
 * @author 2017315005 안시후, 2017315027 최재성, 2017315035 김선혁, 2017315053 후쿠미쓰 치아키
 */

package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Process.LibrarySystem;

public class MyLendOneBookPanel extends JPanel
{
	public JLabel result_label;

	public MyLendOneBookPanel(JFrame newFrame, LibrarySystem ourLib)
	{
		JLabel mainLabel, name, catalogNumber;
		JTextField nameT, catalogNumberT, cataNumT;
		JButton button;
		this.setLayout(null);
		Font myFont = new Font("malgungothic", Font.BOLD, 20);

		mainLabel = new JLabel("Please fill in the blanks");
		mainLabel.setBounds(0, 0, 400, 50);
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setVerticalTextPosition(SwingConstants.CENTER);
		mainLabel.setFont(myFont);

		name = new JLabel("Borrowers Name");
		name.setBounds(0, 60, 400, 30);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setVerticalTextPosition(SwingConstants.CENTER);
		myFont = new Font("malgungothic", Font.BOLD, 15);
		name.setFont(myFont);
		nameT = new JTextField("", 15);
		nameT.setBounds(100, 100, 200, 30);

		catalogNumber = new JLabel("Books CatalougNumber");
		catalogNumber.setBounds(0, 140, 400, 30);
		catalogNumber.setHorizontalAlignment(SwingConstants.CENTER);
		catalogNumber.setVerticalTextPosition(SwingConstants.CENTER);
		catalogNumber.setFont(myFont);

		catalogNumberT = new JTextField("", 15);
		catalogNumberT.setBounds(100, 180, 200, 30);
		button = new JButton("lend");
		button.setBounds(150, 230, 100, 40);

		result_label = new JLabel("");
		result_label.setBounds(0, 300, 400, 50);
		result_label.setHorizontalAlignment(SwingConstants.CENTER);
		result_label.setVerticalTextPosition(SwingConstants.CENTER);

		this.add(mainLabel);
		this.add(name);
		this.add(nameT);
		this.add(catalogNumber);
		this.add(catalogNumberT);

		this.add(button);
		this.add(result_label);

		button.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				try
				{
					ourLib.lendOneBook(nameT.getText(), Integer.parseInt(catalogNumberT.getText()), result_label);
				} catch (NumberFormatException ex)
				{
					result_label.setText("Please check the information you've entered");
				}
			}
		});

	}

}
