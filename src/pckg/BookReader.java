package pckg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookReader {
	
	public static final String[] DEFAULT_VALUES = {
			"-1", "-1", "-1", "-1", "-1", // IDs
			"000000000X", "0", 
			"Unknown Authors", "-1", "Unknown Original Title",
			"Unknown Title", "???", "0.0", "0", "0", "0", "0", "0", "0", "0", "0", "placeholder", "placeholder"
	};
	
	public static final String[] VALIDATION_REGEX = {
			"\\d{0,5}", "^\\d+$", "^\\d+$", "^\\d+$", "^\\d+$", // book IDs and count
			"^\\d{0,9}[\\dX]$", "^\\d\\.\\d{1,12}e\\+12$", // isbn and isbn13 (stored in csv as scientific notation)
			".*", // Authors
			"\\d{1,4}(\\.\\d)?", // Year
			".*",  ".*", // Titles
			".*", // Language code
			".*", // Average rating
			"^\\d+$", "^\\d+$", "^\\d+$", // Ratings counts
			"^\\d+$", "^\\d+$", "^\\d+$", "^\\d+$", "^\\d+$", // Ratings 1-5
			".*", ".*" // URLs (anything is allowed here because invalid URLs will be assigned with a default later)
	};

	public static List<Book> readBooks() {
		
		// Change this to ArrayList for different implementation
		List<Book> list = new LinkedList<Book>();
		try (FileInputStream fis = new FileInputStream("data/books1000.csv");
				Scanner scnr = new Scanner(fis);) {
			
			// Consume header
			scnr.nextLine();
			
			while (scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String[] fields = safeCSVSplit(line);
				
				Book newBook = new Book(
					    Integer.parseInt(fields[0]), // book_id
					    Integer.parseInt(fields[1]), // goodreads_book_id
					    Integer.parseInt(fields[2]), // best_book_id
					    Integer.parseInt(fields[3]), // work_id
					    Integer.parseInt(fields[4]), // books_count
					    fields[5], 					// isbn 
					    (long)Double.parseDouble(fields[6]),                  // isbn13
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
				
				if (validateBook(fields)) {
					list.add(newBook);
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return list;
	}
	
	private static String[] safeCSVSplit(String s) {
		
		String[] array = new String[23];
		var sb = new StringBuilder();
		boolean inQuotes = false;
		int index = 0;
		
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
						array[index] = sb.toString();
						sb = new StringBuilder();
						++index;
					}
					// empty string
					else {
						array[index] = DEFAULT_VALUES[index];
						++index;
					}
				}
			}
			else {
				sb.append(c);
			}
		}

		array[index] = sb.toString();
		
		return array;
	}
	
	private static boolean validateBook(String[] fields) {

		for (int i = 0; i < fields.length; ++i) {
			if (!Pattern.matches(VALIDATION_REGEX[i], fields[i])) {
				return false;
			}
		}
		return true;
	}
}
