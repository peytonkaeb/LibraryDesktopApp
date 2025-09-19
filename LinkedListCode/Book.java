


public class Book {
        private int book_id;	
        private int goodreads_book_id;	
        private int best_book_id;	
        private int work_id;	
        private int books_count;	
        private double isbn;	
        private double isbn13;	
        private String  authors;	
        private int original_publication_year;	
        private String original_title;	
        private String title;	
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

    //creating book objects
    public Book(String[] fields){
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

    }
        // Getters and setters
    public int getBookId() { return book_id; }
    public String getTitle() { return title; }
    public String getAuthors() { return authors; }
    //public double getAverageRating() { return ratings_5; }
    public double getIsbn() { return isbn; }

    @Override
    public String toString() {
        return book_id + ": " + title + " by " + authors + " (Rating: " + ratings_5 + ")";
    }
}



