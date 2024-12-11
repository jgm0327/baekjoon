import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while(T-- > 0){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());

            int[] arr = new int[n];
            tokenizer = new StringTokenizer(br.readLine());
            for(int i=0 ; i<n ; i++){
                arr[i] = Integer.parseInt(tokenizer.nextToken());
            }

            long[] prefix = new long[n+m];
            for(int i=1 ; i<n+m ; i++){
                prefix[i] = prefix[i - 1] + arr[i % n];
            }
            
            int count = 0;
            for(int i=0 ; i<n ; i++){
                if(prefix[i + m] - prefix[i] >= k)
                    continue;

                count++;
            }

            if(count != 0 && m == n)
                count = 1;
                
            answer.append(count).append("\n");
        }

        bw.write(answer.toString());
        bw.close();
        br.close();
    }
}