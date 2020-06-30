package analyzer;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();
        parser.parse(args);

            String nameFile = parser.getFileName();
            String pattern = parser.getPattern();
            String type = parser.getType();
            String algorithme = parser.getAlgorithme();

            byte[]  model = pattern.substring(0,pattern.length()-1).trim().getBytes();
            byte[] bytes = null;
            Search search = Search.create(algorithme);
            TimeSearch timeSearch = new TimeSearch(search);

            try(BufferedInputStream in  = new BufferedInputStream(new FileInputStream(new File(nameFile)))) {
                 bytes  = in.readAllBytes();

               boolean find = timeSearch.find(bytes,model);

                if (find){
                    System.out.println(type);
                }
                else {
                    System.out.println("Unknown file type");
                }
                System.out.println("it took "+timeSearch.getTimeSearch().withMinute(0).withHour(0)+" seconds");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



    }
}
