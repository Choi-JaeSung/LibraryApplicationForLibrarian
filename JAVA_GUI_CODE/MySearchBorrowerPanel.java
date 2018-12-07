/**
 * Search Borrower panel class
 */

/**
 * @version 1.0.2
 * @author 2017315005 안시후, 2017315027 최재성, 2017315035 김선혁, 2017315053 후쿠미쓰 치아키
 */
 
package GUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MySearchBorrowerPanel extends JPanel {
	public JTextArea text;
	JScrollPane sp;
	JLabel title;
	public MySearchBorrowerPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setSize(700, 595);
		
		title = new JLabel("Books Available For Loan");
		title.setBounds(220, 13, 300, 50);
		title.setFont(new Font("malgun gothic", Font.BOLD, 20));
		this.add(title);

		text = new JTextArea();
		text.setEditable(false);

		sp = new JScrollPane(text);
		sp.setBounds(5, 70, 675, 480);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(sp);
	}
}
