package pckg;

import java.util.List;

public class Main {
	
	static List<Book> list = BookReader.readBooks();
	
	public static void main(String[] args) {

		for (Book b : Sort.byPublicationYear(list)) {
			System.out.println(b);
		}
		
		System.out.println(list.size());
		
	}
}
