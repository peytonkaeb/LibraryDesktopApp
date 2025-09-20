package pckg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Search {

	public static void test(List<Book> list) {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Search for top 10 or exact match?");
		
		String searchBreadth = scnr.nextLine();
		
		System.out.println("Sort by ISBN or book_id?");
		
		String searchType = scnr.nextLine();
		
		System.out.println("Enter search: ");
		
		String search = scnr.nextLine();
		
		
		if (searchBreadth.equalsIgnoreCase("top 10")) {
			if (searchType.equalsIgnoreCase("isbn")) {
				list = top10ByISBN(list, search);
				System.out.println("Printing top matches:");
				for (int i = 0; i < 10 && i < list.size(); ++i) {
					System.out.println(list.get(i));
				}
			}
			else if (searchType.equalsIgnoreCase("book_id")) {
				list = top10ByID(list, Integer.parseInt(search));
				System.out.println("Printing top matches:");
				for (int i = 0; i < 10 && i < list.size(); ++i) {
					System.out.println(list.get(i));
				}
			}
		}
		else if (searchBreadth.equalsIgnoreCase("exact")) {
			if (searchType.equalsIgnoreCase("isbn")) {
				
				List<Book> sortedList = Sort.byISBN(list);
				
				ArrayList<Book> convertedList = new ArrayList<Book>(sortedList);
				
				Book foundBook = byISBN(convertedList, search);
				
				System.out.println(foundBook.equals(null) ? "No match found" : foundBook);
			}
			else if (searchType.equalsIgnoreCase("book_id")) {
				
				List<Book> sortedList = Sort.byID(list);
				
				ArrayList<Book> convertedList = new ArrayList<Book>(sortedList);
				
				Book foundBook = byID(convertedList, Integer.valueOf(search));
				
				System.out.println(foundBook == null ? "No match found" : foundBook);
			}
		}
		
		
		scnr.close();
	}
	
	/* General List<Book> search (returns top matches) */
	
	public static List<Book> top10ByISBN(List<Book> list, String s) {
		
		List<Book> sortedList = new ArrayList<Book>();
		
		for (Book b : list) {
			if (b.isbn.contains(s) || String.valueOf(b.isbn13).contains(s)) {
				sortedList.add(b);
			}
		}
		
		return sortedList;
	}
	
	public static List<Book> top10ByID(List<Book> list, int s) {
		
		List<Book> sortedList = new ArrayList<Book>();
		
		for (Book b : list) {
			if (b.bookID == s) {
				sortedList.add(b);
			}
		}
		
		return sortedList;
	}
	
	/* LinkedList - Linear Search (finds exact match) */
	
	public static Book byISBN(LinkedList<Book> list, String s) {
		
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).isbn.equals(s) || String.valueOf(list.get(i).isbn13).equals(s)) {
				return list.get(i);
			}
		}
		
		return null;
	}
	
	public static Book byID(LinkedList<Book> list, int s) {
		
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).bookID == s) {
				return list.get(i);
			}
		}
		
		return null;
	}
	
	/* ArrayList - Binary Search (finds exact match, input must be sorted) */
	
	public static Book byISBN(ArrayList<Book> list, String s) {
		
		int min = 0;
		
		int max = list.size() - 1; 
		
		int mid = min + (max - min) / 2;
		
		Book currBook;
		
		while (true) {
			
			currBook = list.get(mid);
			
			if (min >= max) {
				return null;
			}
			
			if (currBook.isbn.equalsIgnoreCase(s) || String.valueOf(currBook.isbn13).equals(s)) {
				return currBook;
			}
			if (currBook.isbn.compareTo(s) > 0) {
				max = mid - 1;
				mid = min + (max - min) / 2;
				continue;
			}
			else if (currBook.isbn.compareTo(s) < 0) {
				min = mid + 1;
				mid = min + (max - min) / 2;
				continue;
			}
		}
	}
	
	public static Book byID(ArrayList<Book> list, int s) {
		
		int min = 0;
		
		int max = list.size() - 1; 
		
		int mid = min + (max - min) / 2;
		
		Book currBook;
		
		while (true) {
			
			currBook = list.get(mid);
			
			if (min >= max) {
				return null;
			}
			
			if (currBook.bookID == s) {
				return currBook;
			}
			if (currBook.bookID > s) {
				max = mid - 1;
				mid = min + (max - min) / 2;
				continue;
			}
			else if (currBook.bookID < s) {
				min = mid + 1;
				mid = min + (max - min) / 2;
				continue;
			}
		}
	}
}
