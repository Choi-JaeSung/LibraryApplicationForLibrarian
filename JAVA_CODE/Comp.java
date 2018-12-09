/**
 * Comp class implements by Comparator<Book>
 */

/**
 * @version 1.0.2
 * @author 2017315005 안시후, 2017315027 최재성, 2017315035 김선혁, 2017315053 후쿠미쓰 치아키
 */

package Process;
import java.util.Comparator;

public class Comp implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getCatalogueNumber() < o2.getCatalogueNumber() ? - 1 : (o1 == o2 ? 0 : 1);
	}

}
