

public class sort {

// if you implement this you probably will need to change BookReader is my class and my linkedlist name is booksList
    public void alphabeticallyAscending(){
        boolean swapped;
        int n = BookReader.booksList.size();
        do{
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                BookReader current = BookReader.booksList.get(i);
                BookReader next = BookReader.booksList.get(i+1);

                if(current.authors.compareToIgnoreCase(next.authors) > 0){
                    //swaps if out of order
                    BookReader.booksList.set(i, next);
                    BookReader.booksList.set(i+1, current);
                    swapped = true;
                }
            }

        }while (swapped); // this makes the "do" run as long as the condition works 
        //If you want to check: System.out.println(BookReader.booksList);
    }
    public void alphabeticallyDescending(){
        boolean swapped;
        int n = BookReader.booksList.size();
        do{
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                BookReader current = BookReader.booksList.get(i);
                BookReader next = BookReader.booksList.get(i+1);

                if(current.authors.compareToIgnoreCase(next.authors) < 0){
                    //swaps if out of order
                    BookReader.booksList.set(i, next);
                    BookReader.booksList.set(i+1, current);
                    swapped = true;
                }
            }

        }while (swapped); // this makes the "do" run as long as the condition works 
    }
}


