/**
 * Book class
 */

/**
 * @version 1.0.2
 * @author 2017315005 안시후, 2017315027 최재성, 2017315035 김선혁, 2017315053 후쿠미쓰 치아키
 */

package Process;

public class Book{
	private int catalogNumber;
	private String[] author;
	private String title;
	private Borrower borrower;
	private String rentalDate;
	private String returnDate;
	
	public Book(String title, String[] author, int catalogueNumber){
		this.title = title;
		this.author = author;
		this.catalogNumber = catalogueNumber;
	}

	public int getCatalogueNumber() {
		return catalogNumber;
	}
	public String[] getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public void setCatalogueNumber(int catalogueNumber) {
		this.catalogNumber = catalogueNumber;
	}
	public void setAuthor(String[] author) {
		this.author = author;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public void detachBorrower(){
		borrower = null;
	}
	public void attachBorrower(Borrower borrower){
		this.borrower = borrower;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
}
