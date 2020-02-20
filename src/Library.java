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
        optimalBooks = booksMax;
        for (int i = 0; i < booksMax; i++) {
             result += books.get(i).score;
        }
        return result;
    }


}
