/**
 * Borrower class
 */

/**
 * @version 1.0.1
 * @author 2017315005 안시후, 2017315027 최재성, 2017315035 김선혁, 2017315053 후쿠미쓰 치아키
 */

package Process;

import java.util.Vector;

public class Borrower
{
	private String name;
	private Vector<Book> books;

	public Borrower(String name)
	{
		this.name = name;
		books = new Vector<Book>();
	}

	public String getName()
	{
		return name;
	}

	public Vector<Book> getBooks()
	{
		return books;
	}

	public void setBook(Vector<Book> books)
	{
		this.books = books;
	}

	public void detachBook(Book book)
	{
		for (int i = 0; i < books.size(); i++)
		{
			if (books.elementAt(i).getCatalogueNumber() == book.getCatalogueNumber())
			{
				books.remove(i);
			}
		}
	}

	public void attachBook(Book book)
	{
		books.add(book);
	}

}
