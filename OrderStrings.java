package lab06;

import java.util.Comparator;

public class OrderStrings implements Comparator<String> {

	public int compare(String one, String two) {

		int answ;
		answ = one.compareTo(two);
		return answ;

	}

}
