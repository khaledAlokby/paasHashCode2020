import java.util.Comparator;

public class Logic {
    static int day=0;
    public static void startLogic(){
        GoogleBooks.libraries.sort(new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                return o1.maxScore() - o2.maxScore();
            }
        });
        while (day <= GoogleBooks.daysToEnd){
            //maybe we need to dump the equal sign

        }
    }

}
