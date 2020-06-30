package analyzer;

import java.time.LocalTime;

public class TimeSearch extends Search{
    private Search search;
    private LocalTime timeSearch;

    public TimeSearch(Search search) {
        this.search = search;
    }

    @Override
    public boolean find(byte[] text, byte[] pattern) {
        long start = System.nanoTime();

         boolean findPattern  = search.find(text,pattern);
        long stop = System.nanoTime();

        timeSearch  = LocalTime.ofNanoOfDay(stop - start);
        return findPattern;


    }

    public LocalTime getTimeSearch() {
        return timeSearch;
    }
}
