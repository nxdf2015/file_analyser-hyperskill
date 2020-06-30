package analyzer;

public class KMPSearch extends Search {

    @Override
    public boolean find(byte[] text, byte[] pattern) {
        int[] functionPrefix = prefix(pattern);
        int j =0;
        int count = 0;
        for(int i = 0 ; i < text.length ; i++ ){


            while( j > 0 && text[i] != pattern[j]){
                j = functionPrefix[j - 1];
            }
            if ( text[i] ==pattern[j]){
                j += 1;
            }

            if ( j == pattern.length){

                return  true;
            }

        }

        return false;
    }

    private  int[] prefix(byte[] pattern) {
        int[] functionPrefix = new int[pattern.length];
        int j ;

        for(int  i = 1 ; i < pattern.length ; i++ ){
            j = functionPrefix[i-1];

            while( j >  0 && pattern[j] != pattern[i]){
                j = functionPrefix[j - 1];
            }
            if (pattern[i] == pattern[j]){
                j += 1;
            }

            functionPrefix[i] = j;
        }
        return functionPrefix;
    }
}
