public class Book implements Comparable{
    int id;
    int score;

    @Override
    public boolean equals(Object obj) {
        if (obj == null ||!(obj instanceof Book))
            return false;
        Book other = (Book) obj;
        return id == other.id;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof Book))
            System.out.println("Fuck u");
        Book other = (Book)o;
        return score-other.score;
    }
}
