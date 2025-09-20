import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.SwingUtilities;


public class BookReader {

    public int book_id;
    private int goodreads_book_id;
    private int best_book_id;
    private int work_id;
    private int books_count;
    public double isbn;
    private double isbn13;
    public String authors;
    private int original_publication_year;
    private String original_title;
    public String title;
    private String language_code;
    private double average_rating;
    private int ratings_count;
    private int work_ratings_count;
    private int work_text_reviews_count;
    private int ratings_1;
    private int ratings_2;
    private int ratings_3;
    private int ratings_4;
    private int ratings_5;
    private String image_url;
    private String small_image_url;

    public static LinkedList<BookReader> booksList = new LinkedList<>();

    public BookReader() { }

    public void populateFromCSV(String[] fields) {
        try {
            this.book_id = Integer.parseInt(fields[0]);
            this.goodreads_book_id = Integer.parseInt(fields[1]);
            this.best_book_id = Integer.parseInt(fields[2]);
            this.work_id = Integer.parseInt(fields[3]);
            this.books_count = Integer.parseInt(fields[4]);
            this.isbn = Double.parseDouble(fields[5]);
            this.isbn13 = Double.parseDouble(fields[6]);
            this.authors = fields[7];
            this.original_publication_year = Integer.parseInt(fields[8]);
            this.original_title = fields[9];
            this.title = fields[10];
            this.language_code = fields[11];
            this.average_rating = Double.parseDouble(fields[12]);
            this.ratings_count = Integer.parseInt(fields[13]);
            this.work_ratings_count = Integer.parseInt(fields[14]);
            this.work_text_reviews_count = Integer.parseInt(fields[15]);
            this.ratings_1 = Integer.parseInt(fields[16]);
            this.ratings_2 = Integer.parseInt(fields[17]);
            this.ratings_3 = Integer.parseInt(fields[18]);
            this.ratings_4 = Integer.parseInt(fields[19]);
            this.ratings_5 = Integer.parseInt(fields[20]);
            this.image_url = fields[21];
            this.small_image_url = fields[22];
        } catch (Exception e) {
            System.out.println("Error parsing line: " + String.join(",", fields));
            e.printStackTrace();
        }
    }

    //-------------------- main ------------------------
    public static void loadBooks(String filePath) {
        //1: read csv and store it in a linked list
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                // Split on commas not inside quotes
                String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                // Remove quotes from quoted fields
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].replaceAll("^\"|\"$", "");
                }

                if (fields.length < 23) continue;
                BookReader book = new BookReader();
                book.populateFromCSV(fields);
                booksList.add(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //2: set up gui frame:    
        SwingUtilities.invokeLater(() -> {
            new layout(); // Call your GUI class
        });



    }
//---------------- end of main --------------
    @Override
    public String toString() {
        return book_id + ": " + title + " by " + authors + " (Rating: " + ratings_5 + ")" + " isbn: " + isbn;
    }

    public static void main(String[] args) {
        String filePath = "C://Users//peyto//Downloads//Book-15Rows.csv";
        loadBooks(filePath);
        System.out.println("First book loaded: " + booksList.peekFirst());
        sort Sort = new sort();
        Sort.isbnAscending();
        Sort.isbnDescending();
    }


    


}
