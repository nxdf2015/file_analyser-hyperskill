package analyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class GroupWorker {
    private  List<Data> patterns;
    private String namePattern;

    public GroupWorker(String namePattern) {
        this.namePattern = namePattern;
        patterns = new ArrayList<>();
        getPatterns();

    }

    private void getPatterns(){
        try(BufferedReader reader = new BufferedReader((new FileReader(new File(namePattern))))) {
            String line;
            while((line = reader.readLine()) != null){

                String[] d = line.replace("\"","").split(";");

                patterns.add(Data.of(d[0], d[1],d[2]));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(patterns);


    }

    public Callable<Response>  task(File file) {

         List<Callable<Response>> callables =patterns.stream().map(p -> new Worker(p.getByte()))
                 .map( worker -> worker.task(file))
                 .collect(Collectors.toList());

        ExecutorService executorService = Executors.newFixedThreadPool(patterns.size());

        List<Future<Response>> responses = null;
        try {
              responses = executorService.invokeAll(callables);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0 ; i < patterns.size(); i++ ){

            try {
                Response result = responses.get(i).get();
                String type = patterns.get(i).getType();

                if (result.isFind()){
                    result.setType(type);
                    return () -> result;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return () -> Response.of(file.getName(),false,"Unknown file type");
    }
}
