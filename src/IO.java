import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
        String[] meta = st.split(" ");

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

    public static void write2file() throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(outputFile,false), StandardCharsets.UTF_8);
        out.flush();
        out.write("here we go");
        out.close();
    }

}