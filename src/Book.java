public class Book {
    int id;
    int score;

    @Override
    public boolean equals(Object obj) {
        if (obj == null ||!(obj instanceof Book))
            return false;
        Book other = (Book) obj;
        return id == other.id;
    }
}
