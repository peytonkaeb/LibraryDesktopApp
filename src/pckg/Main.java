package pckg;

import java.util.List;

import javax.swing.SwingUtilities;

public class Main {
	
	/*
	 * TODO:
	 * Performance testing
	 * GUI functionality
	 * If not found in ISBN, check ISBN13 
	 */
	
	static List<Book> list = BookReader.readBooks();
	
	public static void main(String[] args) {

//		Scanner scnr = new Scanner(System.in);
//		System.out.println("Which implementation would you like to use? (ArrayList or LinkedList)");
		
		Search.time(list);
		
		
        SwingUtilities.invokeLater(() -> {
            new Layout();
        });
		
	}
}
