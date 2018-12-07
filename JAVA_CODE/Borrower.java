package Process;

import java.util.Vector;

public class Borrower {
	private String name;
	private Vector<Book> books;
	
	public Borrower(String name){
		this.name = name;
		books = new Vector<Book>();
	}
	public String getName() {
		return name;
	}
	public Vector<Book> getBooks() {
		return books;
	}
	public void setBook(Vector<Book> books) {
		this.books = books;
	}
	
	public void detachBook(Book book){
		for(int i = 0 ; i < books.size(); i++){
			if(books.elementAt(i).getCatalogueNumber() == book.getCatalogueNumber()){
				books.remove(i);
			}
		}
	}
	
	public void attachBook(Book book){
		books.add(book);
	}

}
