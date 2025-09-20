package pckg;

public class Book {
	
	int bookID;
	int goodreadsBookID;
	int bestBookID;
	int workID;
	
	int booksCount;
	
	String isbn;
	long isbn13;
	
	String authors;
	int originalPublicationYear;
	String originalTitle;
	String title;
	String languageCode;
	
	double averageRating;
	int ratingsCount;
	int workRatingsCount;
	int workTextReviewsCount;
	int ratings1;
	int ratings2;
	int ratings3;
	int ratings4;
	int ratings5;
	
	String imageURL;
	String smallImageURL;
	
	public Book(int bookID, int goodreadsBookID, int bestBookID, int workID, int booksCount, String isbn,
			long isbn13, String authors, int originalPublicationYear, String originalTitle, String title,
			String languageCode, double averageRating, int ratingsCount, int workRatingsCount,
			int workTextReviewsCount, int ratings1, int ratings2, int ratings3, int ratings4, int ratings5,
			String imageURL, String smallImageURL) {
		this.bookID = bookID;
		this.goodreadsBookID = goodreadsBookID;
		this.bestBookID = bestBookID;
		this.workID = workID;
		this.booksCount = booksCount;
		this.isbn = isbn;
		this.isbn13 = isbn13;
		this.authors = authors;
		this.originalPublicationYear = originalPublicationYear;
		this.originalTitle = originalTitle;
		this.title = title;
		this.languageCode = languageCode;
		this.averageRating = averageRating;
		this.ratingsCount = ratingsCount;
		this.workRatingsCount = workRatingsCount;
		this.workTextReviewsCount = workTextReviewsCount;
		this.ratings1 = ratings1;
		this.ratings2 = ratings2;
		this.ratings3 = ratings3;
		this.ratings4 = ratings4;
		this.ratings5 = ratings5;
		this.imageURL = imageURL;
		this.smallImageURL = smallImageURL;
	}
	
	// Simple constructor
	public Book(int bookID, String isbn, String authors, int initialPublicationYear, String title,
			String languageCode,double averageRating) {
		
		this.bookID = bookID;
		this.isbn = isbn;
		this.authors = authors;
		this.originalPublicationYear = initialPublicationYear;
		this.title = title;
		this.languageCode = languageCode;
		this.averageRating = averageRating;
	}
	
    // Getters and setters
    public int getBookId() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthors() { return authors; }
    public double getAverageRating() { return averageRating; }
    public String getIsbn() { return isbn; }
	
	@Override
    public String toString() {
        return bookID + ": " + title + " by " + authors + " (Rating: " + averageRating + ")";
    }
	
	// toString() alternative implementation for debugging
	public String toStringLong() {
		return "book_id: " + bookID + " " +
			"goodreads_book_id: " + goodreadsBookID + " " +
			"best_book_id: " + bestBookID + " " +
			"work_id: " + workID + " " +
			"books_count: " + booksCount + " " +
			"isbn: " + isbn + " " +
			"isbn13: " + isbn13 + " " +
			"authors: " + authors + " " +
			"original_publication_year: " + originalPublicationYear + " " +
			"original_title: " + originalTitle + " " +
			"title: " + title + " " +
			"language_code: " + languageCode + " " +
			"average_rating: " + averageRating + " " +
			"ratings_count: " + ratingsCount + " " +
			"work_ratings_count: " + workRatingsCount + " " +
			"work_text_reviews_count: " + workTextReviewsCount + " " +
			"ratings1: " + ratings1 + " " +
			"ratings2: " + ratings2 + " " +
			"ratings3: " + ratings3 + " " +
			"ratings4: " + ratings4 + " " +
			"ratings5: " + ratings5 + " " +
			"image_url: " + imageURL + " " +
			"small_image_url: " + smallImageURL;
		}
}
