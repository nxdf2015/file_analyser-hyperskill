package analyzer;

import java.util.Arrays;

public class NaiveSearch extends Search {


    @Override
    public boolean find(byte[] bytes, byte[] model) {
        int sizeModel = model.length;

        for(int i = 0 ; i < bytes.length - sizeModel ; i++ ){
            byte[] extract = Arrays.copyOfRange(bytes, i , i + sizeModel);
            for(int j = 0; j < model.length;j++){
                System.out.print(model[j]);
            }

            if (Arrays.compare(extract, model) == 0){
               return true;
            }


        }
        return false;
    }
}
