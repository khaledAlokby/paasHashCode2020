import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Logic {
    static int day=0;
    public static void startLogic(){
        List<Library> output = new ArrayList<>();
        GoogleBooks.libraries.sort(new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                return o1.maxScore(0) - o2.maxScore(0);
            }
        });
        while (day <= GoogleBooks.daysToEnd){
            //maybe we need to dump the equal sign
            Library optLibrary = null;
            for (int i = 0; i < GoogleBooks.libraries.size(); i++) {
                 if (GoogleBooks.scannedLibraries.contains(GoogleBooks.libraries.get(i)))
                     continue;
                 optLibrary = GoogleBooks.libraries.get(i);
            }
            if (optLibrary == null)
                break;
            optLibrary.scan(day);
            day += optLibrary.signUpProcess;
            output.add(optLibrary);
            GoogleBooks.scannedLibraries.add(optLibrary);
            GoogleBooks.libraries.sort(new Comparator<Library>() {
                @Override
                public int compare(Library o1, Library o2) {
                    return o1.maxScore(day) - o2.maxScore(day);
                }
            });
        }

        IO.writeOutPutToFile(output);
    }

}
