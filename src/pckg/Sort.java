package pckg;

import java.util.Arrays;
import java.util.List;

public class Sort {
	
	/* Sort methods for GUI: */

	public static List<Book> byPublicationYearAscending(List<Book> list) {
		
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
	
	public static List<Book> byPublicationYearDescending(List<Book> list) {
		
		Book[] array = list.toArray(new Book[0]);
		
		for (int i = 0; i < array.length - 1; ++i) {
			
			int indexLargest = i;
			
			for (int j = i + 1; j < array.length; ++j) {
				if (array[j].originalPublicationYear > array[indexLargest].originalPublicationYear) {
					indexLargest = j; 
				}
			}
			
			Book temp = array[indexLargest];
			array[indexLargest] = array[i];
			array[i] = temp;
			
		}
		
		List<Book> sortedList = Arrays.asList(array);
		
		return sortedList;
	}
	
	public static List<Book> alphabeticallyAscending(List<Book> list){
        boolean swapped;
        int n = list.size();
        do {
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                Book current = list.get(i);
                Book next = list.get(i+1);

                if(current.authors.compareToIgnoreCase(next.authors) > 0){
                    //swaps if out of order
                    list.set(i, next);
                    list.set(i+1, current);
                    swapped = true;
                    
                }
            }

            n--;
        } while (swapped); // this makes the "do" run as long as the condition works 
        //If you want to check: System.out.println(BookReader.booksList);
        
        return list;
    }
	
    public static List<Book> alphabeticallyDescending(List<Book> list){
        boolean swapped;
        int n = list.size();
        do {
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                Book current = list.get(i);
                Book next = list.get(i+1);

                if(current.authors.compareToIgnoreCase(next.authors) < 0){
                    //swaps if out of order
                    list.set(i, next);
                    list.set(i+1, current);
                    swapped = true;
                }
            }

        } while (swapped); // this makes the "do" run as long as the condition works 
        
        return list;
    }
    
	
	/* Sort methods used by Binary Search: */
	
	public static List<Book> byISBN(List<Book> list) {
		
		Book[] array = list.toArray(new Book[0]);
		
		for (int i = 0; i < array.length - 1; ++i) {
			
			int indexSmallest = i;
			
			for (int j = i + 1; j < array.length; ++j) {
				if (array[j].isbn.compareToIgnoreCase(array[indexSmallest].isbn) < 0) {
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
	
	public static List<Book> byID(List<Book> list) {
		Book[] array = list.toArray(new Book[0]);
		
		for (int i = 0; i < array.length - 1; ++i) {
			
			int indexSmallest = i;
			
			for (int j = i + 1; j < array.length; ++j) {
				if (array[j].bookID < array[indexSmallest].bookID) {
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
