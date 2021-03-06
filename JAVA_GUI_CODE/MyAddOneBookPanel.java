/**
 * Add one book panel class
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

public class MyAddOneBookPanel extends JPanel {
	public MyAddOneBookPanel(JFrame newFrame, LibrarySystem ourLib) {
		JLabel mainLabel, title, author, result_label;
		JTextField titleT, authorT;
		JButton button;
		this.setLayout(null);
		Font myFont = new Font("malgungothic", Font.BOLD, 20);
		
		mainLabel = new JLabel("Please write borrowers Name");
		mainLabel.setBounds(0, 0, 400, 50);
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setVerticalTextPosition(SwingConstants.CENTER);
		mainLabel.setFont(myFont);

		title = new JLabel("Title");
		title.setBounds(0,60,400,30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalTextPosition(SwingConstants.CENTER);
		myFont = new Font("malgungothic", Font.BOLD, 15);
		title.setFont(myFont);
		titleT = new JTextField("", 15);
		titleT.setBounds(100, 100, 200, 30);
		
		author = new JLabel("Author");
		author.setBounds(0,140,400,30);
		author.setHorizontalAlignment(SwingConstants.CENTER);
		author.setVerticalTextPosition(SwingConstants.CENTER);
		author.setFont(myFont);
		
		authorT = new JTextField("", 15);
		authorT.setBounds(100,180,200,30);
		button = new JButton("register");
		button.setBounds(150, 230, 100, 40);
		
		result_label = new JLabel("");
		result_label.setBounds(0, 300, 400, 50);
		result_label.setHorizontalAlignment(SwingConstants.CENTER);
		result_label.setVerticalTextPosition(SwingConstants.CENTER);
		
		this.add(mainLabel);
		this.add(title);
		this.add(titleT);
		this.add(author);
		this.add(authorT);

		this.add(button);
		this.add(result_label);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleT.getText().equals("") && authorT.getText().equals("")){
					result_label.setText("The title and author column are empty");
				}
				else if(authorT.getText().equals("")){
					result_label.setText("The author column is empty.");
				}
				else if(titleT.getText().equals("")){
					result_label.setText("The title column is empty.");
				}
				else{
					String[] authorData = authorT.getText().split(",");
					ourLib.addOneBook(titleT.getText(), authorData, result_label);
					ourLib.saveFile();
				}
			}
		});
	}
}
