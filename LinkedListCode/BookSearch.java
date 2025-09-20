
//using book ID or isbn
public class BookSearch {

    public BookReader BookSearch(int book_id){
            for (BookReader book : BookReader.booksList) {
            if (book.book_id == book_id){
                return book; // Found the book
            }
        }
        return null; // Not found  
    }
    public BookReader BookSearch(double isbn){
            for (BookReader book : BookReader.booksList) {
            if (book.isbn == isbn){
                return book; // Found the book
            }
        }
        return null; // Not found
    }    
}
    

