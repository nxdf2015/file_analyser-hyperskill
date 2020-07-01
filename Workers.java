package analyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Workers {
    private File[] files;
    private String pattern, type;
    private Worker search;
    public Workers(String nameFolder,byte[] pattern){
        files = new File(nameFolder).listFiles();
        search = new Worker(pattern);
    }



    private Callable<Response> worker(File file){
        return search.task(file);
    }
    public Response[]   start(){

        ExecutorService executors = Executors.newFixedThreadPool(files.length);
        List<Future<Response>>  results = null ;
        Response[] responses = new Response[files.length];

        List<Callable<Response>> tasks =new ArrayList<>();
        for(File file : files){

            tasks.add(worker(file));
        }
        try {
             results = executors.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       for(int i = 0 ; i < results.size() ; i++){
           try {
               Response  response = results.get(i).get();
               responses[i] = response;

           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
       }
       return responses;
    }
}
