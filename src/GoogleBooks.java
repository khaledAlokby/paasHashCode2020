import java.util.*;

public class GoogleBooks {
    static int bookNumber;
    static int librariesNum;
    static int daysToEnd;
    static Map<Integer,Book> allBooks = new HashMap<>();
    static List<Library> libraries = new ArrayList<>();
    static HashSet<Library> scannedLibraries = new HashSet<>();
    static Set<Book> scannedGlobal = new HashSet<>();
}
