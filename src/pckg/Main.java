package pckg;

import java.util.List;

import javax.swing.SwingUtilities;

public class Main {
	
	static List<Book> list = BookReader.readBooks();
	
	public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Layout();
        });
		
	}
}
