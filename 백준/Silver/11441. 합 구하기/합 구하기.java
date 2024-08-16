import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[] prefix = new int[n + 1];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++){
            prefix[i] = prefix[i - 1] + Integer.parseInt(tokenizer.nextToken());
        }
        
        int q = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(q-- > 0){
            tokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            answer.append(prefix[end] - prefix[start - 1]).append("\n");
        }

        System.out.print(answer);

        br.close();
    }

}