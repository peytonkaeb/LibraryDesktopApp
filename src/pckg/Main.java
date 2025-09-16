package pckg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Book> list = new LinkedList<Book>();
	
	public static void readCSV() {
		try(FileInputStream fis = new FileInputStream("data/books.csv");
				Scanner scnr = new Scanner(fis);) {
			
			// Consume header
			scnr.nextLine();
			
			while (scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String[] fields = safeCSVSplit(line);
				
				for (String s : fields) {
					System.out.println(s);
				}
				
				Book newBook = new Book(
					    Integer.parseInt(fields[0]), // book_id
					    Integer.parseInt(fields[1]), // goodreads_book_id
					    Integer.parseInt(fields[2]), // best_book_id
					    Integer.parseInt(fields[3]), // work_id
					    Integer.parseInt(fields[4]), // books_count
					    fields[5], // isbn 
					    fields[6],                  // isbn13
					    fields[7],                  // authors
					    (int)Double.parseDouble(fields[8]),         // originalPublicationYear
					    fields[9],                  // originalTitle
					    fields[10],                 // title
					    fields[11],                 // languageCode
					    Double.parseDouble(fields[12]), // averageRating
					    Integer.parseInt(fields[13]), // ratingsCount
					    Integer.parseInt(fields[14]), // workRatingsCount
					    Integer.parseInt(fields[15]), // workTextReviewsCount
					    Integer.parseInt(fields[16]), // ratings1
					    Integer.parseInt(fields[17]), // ratings2
					    Integer.parseInt(fields[18]), // ratings3
					    Integer.parseInt(fields[19]), // ratings4
					    Integer.parseInt(fields[20]), // ratings5
					    fields[21],                 // imageURL
					    fields[22]                  // smallImageURL
					);
				list.add(newBook);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static String[] safeCSVSplit(String s) {
		
		
		ArrayList<String> arrayList = new ArrayList<String>();
		var sb = new StringBuilder();
		boolean inQuotes = false;
		
		for (char c : s.toCharArray()) {
			if (c == '"') {
				inQuotes = !inQuotes;
			}
			if (c == ',') {
				if (inQuotes) {
					sb.append(c);
				}
				else {
					if (sb.length() != 0) {
						arrayList.add(sb.toString());
						sb = new StringBuilder();
					}
					// temporary solution for empty string
					else {
						sb.append("0");
						arrayList.add(sb.toString());
						sb = new StringBuilder();
					}
				}
			}
			else {
				sb.append(c);
			}
		}
		// dump last string
		arrayList.add(sb.toString());
		
		return arrayList.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		readCSV();
		
	}
}
