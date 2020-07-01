package analyzer;

public class Response {
    private String file;
    private boolean find;

    public Response(String name, boolean find) {
        this.file = name;
        this.find = find;
    }

    public static Response of(String name, boolean find) {
        return new Response(name,find);
    }

    public boolean isFind() {
        return find;
    }

    public String getName() {
        return file;
    }
}
