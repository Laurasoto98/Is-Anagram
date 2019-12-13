package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class AnagramUtil {

	public static String sort(String inputString) {

		if (inputString.length() > 0) {

			inputString = inputString.toLowerCase();

			String inputSort = "";

			int size = inputString.length();

			char[] values = new char[size];

			for (int i = 0; i < size; i++) {

				values[i] = inputString.charAt(i);
			}

			for (int i = 0; i < values.length; i++) {

				char min = values[i];

				int j = i;

				while (j > 0 && values[j - 1] > min) {

					values[j] = values[j - 1];

					j--;

				}

				values[j] = min;

			}

			for (int i = 0; i < inputString.length(); i++) {

				inputSort += values[i];
			}

			return inputSort;

		} else {

			return null;
		}
	}

	public static boolean areAnagrams(String string1, String string2) {

		if (string1.length() > 0 && string2.length() > 0) {
			string1 = sort(string1);
			string2 = sort(string2);

			if (string1.equals(string2)) {

				return true;

			}

			else {

				return false;

			}
		} else {
			return false;
		}

	}

	public static void insertionSort(String[] inputList) {

		OrderStrings compare = new OrderStrings();

		if (inputList.length > 0) {

			for (int i = 0; i < inputList.length; i++) {

				String value = inputList[i];
				int j = i;

				while (j > 0 && compare.compare(sort(value), sort(inputList[j - 1])) < 0) {

					inputList[j] = inputList[j - 1];
					j--;

				}

				inputList[j] = value;

			}
		}

	}

	public static String[] getLargestAnagramGroup(String[] inputList) {

		OrderStrings compare = new OrderStrings();
		String large = "";
		int num;
		int max = 0;

		for (int i = 0; i < inputList.length; i++) {

			if (inputList[i] != large) {

				num = 0;

				for (int j = 0; j < inputList.length; j++) {

					if (compare.compare(sort(inputList[i]), sort(inputList[j])) == 0) {
						num++;
					}
				}

				if (num > max) {

					max = num;
					large = inputList[i];
				}

			}
		}

		String[] largestGroup = new String[max];
		int size = 0;
		for (int i = 0; i < inputList.length; i++) {

			if (compare.compare(sort(inputList[i]), sort(large)) == 0) {

				largestGroup[size] = inputList[i];
				size++;
			}
		}

		return largestGroup;

	}

	public static String[] getLargestAnagramGroup(String filename) {

		String[] fileList = readFile(filename);

		return getLargestAnagramGroup(fileList);

	}

	public static void main(String[] args) {

		OrderStrings compare = new OrderStrings();

		String name = "Laura";
		String lastName = "Soto";
		String nameOrder = sort(name);
		String[] list = new String[] { "tata", "daniel", "jack", "sara" };
		String[] list2 = new String[] { "joy", "ski", "fed", "cat" };

		System.out.println(name);
		System.out.println(nameOrder);
		System.out.println(areAnagrams(name, nameOrder));
		System.out.println(areAnagrams(name, lastName));
		System.out.println(compare.compare(name, lastName));

		insertionSort(list);
		insertionSort(list2);

		String[] words_copy = readFile("sample_word_list.txt");
		String[] s3 = getLargestAnagramGroup(words_copy);
		String[] s4 = getLargestAnagramGroup("sample_word_list.txt");
		String[] empty = new String[] {};
		String[] s5 = getLargestAnagramGroup(empty);

		for (int i = 0; i < list.length; i++) {

			System.out.print(list[i] + " ");
		}

		System.out.println();

		for (int i = 0; i < list2.length; i++) {

			System.out.print(list2[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < s3.length; i++) {

			System.out.print(s3[i] + " ");
		}

		System.out.println();

		for (int i = 0; i < s3.length; i++) {

			System.out.print(s3[i] + " ");
		}

		System.out.println();

		for (int i = 0; i < s5.length; i++) {

			System.out.print(s5[i] + " ");
		}

	}

	public static String[] readFile(String filename) {
		ArrayList<String> results = new ArrayList<String>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(filename));
			while (input.ready()) {
				results.add(input.readLine());
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] retval = new String[1];
		return results.toArray(retval);
	}
}
