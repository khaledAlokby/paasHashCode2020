import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class IO {
    static String inputFile;
    static String outputFile;
    public static void main(String[] args) throws IOException {
        URL propertiesUrl = IO.class.getResource("config.properties");
        try (InputStream input = new FileInputStream(propertiesUrl.getPath())) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            inputFile = prop.getProperty("input");
            System.out.println(inputFile);
            outputFile = prop.getProperty("output");
            System.out.println(outputFile);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        URL url = IO.class.getResource(inputFile);
        File file = new File(url.getPath());
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        st = br.readLine();
        if (st == null)
            System.exit(-1);
        String[] firstLine = st.split(" ");
        GoogleBooks.bookNumber = Integer.valueOf(firstLine[0]);
        GoogleBooks.librariesNum = Integer.valueOf(firstLine[1]);
        GoogleBooks.daysToEnd = Integer.valueOf(firstLine[2]);
        st = br.readLine();
        String[] booksScores = st.split(" ");
        for (int i = 0; i < GoogleBooks.bookNumber; i++) {
            Book book = new Book();
            book.id = i;

            book.score = Integer.valueOf(booksScores[i]);
            GoogleBooks.allBooks.put(book.id,book);
        }
        for (int i = 0; i < GoogleBooks.librariesNum; i++) {
            st = br.readLine();
            String[] libInfo = st.split(" ");
            Library library = new Library();
            library.id = i;
            library.numOfBooks = Integer.valueOf(libInfo[0]);
            library.signUpProcess = Integer.valueOf(libInfo[1]);
            library.booksPerDay = Integer.valueOf(libInfo[2]);
            st = br.readLine();
            String[] booksInLib = st.split(" ");
            for (int j = 0; j < library.numOfBooks; j++) {
                int bookId = Integer.valueOf(booksInLib[j]);
                library.books.add(GoogleBooks.allBooks.get(bookId));
            }
            GoogleBooks.libraries.add(library);
        }
        Logic.startLogic();

       /* PizzaHandler.Maximum = Integer.valueOf(meta[0]);
        PizzaHandler.typesSize = Integer.valueOf(meta[1]);
        PizzaHandler.pizzas = new int[PizzaHandler.typesSize];
        st = br.readLine();
        String[] strPizzas = st.split(" ");
        for (int i = 0; i < PizzaHandler.typesSize; i++) {
            PizzaHandler.pizzas[i] = Integer.valueOf(strPizzas[i]);
        }
        PizzaHandler.optemizeSlices();*/

        br.close();
    }

    public static void writeOutPutToFile (List<Library> libs){
        Path path = Paths.get("c:/output.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            List<OutPutFile> outPouts = LibraryOutPut.generateOutPutList(libs);
            writer.write(libs.size());
            writer.newLine();
            for(OutPutFile o : outPouts){
                writer.write(o.getIdAndBooksNum());
                writer.newLine();
                writer.write(o.getBooksIds());
                writer.newLine();
            }
        }
        catch (Exception e){

        }
    }

}