import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[] prefix = new int[n + 1];
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for(int i=1 ; i<=n ; i++){
                prefix[i] = prefix[i - 1] + Integer.parseInt(tokenizer.nextToken());
            }

            int max = -1000_001;
            for(int i=1 ; i<=n ; i++){
                for(int j=0 ; j<i ; j++){
                    max = Math.max(max, prefix[i] - prefix[j]);
                }
            }

            answer.append(max).append("\n");
        }

        System.out.print(answer);

        br.close();
    }

}