package pckg;

import java.util.Arrays;
import java.util.List;

public class Sort {

	public static List<Book> byPublicationYear(List<Book> list) {
		
		Book[] array = list.toArray(new Book[0]);
		
		for (int i = 0; i < array.length - 1; ++i) {
			
			int indexSmallest = i;
			
			for (int j = i + 1; j < array.length; ++j) {
				if (array[j].originalPublicationYear < array[indexSmallest].originalPublicationYear) {
					indexSmallest = j; 
				}
			}
			
			Book temp = array[indexSmallest];
			array[indexSmallest] = array[i];
			array[i] = temp;
			
			
		}
		
		List<Book> sortedList = Arrays.asList(array);
		
		return sortedList;
	}
}
