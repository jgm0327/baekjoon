import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        int[][] count = new int[26][S.length() + 1];

        for(int i=0 ; i<S.length() ; i++){
            int ch = S.charAt(i) - 'a';
            
            for(int j=0 ; j<26 ; j++){
                if(ch == j)count[j][i + 1] = count[j][i] + 1;
                else count[j][i + 1] = count[j][i];
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while(q-- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int idx = tokenizer.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(tokenizer.nextToken()) + 1;
            int end = Integer.parseInt(tokenizer.nextToken()) + 1;

            answer.append(count[idx][end] - count[idx][start - 1]).append("\n");
        }

        System.out.print(answer);
        

        br.close();
    }

}