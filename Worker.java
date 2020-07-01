package analyzer;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Worker {
    private Search search ;
    private byte[] pattern;

    public Worker(byte[] pattern) {
        this.search = new KMPSearch();
        this.pattern=pattern;
    }

    public  Callable<Response> task( File file){
        return new Callable<Response>() {
            @Override
            public Response call() throws Exception {
                byte[] bytes;
                try(BufferedInputStream in  = new BufferedInputStream(new FileInputStream(file))) {
                    bytes  = in.readAllBytes();


                    return  Response.of(file.getName() , search.find(bytes,pattern));


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                    return Response.of(file.getName(),false);

            }

        };
    }
}
