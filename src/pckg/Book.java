package pckg;

public class Book {
	
	int bookID;
	int goodreadsBookID;
	int bestBookID;
	int workID;
	
	int booksCount;
	
	String isbn;
	String isbn13;
	
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
			String isbn13, String authors, int originalPublicationYear, String originalTitle, String title,
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
	
	@Override
	public String toString() {
		return bookID +
		goodreadsBookID +
		bestBookID +
		workID +
		booksCount +
		isbn +
		isbn13 +
		authors +
		originalPublicationYear +
		originalTitle +
		title +
		languageCode +
		averageRating +
		ratingsCount +
		workRatingsCount +
		workTextReviewsCount +
		ratings1 +
		ratings2 +
		ratings3 +
		ratings4 +
		ratings5 +
		imageURL;
	}
}
