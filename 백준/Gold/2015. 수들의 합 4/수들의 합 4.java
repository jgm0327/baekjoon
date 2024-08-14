import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        long[] prefix = new long[n + 1];
        tokenizer = new StringTokenizer(br.readLine());
        
        for(int i=0 ; i<n ; i++){
            prefix[i + 1] = prefix[i] + Integer.parseInt(tokenizer.nextToken());
        }
        
        long answer = 0;
        Map<Long, Integer> count = new HashMap<>();
        count.put(0L, 1);

        for(int i=1 ; i<=n ; i++){
            answer += count.getOrDefault(prefix[i] - k, 0);
            count.put(prefix[i], count.getOrDefault(prefix[i], 0) + 1);

        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();

        br.close();
    }

}