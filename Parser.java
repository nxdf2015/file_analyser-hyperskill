package analyzer;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    private Map<String   ,String > options;
    private String algorithme;
    private String fileName;
    private String pattern;
    private String type;

    public Parser() {
        this.options = new HashMap<>();
    }

    public void parse(String[] args){
       algorithme = args[0].substring(2,args[0].length());
       fileName = args[1];
       pattern = args[2];
       type = args[3];
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public String getAlgorithme() {
        return algorithme;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPattern() {
        return pattern;
    }

    public String getType() {
        return type;
    }
}
