import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    int id;
    int numOfBooks;
    int signUpProcess;
    int booksPerDay;
    int optimalBooks;
    List<Book> books = new ArrayList<>();
    List<Book> scannedBooks = new ArrayList<>();
    public int workingDays(int day){
        return GoogleBooks.daysToEnd-signUpProcess-day;
    }
    public int maxScore(int day){
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.score-o2.score;
            }
        });
        int result = 0;
        int booksMax = booksPerDay*workingDays(day);
        optimalBooks = Math.min(booksMax,numOfBooks);
        for (int i = 0; i < optimalBooks; i++) {
             result += books.get(i).score;
        }
        return result;
    }

    public void scan(int day){
        maxScore(day);
        int diff=0;
        for (int i = 0; i < optimalBooks+diff; i++) {
            if (i >= books.size())
                break;
            if (GoogleBooks.scannedGlobal.contains(books.get(i))){
                diff++;
                continue;
            }
            scannedBooks.add(books.get(i));
        }
    }
}
