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

public class LibrarySystem {
	private String name;
	private HashSet<Borrower> borrowers = new HashSet<Borrower>();
	private TreeSet<Book> books = new TreeSet<Book>(new Comp());
	
	public LibrarySystem(String name){
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
	public Borrower findBorrower(String name){
		for (Borrower ob : borrowers) {
		    if (ob.getName().equals(name)) {
		      return ob;
		    }
		  } 
		return null;
	}
	
	public void registerOneBorrower(String name){
		Borrower borrower = findBorrower(name);
		if(borrower == null){
			borrowers.add(new Borrower(name));
			System.out.println("등록되었습니다.");
		}
		else{
			System.out.println("이미 등록되어있는 사용자 이름입니다.");
		}
	}
	public void addOneBook(String title,String[] author,int catalogNumber){
		Book book = findBook(catalogNumber);
		if(book == null){
			books.add(new Book(title, author, catalogNumber));
			System.out.println("등록되었습니다..");
		}
		else{
			System.out.println("이미 등록되어있는 catalogNumber입니다.");
		}
	}
	
	public void lendOneBook(String name, int catalogNumber){
		Borrower borrower = findBorrower(name);
		if(borrower != null){
			Book book = findBook(catalogNumber);
			if(book.getBorrower() != null){
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
		}
		else{
			System.out.println("등록되지 않은 사용자입니다.");
		}
	}
	
	public void returnOneBook(int catalogNumber){
		Book book = findBook(catalogNumber);
		Borrower borrower = book.getBorrower();
		if(borrower == null){
			System.out.println("이미 반납되어있는 책입니다.");
		}
		else{
			book.detachBorrower();
			borrower.detachBook(book);
			System.out.println("반납 처리 되었습니다.");
		}
	}
	public void displaybooksAvailableForLoan(){
		for (Book ob : books) {
		    if (ob.getBorrower() == null) {
		      System.out.print("1." + ob.getTitle() + "  2.");
		      for(int i = 0; i < ob.getAuthor().length;i++){
		    	  System.out.print(ob.getAuthor()[i]);
		    	  if(i != ob.getAuthor().length-1){
		    		  System.out.print(",");
		    	  }
		      }
		      System.out.print(" 3." + ob.getCatalogueNumber() + "\n");
		      }
		}
	}
	public void displaybooksOnLoan(){
		for (Book ob : books) {
		    if (ob.getBorrower() != null) {
		      System.out.println("<<" + ob.getTitle() + ">>");
		      System.out.print("Author : ");
		      for(int i = 0; i < ob.getAuthor().length;i++){
		    	  System.out.print(ob.getAuthor()[i]);
		    	  if(i != ob.getAuthor().length-1){
		    		  System.out.print(",");
		    	  }
		      }
		      System.out.println("\nCatalogNumber : " + ob.getCatalogueNumber());
		      System.out.println("RentalDate : " + ob.getRentalDate());
		      System.out.println("ReturnData : " + ob.getReturnDate());
		      }
		}
	}
	
	public void saveFile(){
		try
		{
			FileWriter borrowerFile = new FileWriter("Borrower.txt");
			FileWriter bookFile = new FileWriter("Book.txt");
			String borrowerInformation;
			String bookInformation;
			
			for(Borrower ob : borrowers){
				borrowerInformation = ob.getName();
				for(Book book : ob.getBooks()){
					borrowerInformation += "," + book.getCatalogueNumber() + "," + book.getRentalDate() + "," + book.getReturnDate();
				}
				borrowerFile.write(borrowerInformation+"\n");
			}
			borrowerFile.close();
			
			for(Book ob : books){
				bookInformation = ob.getTitle() +",";
				for(String author : ob.getAuthor()){
					bookInformation += author +",";
				}
				bookInformation += ob.getCatalogueNumber() +"\n";
				System.out.println(bookInformation);
				bookFile.write(bookInformation);
			}
			bookFile.close();

			System.out.println("파일을 저장했습니다.");
		}
		catch (Exception e)
		{
			System.out.println("오류" + e);
		}
	}
		
	public void loadFile(){
		FileReader borrowerFile = null;
		FileReader bookFile = null;
		BufferedReader bufferedReader = null;

		try
		{
			bookFile = new FileReader("Book.txt");
			bufferedReader = new BufferedReader(bookFile);
			String[] bookData;
			String title;
			String[] author;
			int catalogNumber;
			String string = new String();
			string = bufferedReader.readLine();
			
			while(string != null){
				bookData = string.split(",");
				title = bookData[0];
				catalogNumber = Integer.parseInt(bookData[bookData.length-1]);
				author = Arrays.copyOfRange(bookData,1,bookData.length-1);
				addOneBook(title, author, catalogNumber);
				string = bufferedReader.readLine();
			}
			bookFile.close();
			
			borrowerFile = new FileReader("Borrower.txt");
			bufferedReader = new BufferedReader(borrowerFile);

			string = new String();
			string = bufferedReader.readLine();
			String[] loanInformation = string.split(",");
			
			while(string != null){
				loanInformation = string.split(",");
				System.out.println(loanInformation[0]);
				registerOneBorrower(loanInformation[0]);
				System.out.println(loanInformation.length);
				if(1 < loanInformation.length)
				{
					for(int i = 1; i < loanInformation.length; i+=3){
						Book book = findBook(Integer.parseInt(loanInformation[i]));
						Borrower borrower = findBorrower(loanInformation[0]);
						book.attachBorrower(borrower);
						borrower.attachBook(book);
						book.setRentalDate(loanInformation[i+1]);
						book.setReturnDate(loanInformation[i+2]);
					}
				}
				string = bufferedReader.readLine();
			}
			
			System.out.println("저장된 자료를 읽어 들였습니다.");
		}
		catch (Exception e)
		{
			System.out.println("오류" + e);
		}
	}
	
}
