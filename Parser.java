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

       fileName = args[0];
       pattern = args[1];
       type = args[2];
    }

    public Map<String, String> getOptions() {
        return options;
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
