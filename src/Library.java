import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    int id;
    int numOfBooks;
    int signUpProcess;
    int booksPerDay;
    List<Book> books = new ArrayList<>();
    public int workingDays(){
        return GoogleBooks.daysToEnd-signUpProcess;
    }
    public int maxScore(){
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.score-o2.score;
            }
        });
        int result = 0;
        int booksMax = booksPerDay*workingDays();
        for (int i = 0; i < booksMax; i++) {
             result += books.get(i).score;
        }
        return result;
    }

}
