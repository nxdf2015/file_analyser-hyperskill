package analyzer;

public class Response {
    private String file;
    private boolean find;
    private String type;


    public Response(String name, boolean find) {
        this.file = name;
        this.find = find;

    }

    public Response(String name, boolean find, String type) {
        this.file = name;
        this.find = find;
        this.type = type;
    }

    public static Response of(String name, boolean find) {
        return new Response(name,find);
    }

    public static Response of(String name, boolean find , String type) {
        return new Response(name,find,type);
    }

    public boolean isFind() {
        return find;
    }

    public String getName() {
        return file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Response{" +
                "file='" + file + '\'' +
                ", find=" + find +
                ", type='" + type + '\'' +
                '}';
    }
}
