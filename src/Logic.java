import java.util.Comparator;
import java.util.List;

public class Logic {
    static int day=0;
    public static void startLogic(){
        List<Library>
        GoogleBooks.libraries.sort(new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                return o1.maxScore(0) - o2.maxScore(0);
            }
        });
        while (day <= GoogleBooks.daysToEnd){
            //maybe we need to dump the equal sign

        }
    }

}
