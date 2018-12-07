/**
 * Register one Borrower panel class
 */

/**
 * @version 1.0.2
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

public class MyRegisterOneBorrowerPanel extends JPanel {
	public MyRegisterOneBorrowerPanel(JFrame newFrame, LibrarySystem ourLib) {
		JLabel label,result_label;
		JTextField input;
		JButton button;
		this.setLayout(null);

		label = new JLabel("Please fill in the blanks");
		label.setBounds(0, 0, 400, 50);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.CENTER);
		Font myFont = new Font("malgungothic", Font.BOLD, 20);

		label.setFont(myFont);
		input = new JTextField("", 10);
		input.setBounds(50, 50, 300, 30);
		button = new JButton("register");
		button.setBounds(150, 90, 100, 40);
		result_label = new JLabel("");
		result_label.setBounds(0, 130, 400, 50);
		result_label.setHorizontalAlignment(SwingConstants.CENTER);
		result_label.setVerticalTextPosition(SwingConstants.CENTER);
		this.add(label);
		this.add(input);
		this.add(button);
		this.add(result_label);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(input.getText().equals("")){
					result_label.setText("The name column is empty.");
				}
				else{
					ourLib.registerOneBorrower(input.getText(), result_label);
					ourLib.saveFile();
				}
			}
		});
	}
}
