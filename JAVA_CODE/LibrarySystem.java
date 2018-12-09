/**
 * Library system class
 */

/**
 * @version 1.0.2
 * @author 2017315005 안시후, 2017315027 최재성, 2017315035 김선혁, 2017315053 후쿠미쓰 치아키
 */

package Process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import GUI.MyDisplayBooksPanel;
import GUI.SearchMain;

public class LibrarySystem {
	private String name;
	private HashSet<Borrower> borrowers = new HashSet<Borrower>();
	private TreeSet<Book> books = new TreeSet<Book>(new Comp());

	public LibrarySystem(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashSet<Borrower> getborrowers() {
		return borrowers;
	}

	public void setborrower(HashSet<Borrower> borrowers) {
		this.borrowers = borrowers;
	}

	public TreeSet<Book> getbooks() {
		return books;
	}

	public void setbook(TreeSet<Book> books) {
		this.books = books;
	}

	public Book findBook(int catalogNumber) {
		for (Book ob : books) {
			if (ob.getCatalogueNumber() == catalogNumber) {
				return ob;
			}
		}
		return null;
	}

	public Borrower findBorrower(String name) {
		for (Borrower ob : borrowers) {
			if (ob.getName().equals(name)) {
				return ob;
			}
		}
		return null;
	}

	public void registerOneBorrower(String name) {
		Borrower borrower = findBorrower(name);
		if (borrower == null) {
			borrowers.add(new Borrower(name));
		}
	}

	public void registerOneBorrower(String name, JLabel label) {
		Borrower borrower = findBorrower(name);
		if (borrower == null) {
			borrowers.add(new Borrower(name));
			label.setText("Register Complete");
		} else {
			label.setText("Already Registered");
			;
		}
	}

	public void deleteOneBorrower(String name, JLabel label) {
		Borrower borrower = findBorrower(name);
		if (borrower.getBooks().size() == 0) {
			borrowers.remove(borrower);
			label.setText("Deletion Complete");
		} else {
			label.setText("The conditions were not met.");
		}
	}

	public void deleteOneBook(int catalogNumber, JLabel label) {
		Book book = findBook(catalogNumber);
		if (book.getBorrower() == null) {
			books.remove(book);
			label.setText("Deletion Complete");
		} else {
			label.setText("The conditions were not met.");
		}
	}

	public void addOneBook(String title, String[] author, int catalogNumber) {
		Book book = findBook(catalogNumber);
		if (book == null) {
			books.add(new Book(title, author, catalogNumber));
		}
	}

	public void addOneBook(String title, String[] author, JLabel label) {
		books.add(new Book(title, author, books.size() + 1));
		label.setText("Register Complete");
	}

	public void lendOneBook(String name, int catalogNumber, JLabel result_label) {
		Borrower borrower = findBorrower(name);

		if (borrower != null) {
			Book book = findBook(catalogNumber);
			if (book.getBorrower() != null) {
				Borrower borrowerOnLoan = book.getBorrower();
				borrowerOnLoan.detachBook(book);
				book.detachBorrower();
			}
			book.attachBorrower(borrower);

			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			String strDate = df.format(cal.getTime());

			book.setRentalDate(strDate);

			cal.add(Calendar.DATE, 14);
			strDate = df.format(cal.getTime());

			book.setReturnDate(strDate);

			// 특정 형태의 날짜로 값을 뽑기

			borrower.attachBook(book);
			result_label.setText("Loan Complete");
		} else {
			result_label.setText("Not registered name");
		}
	}

	public void returnOneBook(int catalogNumber, JLabel result_label) {
		try {
			Book book = findBook(catalogNumber);
			Borrower borrower = book.getBorrower();
			if (borrower == null) {
				result_label.setText("Aleady returned");
			} else {
				book.detachBorrower();
				borrower.detachBook(book);
				result_label.setText("Return suceed");
			}
		} catch (NullPointerException e) {
		}

	}

	public void displayBooksOnLoan(MyDisplayBooksPanel panel) {
		String display = null;

		panel.text.setText("");
		panel.text.append("Title ┃ Author ┃ CatalogueNumber ┃ LoanDate ┃ ReturnDate  ┃ Borrower\n");
		panel.text.append("───────────────────────────────────────────────────────────────\n");

		for (Book book : books) {
			if (book.getBorrower() != null) {
				display = book.getTitle() + "┃ ";
				for (int i = 0; i < book.getAuthor().length; i++) {
					display += book.getAuthor()[i];
					if (i != book.getAuthor().length - 1) {
						display += ", ";
					}
				}
				display += "┃ " + book.getCatalogueNumber();
				display += "┃" + book.getRentalDate();
				display += "┃ " + book.getReturnDate();
				display += "┃ " + book.getBorrower().getName();
				panel.text.append(display + "\n");
				panel.text.append("───────────────────────────────────────────────────────────────\n");

			}
		}
	}

	public void displayBooksAvailableForLoan(MyDisplayBooksPanel panel) {
		String display = null;
		panel.text.setText("");
		panel.text.append("Title ┃ Author ┃ CatalogueNumber ┃ LoanDate ┃ ReturnDate\n");
		panel.text.append("───────────────────────────────────────────────────────────────\n");
		for (Book book : books) {
			if (book.getBorrower() == null) {
				display = book.getTitle() + "┃ ";
				for (int i = 0; i < book.getAuthor().length; i++) {
					display += book.getAuthor()[i];
					if (i != book.getAuthor().length - 1) {
						display += ", ";
					}
				}
				display += "┃ " + book.getCatalogueNumber();
				display += "┃" + book.getRentalDate();
				display += "┃ " + book.getReturnDate();
				panel.text.append(display + "\n");
				panel.text.append("───────────────────────────────────────────────────────────────\n");

			}
		}
	}

	public void saveFile() {
		try {
			FileWriter borrowerFile = new FileWriter("Borrower.txt");
			FileWriter bookFile = new FileWriter("Book.txt");
			String borrowerInformation;
			String bookInformation;

			for (Borrower ob : borrowers) {
				borrowerInformation = ob.getName();
				for (Book book : ob.getBooks()) {
					borrowerInformation += "," + book.getCatalogueNumber() + "," + book.getRentalDate() + ","
							+ book.getReturnDate();
				}
				borrowerFile.write(borrowerInformation + "\n");
			}
			borrowerFile.close();

			for (Book ob : books) {
				bookInformation = ob.getTitle() + ",";
				for (String author : ob.getAuthor()) {
					bookInformation += author + ",";
				}
				bookInformation += ob.getCatalogueNumber() + "\n";
				bookFile.write(bookInformation);
			}
			bookFile.close();

		} catch (Exception e) {
		}
	}

	public void loadFile() {
		FileReader borrowerFile = null;
		FileReader bookFile = null;
		BufferedReader bufferedReader = null;

		try {
			bookFile = new FileReader("Book.txt");
			bufferedReader = new BufferedReader(bookFile);
			String[] bookData;
			String title;
			String[] author;
			int catalogNumber;
			String string = new String();
			string = bufferedReader.readLine();

			while (string != null) {
				bookData = string.split(",");
				title = bookData[0];
				catalogNumber = Integer.parseInt(bookData[bookData.length - 1]);
				author = Arrays.copyOfRange(bookData, 1, bookData.length - 1);
				addOneBook(title, author, catalogNumber);
				string = bufferedReader.readLine();
			}
			bookFile.close();

			borrowerFile = new FileReader("Borrower.txt");
			bufferedReader = new BufferedReader(borrowerFile);

			string = new String();
			string = bufferedReader.readLine();
			String[] loanInformation = string.split(",");

			while (string != null) {
				loanInformation = string.split(",");
				registerOneBorrower(loanInformation[0]);
				if (1 < loanInformation.length) {
					for (int i = 1; i < loanInformation.length; i += 3) {
						Book book = findBook(Integer.parseInt(loanInformation[i]));
						Borrower borrower = findBorrower(loanInformation[0]);
						book.attachBorrower(borrower);
						borrower.attachBook(book);
						book.setRentalDate(loanInformation[i + 1]);
						book.setReturnDate(loanInformation[i + 2]);
					}
				}
				string = bufferedReader.readLine();
			}
		} catch (Exception e) {
		}
	}

	public void searchBorrower(String information, JTextArea text) {
		String display;
		text.setText("");
		text.append("Title ┃ Author ┃ CatalogueNumber ┃ LoanDate ┃ ReturnDate\n");
		text.append("───────────────────────────────────────────────────────────────\n");
		for (Borrower borrower : borrowers) {
			if (borrower.getName().equals(information)) {
				for (Book book : borrower.getBooks()) {
					display = book.getTitle() + "┃ ";
					for (int i = 0; i < book.getAuthor().length; i++) {
						display += book.getAuthor()[i];
						if (i != book.getAuthor().length - 1) {
							display += ", ";
						}
					}
					display += "┃ " + book.getCatalogueNumber();
					display += "┃" + book.getRentalDate();
					display += "┃ " + book.getReturnDate();
					text.append(display + "\n");
					text.append("───────────────────────────────────────────────────────────────\n");
				}
			}
		}
	}

	public void searchBooks(String information, JTextArea text, int index) {
		String display;
		text.setText("");
		text.append("Title ┃ Author ┃ CatalogueNumber ┃ LoanDate ┃ ReturnDate\n");
		text.append("───────────────────────────────────────────────────────────────\n");
		for (Book book : books) {
			switch (index) {
			case 0:
				if (book.getTitle().contains(information)) {
					display = book.getTitle() + "┃ ";
					for (int i = 0; i < book.getAuthor().length; i++) {
						display += book.getAuthor()[i];
						if (i != book.getAuthor().length - 1) {
							display += ", ";
						}
					}
					display += "┃ " + book.getCatalogueNumber();
					display += "┃" + book.getRentalDate();
					display += "┃ " + book.getReturnDate();
					text.append(display + "\n");
					text.append("───────────────────────────────────────────────────────────────\n");
				}
				break;
			case 1:
				for (String author : book.getAuthor()) {
					if (author.contains(information)) {
						display = book.getTitle() + "┃ ";
						for (int i = 0; i < book.getAuthor().length; i++) {
							display += book.getAuthor()[i];
							if (i != book.getAuthor().length - 1) {
								display += ", ";
							}
						}
						display += "┃ " + book.getCatalogueNumber();
						display += "┃" + book.getRentalDate();
						display += "┃ " + book.getReturnDate();
						text.append(display + "\n");
						text.append("───────────────────────────────────────────────────────────────\n");
					}
				}
				break;
			case 2:
				try {
					if (book.getCatalogueNumber() == Integer.parseInt(information)) {
						display = book.getTitle() + "┃ ";
						for (int i = 0; i < book.getAuthor().length; i++) {
							display += book.getAuthor()[i];
							if (i != book.getAuthor().length - 1) {
								display += ", ";
							}
						}
						display += "┃ " + book.getCatalogueNumber();
						display += "┃" + book.getRentalDate();
						display += "┃ " + book.getReturnDate();
						text.append(display + "\n");
						text.append("───────────────────────────────────────────────────────────────\n");
						break;
					}
				} catch (Exception e) {
				}
			}

		}
	}
}
