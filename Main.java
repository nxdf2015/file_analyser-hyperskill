package analyzer;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();
        parser.parse(args);

            String nameFile = parser.getFileName();
            String pattern = parser.getPattern();

            String algorithme = "kmp";

            //byte[]  model = pattern.substring(0,pattern.length()-1).trim().getBytes();
            byte[] bytes = null;

            Workers workers = new Workers(nameFile,pattern);

            Response[] responses = workers.start();

            for(Response response : responses){
                String resultSearch = response.isFind() ? response.getType() : "Unknown file type";
                System.out.printf(response.getName()+": "+resultSearch );
                System.out.println();
            }




    }
}
