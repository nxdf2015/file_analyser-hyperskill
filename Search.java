package analyzer;

public abstract class Search {
    public static Search create(String type){
        Search algo ;
        if (type.equals("naive")){
            algo = new NaiveSearch();
        }
        else {
           algo = new KMPSearch();
        }
        return algo;
    }
    public abstract  boolean find(byte[] text , byte[]  pattern);
}
