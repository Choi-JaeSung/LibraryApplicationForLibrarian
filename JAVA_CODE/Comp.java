package Process;
import java.util.Comparator;

public class Comp implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getCatalogueNumber() < o2.getCatalogueNumber() ? - 1 : (o1 == o2 ? 0 : 1);
	}

}