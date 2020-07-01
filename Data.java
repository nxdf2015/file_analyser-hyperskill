package analyzer;

public class Data {
    private String priority,pattern,type;

    public Data(String priority, String pattern, String type) {
        this.priority = priority;
        this.pattern = pattern;
        this.type = type;
    }

    public static Data of(String priority, String pattern, String type) {
        return new Data(priority,pattern,type);

    }

    public byte[] getByte(){
        return pattern.trim().getBytes();
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Data{" +
                "priority='" + priority + '\'' +
                ", pattern='" + pattern + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
