import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int T = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
        for(int i=0 ; i<n ; i++){
            tokenizer = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(tokenizer.nextToken());
            int p = Integer.parseInt(tokenizer.nextToken());

            pq.add(new long[]{w, p});
        }

        long cnt = T - pq.size();
        long answer = 0;
        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            answer += cur[0] + cur[1] * cnt;
            cnt++;
        }
        
        System.out.println(answer);

        br.close();
    }
}