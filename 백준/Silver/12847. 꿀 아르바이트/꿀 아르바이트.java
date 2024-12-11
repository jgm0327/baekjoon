import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        long[] prefix = new long[n + 1];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++){
            prefix[i + 1] = prefix[i] + Integer.parseInt(tokenizer.nextToken());
        }

        long answer = 0;
        for(int i=m ; i<=n ; i++){
            answer = Math.max(answer, prefix[i] - prefix[i - m]);
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}